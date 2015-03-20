package com.recruit.dao;

import com.recruit.base.DaoSupport;
import com.recruit.model.ExperUser;
import com.recruit.model.Experiment;
import com.recruit.model.User;

import java.util.List;

public interface ExperUserDao extends DaoSupport<ExperUser>{
    public ExperUser findByExperAndUserId(Integer experId,Integer userId);
    public List<ExperUser> findByExper(Integer experId);
    public ExperUser create(User user,Experiment experiment);
}
