package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.bean.MyTeamBean;
import com.recruit.bean.TeamBean;
import com.recruit.dao.TeamDao;
import com.recruit.model.CompetAndTeam;
import com.recruit.model.Team;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
@Service
@Transactional
public class TeamImpl extends DaoSupportImpl<Team> implements TeamDao {
    public List<Team> findByComId(Integer comId){
        Map<String,Object>map=new HashMap<String,Object>();
        map.put("competition",comId);
        return this.findByProperties(map,1,100);
    }

    public TeamBean build(Team team){
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

    public boolean exitMemberByCompet(Integer userId,Integer comId){
        boolean isExist=false;
        String hql="from CompetAndTeam cat where cat.user="+userId+" and team.competition.id="+comId;
        Query query=this.createQuery(hql);
        if (query.list().size()!=0){
        isExist=true;
        }
        return isExist;
    }

    public MyTeamBean buildMyTeam(Team team){
        MyTeamBean myTeamBean=new MyTeamBean();
        myTeamBean.setLeader(team.getLeader().getName());
        myTeamBean.setComName(team.getCompetition().getName());
        List<String>list=new ArrayList<String>();
        List<CompetAndTeam>list1=new ArrayList<CompetAndTeam>(team.getParticipants());
        if (team.getMaxSize()==list.size()){
            myTeamBean.setTeamType(true);
        }else {
            myTeamBean.setTeamType(false);
        }
        Iterator<CompetAndTeam>iterator=list1.iterator();
        while (iterator.hasNext()){
            list.add(iterator.next().getUser().getName());
        }
        myTeamBean.setNameList(list);
        return myTeamBean;
    }
}
