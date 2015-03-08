package com.recruit.competition.dao;

import com.recruit.BaseDao.DaoBase;
import com.recruit.competition.model.Team;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Administrator on 2015/2/27.
 */
public class TeamDao extends DaoBase<Team> {

    @Override
    protected Class classOfT() {
        return Team.class;
    }

    private static class Singleton{
        public static final TeamDao INSTANCE = new TeamDao();
    }

    public static TeamDao getInstance(){
        return Singleton.INSTANCE;
    }

    public List<Team> getAllTeamById(Long id){
        Query query1= this.find("from Team te where competition_id=?").query;
        query1.setParameter(0,id);
       return  query1.list();
    }

    public Team getByName(String name){
        DetachedCriteria dc = DetachedCriteria.forClass(Team.class)
                .add(Restrictions.eq("name", name));
        return(
                this.get(dc)
        );
    }

    public Team getById(Long id){
        DetachedCriteria dc = DetachedCriteria.forClass(Team.class)
                .add(Restrictions.eq("id", id));
        return(
                this.get(dc)
        );
    }


}