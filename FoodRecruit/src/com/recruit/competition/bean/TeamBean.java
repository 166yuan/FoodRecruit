package com.recruit.competition.bean;

import com.recruit.competition.dao.ComDao;
import com.recruit.competition.dao.TeamDao;
import com.recruit.competition.model.CompetAndTeam;
import com.recruit.competition.model.Competition;
import com.recruit.competition.model.Team;
import com.recruit.user.Dao.UserDao;
import com.recruit.user.model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** 队伍bean
 * Created by Administrator on 2015/3/3.
 */
public class TeamBean {
    //队长姓名
    String Leader;
    //队员姓名
    String name[];
    //竞赛名称
    String comName;
    //组队状态
    boolean teamType;

    static  List<String>nameList;
    static UserDao userDao=UserDao.getInstance();

    /**
     * 构建bean对象
     * @param comId
     * @param teamId
     * @param list 处理的list
     * @return
     */
    public static TeamBean build(Long comId,Long teamId,List<CompetAndTeam>list){
        TeamBean teamBean=new TeamBean();
        Iterator<CompetAndTeam>it=list.iterator();
        ComDao comDao=ComDao.getInstance();
        TeamDao teamDao=TeamDao.getInstance();
        Competition competition=comDao.getById(comId);
        Team team=teamDao.getById(teamId);
        Long leaderId=team.getLeader_id();
        if(team.getType()==0){
            teamBean.setTeamType(false);
        }else {
            teamBean.setTeamType(true);
        }
        teamBean.setComName(competition.getName());
        nameList=new ArrayList<String>();
        while (it.hasNext()){
            CompetAndTeam competAndTeam=it.next();
            User user=userDao.getUserById(competAndTeam.getUser_id());
            if(user.getId()==leaderId){
                teamBean.setLeader(user.getName());
            }else {
                nameList.add(user.getName());
                System.out.println(user.getName());
            }
        }
        return teamBean;
    }

    public String getLeader() {
        return Leader;
    }

    public void setLeader(String leader) {
        Leader = leader;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public boolean getTeamType() {
        return teamType;
    }

    public void setTeamType(boolean teamType) {
        this.teamType = teamType;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public  void setNameList(List<String> nameList) {
        TeamBean.nameList = nameList;
    }
}
