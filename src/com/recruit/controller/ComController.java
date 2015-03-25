package com.recruit.controller;

import com.recruit.base.BaseController;
import com.recruit.bean.PageBean;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

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
public class ComController extends BaseController {

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
        List<Competition>list= new ArrayList<Competition>();
        PageBean pageBean=PageBean.getInstance(1,0,"/compet","/getAll");
        try {
            int total=competitionDao.getSize();
            pageBean=PageBean.getInstance(page,total,"/compet","/getAll");
            list = competitionDao.getAllCompetition(pageBean);
        } catch (Exception e) {
            e.printStackTrace();
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
        Competition competition=competitionDao.getById(id);
        model.addAttribute("competition",competition);
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
            User user=userDao.getById(uid);
            model.addAttribute("user",user);
            Competition competition=competitionDao.getById(id);
            model.addAttribute("competition",competition);
            List<Team>list=teamDao.findByComId(1);
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
        Integer uid=(Integer)session.getAttribute("userId");
        User user=userDao.getById(uid);
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
             Competition competition=competitionDao.getById(comId);
             team.setCompetition(competition);
             teamDao.save(team);
             idtemp=team.getId();
             competAndTeam.setTeam(team);
             competAndTeam.setUser(user);
             competAndTeamDao.save(competAndTeam);
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
        List<Team>list=teamDao.findByComId(id);
        return list;
    }

    /**
     * 加入已存在队伍
     * @param password 入队密码
     * @param out
     * @param session
     */
    @RequestMapping("joinTeam")
    public void join(Integer teamId,String password,PrintWriter out,HttpSession session){
     int result=1;
        Integer uid=(Integer)session.getAttribute("userId");
        User user=userDao.getById(uid);
        try {
            Team team = teamDao.getById(teamId);
            if (team == null) {
                //找不到队伍
                result = -1;
            } else {
                if (!team.getPassword().equals(password)) {
                    //密码不正确
                    result = -2;
                } else {
                    if(teamDao.exitMember(uid,team)){
                        //您已经报过名了
                        result=-4;
                    }else
                    if (team.getType() == 1) {
                        //队伍已满
                        result = -3;
                    } else {
                        if(team.getParticipants().size()+1==team.getMaxSize()) {
                            team.setType(1);
                            teamDao.update(team);
                        }
                        CompetAndTeam competAndTeam=new CompetAndTeam();
                        competAndTeam.setUser(user);
                        competAndTeam.setTeam(team);
                       competAndTeamDao.save(competAndTeam);
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
        PageBean pageBean=PageBean.getInstance(1,0,"/compet","/mycompet");
        User user=new User();
        try {
            user=userDao.getById(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        List<CompetAndTeam> list= null;
        try {
            int total=competAndTeamDao.getSize();
            pageBean=PageBean.getInstance(page,total,"/compet","/mycompet");
            list=competAndTeamDao.getByUser(userId,1,pageBean);
        } catch (Exception e) {
            e.printStackTrace();
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
        PageBean pageBean=PageBean.getInstance(1,0,"/compet","/mycompet");
        User user=new User();
        try {
            user=userDao.getById(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        List<CompetAndTeam> list= null;
        try {
            int total=competAndTeamDao.getSize();
            pageBean=PageBean.getInstance(page,total,"/compet","/mycompet");
            list=competAndTeamDao.getByUser(userId,3,pageBean);
        } catch (Exception e) {
            e.printStackTrace();
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
        if(page==0){
            page=1;
        }
        Integer userId=(Integer)session.getAttribute("userId");
        PageBean pageBean=PageBean.getInstance(1,0,"/compet","/mycompet");
        User user=new User();
        try {
            user=userDao.getById(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        List<CompetAndTeam> list= null;
        try {
            int total=competAndTeamDao.getSize();
            pageBean=PageBean.getInstance(page,total,"/compet","/mycompet");
            list=competAndTeamDao.getByUser(userId,2,pageBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("list",list);
        return "View/compet/pastCompet";
    }

    /**
     * 查看队伍信息
     * @param teamId 队伍id
     * @param model
     * @return
     */
    @RequestMapping("showTeam")
    public String showTeam(Integer teamId,Model model){
        Team team=null;
        MyTeamBean myTeamBean=null;
        try{
          team=teamDao.getById(teamId);
            myTeamBean=teamDao.buildMyTeam(team);
        }catch (Exception e){
            e.printStackTrace();
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
        try {
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
            competitionDao.save(competition);
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
        Competition competition= new Competition();
        try {
            competition = competitionDao.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
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
    public String doUpdateCompetition(DefaultMultipartHttpServletRequest request,String name,String daterange,int minnumber,int maxnumber,String description,Integer id,Model model){
        System.out.println("the content is:"+description);
        CommonsMultipartFile file = (CommonsMultipartFile)request.getFile("file");
        File uploadFile = null;
        Competition competition = competitionDao.getById(id);
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
            competitionDao.update(competition);
            model.addAttribute("competition",competition);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/View/compet/competition";
    }

    @RequestMapping("delete")
    public void delete(Integer id,HttpSession session,PrintWriter out){
        int result=1;
        try{
            Competition competition=competitionDao.getById(id);
            if (competition!=null){
                competitionDao.delete(id);
                Integer userId=(Integer)session.getAttribute("userId");
                User user=userDao.getById(userId);
                publishLogDao.deleteCompetition(user,competition);
            }else {
                result=-1;
            }
        }catch (Exception e){
            e.printStackTrace();
            result=-1;
        }
        out.print(result);
    }
    @RequestMapping("getTeamById")
    public @ResponseBody TeamBean getTeamById(Integer teamId){
        TeamBean teamBean=teamDao.build(teamDao.getById(teamId));
        return teamBean;
    }
}
