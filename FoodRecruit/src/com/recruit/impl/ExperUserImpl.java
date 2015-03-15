package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.dao.ExperUserDao;
import com.recruit.model.ExperUser;
import com.recruit.model.Experiment;
import com.recruit.model.User;
import org.hibernate.Query;

import java.util.List;

public class ExperUserImpl extends DaoSupportImpl<ExperUser> implements ExperUserDao {
    private static ExperUserImpl instance=null;

    public static  ExperUserImpl getInstance(){
        if(instance==null){
            return new ExperUserImpl();
        }
        return instance;
    }

    public ExperUser findByExperAndUserId(Integer experId,Integer userId){
        String hql="from ExperUser eu where eu.experiment.id="+experId+" and eu.user.id="+userId;
       ExperUser experUser=this.find(hql).get(0);
        return experUser;
    }

}
