package com.recruit.experUser.dao;

import com.recruit.BaseDao.DaoBase;
import com.recruit.experUser.model.ExperUser;
import com.recruit.experiment.model.Experiment;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Mklaus on 15/1/26.
 */
public class ExperUserDao extends DaoBase<ExperUser>{
    public ExperUserDao() {}

    public Class classOfT(){
        return ExperUser.class;
    }

    //SINGLETON
    private static class Singleton{
        public static final ExperUserDao INSTANCE = new ExperUserDao();
    }

    public static ExperUserDao getInstance(){
        return Singleton.INSTANCE;
    }

    //EXTENDS
    public ExperUser forExperIdAndUserId(Long experId,Long userId){
        DetachedCriteria dc = DetachedCriteria.forClass(ExperUser.class)
                .add(Restrictions.eq("experId",experId)).add(Restrictions.eq("userId", userId));
        return this.get(dc);
    }

    public ExperUser createExperUser(){
        ExperUser experUser = new ExperUser();
        this.save(experUser);
        return experUser;
    }



    public List<ExperUser> getByExperId(Long experId){
        DetachedCriteria dc = DetachedCriteria.forClass(ExperUser.class)
                .add(Restrictions.eq("experId",experId));

        List<ExperUser> experUserList = this.search(dc);

        return experUserList;
    }

    public int countByExperId(Long experId){
        DetachedCriteria dc = DetachedCriteria.forClass(ExperUser.class)
                .add(Restrictions.eq("experId",experId));
        return this.count(dc).intValue();
    }

}
