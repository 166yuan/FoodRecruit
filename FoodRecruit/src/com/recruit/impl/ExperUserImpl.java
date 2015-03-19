package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.dao.ExperUserDao;
import com.recruit.model.ExperUser;
import com.recruit.model.Experiment;
import com.recruit.model.Score;
import com.recruit.model.User;
import org.hibernate.Query;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.List;

public class ExperUserImpl extends DaoSupportImpl<ExperUser> implements ExperUserDao {
    private static ExperUserImpl instance=null;

    public static  ExperUserImpl getInstance(){
        if(instance==null){
            instance= new ExperUserImpl();
        }
        return instance;
    }

    public ExperUser findByExperAndUserId(Integer experId,Integer userId){
        String hql="from ExperUser eu where eu.experiment.id="+experId+" and eu.user.id="+userId;
        List<ExperUser> list=this.findByHql(hql,0,10);
        if (list.size()==0)
            return null;
        else {
            return list.get(0);
        }

    }

    public List<ExperUser>findByExper(Integer experId){
        String hql="from ExperUser eu where eu.experiment.id="+experId;
        return this.findByHql(hql,1,10);
    }

    public ExperUser create(User user,Experiment experiment){
        ExperUser experUser=new ExperUser();
        experUser.setExperiment(experiment);
        experUser.setUser(user);
        return experUser;
    }

}
