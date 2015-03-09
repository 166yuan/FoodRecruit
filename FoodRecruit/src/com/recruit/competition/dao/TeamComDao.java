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
        DetachedCriteria dc=DetachedCriteria.forClass(CompetAndTeam.class);
        dc.add(Restrictions.eq("team_id",teamId)).add(Restrictions.eq("user_id",userId)).add(Restrictions.eq("compet_id",comId));
        List<CompetAndTeam> list=null;
        list=this.search(dc);
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
        DetachedCriteria dc=DetachedCriteria.forClass(CompetAndTeam.class);
        dc.add(Restrictions.eq("compet_id",comId)).add(Restrictions.eq("team_id",teamId));
        return this.search(dc);
    }

}
