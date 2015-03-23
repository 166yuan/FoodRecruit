package com.recruit.dao;

import com.recruit.base.DaoSupport;
import com.recruit.model.Classes;

import java.util.List;

public interface ClassesDao extends DaoSupport<Classes>{
    public List<Classes>getClassByMajor(Integer mid);
}

