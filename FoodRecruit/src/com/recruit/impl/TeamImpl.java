package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.bean.TeamBean;
import com.recruit.dao.TeamDao;
import com.recruit.model.CompetAndTeam;
import com.recruit.model.Team;

import java.util.*;

public class TeamImpl extends DaoSupportImpl<Team> implements TeamDao {
    private static TeamImpl instance=null;

    public static  TeamImpl getInstance(){
        if(instance==null){
            instance= new TeamImpl();
        }
        return instance;
    }

    public List<Team> findByComId(Integer comId){
        Map<String,Object>map=new HashMap<String,Object>();
        map.put("competition",comId);
        return this.findByProperties(map,1,100);
    }

    public static TeamBean build(Team team){
        TeamBean tbBean=new TeamBean();
        tbBean.setLeader(team.getLeader().getName());
        tbBean.setClasses(team.getLeader().getClasses().getClassName());
        tbBean.setMajor(team.getLeader().getMajor().getMajorName());
        tbBean.setLink(team.getLeader().getPhone());
        tbBean.setEmail(team.getLeader().getEmail());
        tbBean.setNumber(team.getParticipants().size());
        tbBean.setSlogan(team.getSlogan());
        tbBean.setTeamName(team.getName());
        return tbBean;
    }

    public boolean exitMember(Integer userId,Team team){
        boolean isExist=false;
        List<CompetAndTeam>list=new ArrayList<CompetAndTeam>(team.getParticipants());
        for (int i=0;i<list.size();i++){
            if(list.get(0).getUser().getId()==userId){
                isExist=true;
                break;
            }
        }
        return isExist;
    }
}
