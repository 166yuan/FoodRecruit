package com.recruit.controller;

import com.recruit.base.PageBean;
import com.recruit.bean.MyTeamBean;
import com.recruit.bean.TeamBean;
import com.recruit.impl.CompetAndTeamImpl;
import com.recruit.impl.CompetitionImpl;
import com.recruit.impl.TeamImpl;
import com.recruit.impl.UserImpl;
import com.recruit.model.CompetAndTeam;
import com.recruit.model.Competition;
import com.recruit.model.Team;
import com.recruit.model.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2015/2/24.
 */
@Controller
@RequestMapping("/compet")
public class ComController {

    /**
     * 竞赛发布页面
     * @return
     */
    @RequestMapping("publish")
    public String publishCompetition(){
    return "View/compet/publishCompet";
    }



    /**
     * 取得所有的竞赛
     * @param model
     * @return
     */
    @RequestMapping("getAll")
    public String getAllCompet(int page,Model model){
        CompetitionImpl cml=CompetitionImpl.getInstance();
        List<Competition>list= new ArrayList<Competition>();
        PageBean pageBean=PageBean.getInstance(1,0,"/compet","/getAll");
        try {
            cml.startTransaction();
            int total=cml.getSize();
            pageBean=PageBean.getInstance(page,total,"/compet","/getAll");
            list = cml.getAllCompetition(pageBean);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cml.commitTransaction();
        }
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("list",list);
        return "View/compet/competList";
    }

    /**
     * 竞赛查看，查看单个竞赛
     * @param id 竞赛id
     * @param model
     * @return
     */
    @RequestMapping("getById")
    public String getCompetitionById(Integer id,Model model){
        CompetitionImpl cml=CompetitionImpl.getInstance();
        cml.startTransaction();
        Competition competition=cml.getById(id);
        model.addAttribute("competition",competition);
        cml.commitTransaction();
    return "View/compet/competition";
    }

    /**
     * 竞赛报名页面
     * @param session
     * @param model
     * @param id 竞赛id
     * @return 报名页面
     */
    @RequestMapping("attend")
    public String attendCompetition(HttpSession session,Model model,Integer id){
        Integer uid=(Integer)session.getAttribute("userId");
        String result;
        if(uid==null){
            //用户未登录，去登录界面
            return  "View/compet/unlogin";
        }else{
            UserImpl uml=UserImpl.getInstance();
            uml.startTransaction();
            User user=uml.getById(uid);
            uml.commitTransaction();
            model.addAttribute("user",user);

            CompetitionImpl cml=CompetitionImpl.getInstance();
            cml.startTransaction();
            Competition competition=cml.getById(id);
            cml.commitTransaction();
            model.addAttribute("competition",competition);
            TeamImpl tml=TeamImpl.getInstance();
            tml.startTransaction();
            List<Team>list=tml.findByComId(1);
            tml.commitTransaction();
            model.addAttribute("teamList",list);
           return "View/compet/attendance";
        }
    }

    /**
     * 新增竞赛队伍
     * @param comId 竞赛id
     * @param name 队伍名称
     * @param slogan 队伍口号
     * @param password 密码
     * @param number 队伍最大人数
     * @param session
     * @return
     */

    @RequestMapping(value = "newteam")
    public void newTeam(Integer comId,String name,String slogan,String password,int number,HttpSession session,PrintWriter out){
        System.out.println("name:"+name);
        Integer idtemp=null;
        TeamImpl tml=TeamImpl.getInstance();
        UserImpl uml=UserImpl.getInstance();
        Integer uid=(Integer)session.getAttribute("userId");
        uml.startTransaction();
        User user=uml.getById(uid);
        uml.commitTransaction();
        CompetAndTeam competAndTeam=new CompetAndTeam();
         try{
             Team team=new Team();
             team.setName(name);
             team.setLeader(user);
             team.setSlogan(slogan);
             team.setPassword(password);
             team.setMaxSize(number);
             if (number==1){
                 team.setType(1);
             }else {
                 team.setType(0);
             }
             CompetitionImpl cml=CompetitionImpl.getInstance();
             cml.startTransaction();
             Competition competition=cml.getById(comId);
             cml.commitTransaction();
             team.setCompetition(competition);
             tml.startTransaction();
             tml.save(team);
             tml.commitTransaction();
             idtemp=team.getId();
             competAndTeam.setTeam(team);
             competAndTeam.setUser(user);
             CompetAndTeamImpl ctml=CompetAndTeamImpl.getInstance();
             ctml.startTransaction();
             ctml.save(competAndTeam);
             ctml.commitTransaction();
         }catch (Exception e){
            e.printStackTrace();
         }
        out.print(1);
    }

    /**
     * 获取所有队伍的名称
     * @param id
     * @return json到前端
     */
    @RequestMapping("getTeamNames")
    public @ResponseBody List<Team> getTeamName(Integer id){
        TeamImpl tml=TeamImpl.getInstance();
        tml.startTransaction();
        List<Team>list=tml.findByComId(id);
        tml.commitTransaction();
        return list;
    }

    /**
     * 加入已存在队伍
     * @param name 队伍名称
     * @param password 入队密码
     * @param comId 竞赛id
     * @param out
     * @param session
     */
    @RequestMapping("joinTeam")
    public void join(Integer teamId,String password,PrintWriter out,HttpSession session){
     int result=1;
        TeamImpl tml=TeamImpl.getInstance();
        UserImpl uml= UserImpl.getInstance();
        Integer uid=(Integer)session.getAttribute("userId");
        uml.startTransaction();
        User user=uml.getById(uid);
        uml.commitTransaction();
        try {
            tml.startTransaction();
            Team team = tml.getById(teamId);
            if (team == null) {
                //找不到队伍
                result = -1;
            } else {
                if (!team.getPassword().equals(password)) {
                    //密码不正确
                    result = -2;
                } else {
                    if(tml.exitMember(uid,team)){
                        //您已经报过名了
                        result=-4;
                    }else
                    if (team.getType() == 1) {
                        //队伍已满
                        result = -3;
                    } else {
                        if(team.getParticipants().size()+1==team.getMaxSize()) {
                            team.setType(1);
                            tml.update(team);
                        }
                        tml.commitTransaction();
                        CompetAndTeam competAndTeam=new CompetAndTeam();
                        competAndTeam.setUser(user);
                        competAndTeam.setTeam(team);
                        CompetAndTeamImpl catl=CompetAndTeamImpl.getInstance();
                        catl.startTransaction();
                        catl.save(competAndTeam);
                        catl.commitTransaction();
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        out.print(result);
    }

    /**
     * 获取用户参与的所有竞赛
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("mycompet")
    public String myCompetition(HttpSession session,Model model,int page){
        if(page==0){
            page=1;
        }
        Integer userId=(Integer)session.getAttribute("userId");
        UserImpl uml=UserImpl.getInstance();
        CompetAndTeamImpl ctml=CompetAndTeamImpl.getInstance();
        PageBean pageBean=PageBean.getInstance(1,0,"/compet","/mycompet");
        User user=new User();
        try {
            uml.startTransaction();
            user=uml.getById(userId);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            uml.commitTransaction();
        }
        List<CompetAndTeam> list= null;
        try {
            ctml.startTransaction();
            int total=ctml.getSize();
            pageBean=PageBean.getInstance(page,total,"/compet","/mycompet");
            list=ctml.getByUser(user,pageBean);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        model.addAttribute("list",list);
        return "View/compet/myCompet";
    }

    /**
     * 用户现在参与的竞赛
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("nowCompet")
    public String CompetitionOnGoing(HttpSession session,Model model,int page){
        if(page==0){
            page=1;
        }
        Integer userId=(Integer)session.getAttribute("userId");
        UserImpl uml=UserImpl.getInstance();
        CompetAndTeamImpl ctml=CompetAndTeamImpl.getInstance();
        PageBean pageBean=PageBean.getInstance(1,0,"/compet","/mycompet");
        User user=new User();
        try {
            uml.startTransaction();
            user=uml.getById(userId);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            uml.commitTransaction();
        }
        List<CompetAndTeam> list= null;
        try {
            ctml.startTransaction();
            int total=ctml.getSize();
            pageBean=PageBean.getInstance(page,total,"/compet","/mycompet");
            list=ctml.getByUser(user,pageBean);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        model.addAttribute("list",list);
        return "View/compet/goingCompet";
    }

    /**
     * 用户过去参与的竞赛
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("passCompet")
    public String pastCompetition(HttpSession session,Model model,int page){
       /* Long userId=(Long)session.getAttribute("userId");
        TeamComDao teamComDao=TeamComDao.getInstance();
        List<CompetAndTeam> list=teamComDao.getByUser(userId);
        List<ComTeamBean>list1=ComTeamBean.buildList1(list);
        model.addAttribute("list",list1);*/
        return "View/compet/pastCompet";
    }

    /**
     * 查看队伍信息
     * @param teamId 队伍id
     * @param comId 竞赛id
     * @param model
     * @return
     */
    @RequestMapping("showTeam")
    public String showTeam(Integer teamId,Model model){
        TeamImpl tml=TeamImpl.getInstance();
        Team team=null;
        MyTeamBean myTeamBean=null;
        try{
          team=tml.getById(teamId);
            myTeamBean=tml.buildMyTeam(team);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            tml.commitTransaction();
        }
        model.addAttribute("team",myTeamBean);
        return "View/compet/myTeam";
    }

    /**
     * 新增竞赛
     * @param request 文件上传
     * @param name 竞赛名
     * @param daterange 时间范围
     * @param minnumber 每队最小人数
     * @param maxnumber 每队最大人数
     * @param description 竞赛描述
     * @param model
     * @return
     */
    @RequestMapping("addCompet")
    public String addCompetition(DefaultMultipartHttpServletRequest request,String name,String daterange,int minnumber,int maxnumber,String description,Model model){
        CommonsMultipartFile file=(CommonsMultipartFile)request.getFile("file");
        File uploadFile=null;
        //判断用户是否上传了logo图片，有才保存地址
        if(file!=null) {
            try {
                String fileName = request.getRealPath("/images/") + File.separator + System.currentTimeMillis() + file.getOriginalFilename().
                        substring(file.getOriginalFilename().lastIndexOf("."));
                uploadFile = new File(fileName);
                FileCopyUtils.copy(file.getBytes(), uploadFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //日期格式化
        String date[]=daterange.split("-");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Competition competition=new Competition();
        CompetitionImpl cml=CompetitionImpl.getInstance();
        try {
            cml.startTransaction();
            Date date1=sdf.parse(date[0]);
            Date date2=sdf.parse(date[1]);
            competition.setName(name);
            competition.setInformation(description);
            competition.setBeginTime(date1);
            competition.setEndTime(date2);
            competition.setMinNumber(minnumber);
            competition.setMaxNumber(maxnumber);
            if(uploadFile!=null){
                competition.setImage_url("/images/"+uploadFile.getName());
            }
            model.addAttribute("competition",competition);
            cml.save(competition);
            cml.commitTransaction();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "View/compet/competition";

    }

    /**
     * 跳转到竞赛更新页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("update")
    public String updateCompetition(Integer id,Model model){
        CompetitionImpl cml=CompetitionImpl.getInstance();
        Competition competition= new Competition();
        try {
            cml.startTransaction();
            competition = cml.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cml.commitTransaction();
        }
        model.addAttribute("competition",competition);
        return "View/compet/editCompet";
    }

    /**
     * 更新竞赛
     * @param request
     * @param name
     * @param daterange
     * @param minnumber
     * @param maxnumber
     * @param description
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("doUpdate")
    public String doUpdateCompetition(DefaultMultipartHttpServletRequest request,String name,String daterange,int minnumber,int maxnumber,String description,long id,Model model){
        System.out.println("the content is:"+description);
        CommonsMultipartFile file = (CommonsMultipartFile)request.getFile("file");
        File uploadFile = null;

        System.out.println("id = " + id);
/*

        ComDao comDao = ComDao.getInstance();
        Competition competition = comDao.get(id);

        if (file.getOriginalFilename().length() > 0){
            try {
                //删除旧文件
                if (competition.getImage_url() != null) {
                    File oldFile = new File(competition.getImage_url());
                    oldFile.delete();
                }

                System.out.println(file);

                System.out.println(file.getName() + " 1 " + file.getOriginalFilename() + " 2 " + competition.getImage_url());

                String fileName = request.getRealPath("/images/") + File.separator + System.currentTimeMillis() + file.getOriginalFilename().
                        substring(file.getOriginalFilename().lastIndexOf("."));
                uploadFile = new File(fileName);
                FileCopyUtils.copy(file.getBytes(), uploadFile);

            }catch (IOException ex){
                ex.printStackTrace();
            }
        }

        String date[]=daterange.split("-");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        try {
            comDao.begin();
            Date date1 = sdf.parse(date[0]);
            Date date2 = sdf.parse(date[1]);
            competition.setName(name);
            competition.setInformation(description);
            competition.setBeginTime(date1);
            competition.setEndTime(date2);
            competition.setMinNumber(minnumber);
            competition.setMaxNumber(maxnumber);
            if(uploadFile!=null){
                competition.setImage_url("/images/"+uploadFile.getName());
            }
            comDao.update(competition);
            comDao.commit();

            model.addAttribute("competition",competition);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            comDao.close();
        }
*/

        return "/View/compet/competition";
    }

    @RequestMapping("delete")
    public void delete(Integer id,PrintWriter out){
        int result=1;
        CompetitionImpl cml=CompetitionImpl.getInstance();
        try{
            cml.startTransaction();
            cml.delete(id);
        }catch (Exception e){
            e.printStackTrace();
            result=-1;
        }finally {
            cml.commitTransaction();
        }
        out.print(result);
    }
    @RequestMapping("getTeamById")
    public @ResponseBody TeamBean getTeamById(Integer teamId){
        TeamImpl tml=TeamImpl.getInstance();
        tml.startTransaction();
        TeamBean teamBean=tml.build(tml.getById(teamId));
        tml.commitTransaction();
        return teamBean;
    }
}
