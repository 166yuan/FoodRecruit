package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.base.PageBean;
import com.recruit.dao.MajorDao;
import com.recruit.model.Major;

import java.util.List;

public class MajorImpl extends DaoSupportImpl<Major> implements MajorDao{
    private static MajorImpl instance=null;

    public static  MajorImpl getInstance(){
        if(instance==null){
            return new MajorImpl();
        }
        return instance;
    }

    public List<Major>getAllMajor(PageBean pageBean){
        Major major=new Major();
       return this.findByProperties(major,pageBean.getCurPage(),pageBean.getPerPage());
    }

}
