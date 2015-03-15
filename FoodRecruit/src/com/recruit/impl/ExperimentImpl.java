package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.dao.ExperimentDao;
import com.recruit.model.Experiment;
import com.recruit.model.User;

import java.util.List;

public class ExperimentImpl extends DaoSupportImpl<Experiment> implements ExperimentDao {

    private static ExperimentImpl instance=null;

    public static  ExperimentImpl getInstance(){
        if(instance==null){
            return new ExperimentImpl();
        }
        return instance;
    }

    @Override
    public List<Experiment> getAllByUser(User user) {
        return this.findByProperty("publisher",user);
    }
}
