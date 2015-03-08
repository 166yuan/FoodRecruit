package com.recruit.competition.dao;

import com.recruit.BaseDao.DaoBase;
import com.recruit.competition.model.Competition;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Administrator on 2015/2/24.
 */
public class ComDao extends DaoBase<Competition> {

    @Override
    protected Class classOfT() {
        return Competition.class;
    }
    private static class Singleton{
        public static final ComDao INSTANCE = new ComDao();
    }

    public static ComDao getInstance(){
        return Singleton.INSTANCE;
    }

    public List<Competition>getAllCompetition(){
       return this.find("from Competition c").query.list();
    }

    public Competition getById(Long id){
        DetachedCriteria dc = DetachedCriteria.forClass(Competition.class)
                .add(Restrictions.eq("id", id));
        return(
                this.get(dc)
        );
    }

}