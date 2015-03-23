package com.recruit.dao;

import com.recruit.base.DaoSupport;
import com.recruit.bean.PageBean;
import com.recruit.model.Major;

import java.util.List;

public interface MajorDao extends DaoSupport<Major>{
    public List<Major> getAllMajor(PageBean pageBean);
    public List<Major>getMajorByYear(int year);
    public List<Integer>getAllYear();
    public boolean existNameAndYear(String name,int year);
}
