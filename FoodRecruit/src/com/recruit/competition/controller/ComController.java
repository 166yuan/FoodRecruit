package com.recruit.competition.controller;

import com.recruit.competition.bean.ComTeamBean;
import com.recruit.competition.bean.TeamBean;
import com.recruit.competition.dao.ComDao;
import com.recruit.competition.dao.TeamComDao;
import com.recruit.competition.dao.TeamDao;
import com.recruit.competition.model.CompetAndTeam;
import com.recruit.competition.model.Competition;
import com.recruit.competition.model.Team;
import com.recruit.user.Dao.UserDao;
import com.recruit.user.model.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.File;
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
        ComDao comDao=ComDao.getInstance();
        try {
            comDao.begin();
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
            comDao.save(competition);
            comDao.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            comDao.close();
        }

return "View/compet/competition";
    }

    /**
     * 取得所有的竞赛
     * @param model
     * @return
     */
    @RequestMapping("getAll")
    public String getAllCompet(Model model){
        ComDao comDao=ComDao.getInstance();
        List<Competition> list=comDao.getAllCompetition();
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
    public String getCompetitionById(Long id,Model model){
    ComDao comDao=ComDao.getInstance();
    Competition competition=comDao.getById(id);
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
    public String attendCompetition(HttpSession session,Model model,Long id){
        Long uid=(Long)session.getAttribute("userId");
        String result;
        if(uid==null){
            //用户未登录，去登录界面
            result= "View/compet/unlogin";
        }else{
            ComDao comDao=ComDao.getInstance();
            Competition competition=comDao.getById(id);
            UserDao userDao=UserDao.getInstance();
            User user = userDao.getUserById(uid);
            model.addAttribute("user",user);
            model.addAttribute("competition",competition);
            result= "View/compet/attendance";
        }
        return result;
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
    @RequestMapping("newteam")
    public String newTeam(Long comId,String name,String slogan,String password,int number,HttpSession session){
        Long idtemp=null;
         TeamDao teamDao=TeamDao.getInstance();
         UserDao userDao=UserDao.getInstance();
        Long uid=(Long)session.getAttribute("userId");
         try{
             teamDao.begin();
             Team team=new Team();
             team.setName(name);
             team.setCurrentNum(1);
             team.setSize(number);
             team.setSlogan(slogan);
             team.setPassword(password);
             if (number==1){
                 team.setType(1);
             }else {
                 team.setType(0);
             }
             team.setLeader_id(uid);
             team.setCompetition_id(comId);
             teamDao.save(team);
             idtemp=team.getId();
             CompetAndTeam competAndTeam=new CompetAndTeam();
             competAndTeam.setTeam_id(idtemp);
             competAndTeam.setCompet_id(comId);
             competAndTeam.setUser_id(uid);
             teamDao.save(competAndTeam);
             teamDao.commit();
         }catch (Exception e){
            e.printStackTrace();
         }finally {
             teamDao.close();
         }
         return "View/compet/attendSuccess";
    }

    /**
     * 获取所有队伍的名称
     * @param id
     * @return json到前端
     */
    @RequestMapping("getTeamNames")
    public @ResponseBody List<Team> getTeamName(Long id){
        TeamDao teamDao=TeamDao.getInstance();
        List<Team>list=teamDao.getAllTeamById(id);
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
    public void join(String name,String password,Long comId,PrintWriter out,HttpSession session){
     int result=1;
        TeamDao teamDao=TeamDao.getInstance();
        TeamComDao teamComDao=TeamComDao.getInstance();
        Long uid=(Long)session.getAttribute("userId");
        try {
            teamDao.begin();
            Team team = teamDao.getByName(name);
            if (team == null) {
                //找不到队伍
                result = -1;
            } else {
                if (!team.getPassword().equals(password)) {
                    //密码不正确
                    result = -2;
                } else {
                    if(teamComDao.existMember(team.getId(),uid,comId)){
                        //您已经报过名了
                        result=-4;
                    }else
                    if (team.getType() == 1) {
                        //队伍已满
                        result = -3;
                    } else {
                        int temp=team.getCurrentNum();
                        temp++;
                        team.setCurrentNum(temp);
                        if(temp==team.getSize())
                            team.setType(1);
                        teamDao.save(team);
                        CompetAndTeam competAndTeam=new CompetAndTeam();
                        competAndTeam.setCompet_id(comId);
                        competAndTeam.setUser_id(uid);
                        competAndTeam.setTeam_id(team.getId());
                        teamDao.save(competAndTeam);
                        teamDao.commit();
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            teamDao.close();
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
    public String myCompetition(HttpSession session,Model model){
        Long userId=(Long)session.getAttribute("userId");
        TeamComDao teamComDao=TeamComDao.getInstance();
        List<CompetAndTeam> list=teamComDao.getByUser(userId);
        List<ComTeamBean>list1=ComTeamBean.buildList(list);
        model.addAttribute("list",list1);
        return "View/compet/myCompet";
    }

    /**
     * 用户现在参与的竞赛
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("nowCompet")
    public String CompetitionOnGoing(HttpSession session,Model model){
        Long userId=(Long)session.getAttribute("userId");
        TeamComDao teamComDao=TeamComDao.getInstance();
        List<CompetAndTeam> list=teamComDao.getByUser(userId);
        List<ComTeamBean>list1=ComTeamBean.buildList2(list);
        model.addAttribute("list",list1);
        return "View/compet/goingCompet";
    }

    /**
     * 用户过去参与的竞赛
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("passCompet")
    public String pastCompetition(HttpSession session,Model model){
        Long userId=(Long)session.getAttribute("userId");
        TeamComDao teamComDao=TeamComDao.getInstance();
        List<CompetAndTeam> list=teamComDao.getByUser(userId);
        List<ComTeamBean>list1=ComTeamBean.buildList1(list);
        model.addAttribute("list",list1);
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
    public String showTeam(Long teamId,Long comId,Model model){
        TeamComDao teamComDao=TeamComDao.getInstance();
        List<CompetAndTeam>list=teamComDao.getTeamById(teamId, comId);
        TeamBean teamBean=TeamBean.build(comId,teamId,list);
        model.addAttribute("team", teamBean);
        return "View/compet/myTeam";
    }

}
