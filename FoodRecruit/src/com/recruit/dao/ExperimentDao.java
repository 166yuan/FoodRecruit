package com.recruit.dao;

import com.recruit.base.DaoSupport;
import com.recruit.model.Experiment;
import com.recruit.model.User;

import java.util.List;

public interface ExperimentDao extends DaoSupport<Experiment>{
public List<Experiment> getAllByUser(User user
);
}
