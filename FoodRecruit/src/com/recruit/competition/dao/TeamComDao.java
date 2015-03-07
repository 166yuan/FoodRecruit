package com.recruit.competition.dao;

import com.recruit.BaseDao.DaoBase;
import com.recruit.competition.model.CompetAndTeam;
import com.recruit.competition.model.Competition;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Administrator on 2015/2/27.
 */
public class TeamComDao extends DaoBase<CompetAndTeam>{
    @Override
    protected Class classOfT() {
        return CompetAndTeam.class;
    }
    private static class Singleton{
        public static final TeamComDao INSTANCE = new TeamComDao();
    }

    public static TeamComDao getInstance(){
        return Singleton.INSTANCE;
    }

    public boolean existMember(Long teamId,Long userId,Long comId){
        Query query1=this.find("from CompetAndTeam cat where cat.team_id=? and cat.user_id=? and cat.compet_id=?").query;
        query1.setParameter(0,teamId);
        query1.setParameter(1,userId);
        query1.setParameter(2,comId);
        List<CompetAndTeam> list=null;
        list=query1.list();
        if(list.size()==0){
            return false;
        }else {
            return true;
        }
    }

    public List<CompetAndTeam>getByUser(Long userId){
        DetachedCriteria dc = DetachedCriteria.forClass(CompetAndTeam.class)
                .add(Restrictions.eq("user_id",userId));

        List<CompetAndTeam> list = this.search(dc);
        return list;
    }

    public List<CompetAndTeam>getTeamById(Long teamId,Long comId){
        Query query1=this.find("from CompetAndTeam com where com.compet_id=? and com.team_id=?").query;
        query1.setParameter(0,comId);
        query1.setParameter(1,teamId);
        return query1.list();
    }

}
