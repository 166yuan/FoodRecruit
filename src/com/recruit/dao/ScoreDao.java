package com.recruit.dao;

import com.recruit.base.DaoSupport;
import com.recruit.model.Score;

public interface ScoreDao extends DaoSupport<Score>{
    public Score getByExperIdAndUserId(Integer experId,Integer userId);
}