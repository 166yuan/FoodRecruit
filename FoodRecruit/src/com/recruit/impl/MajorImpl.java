package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.dao.MajorDao;
import com.recruit.model.Major;

public class MajorImpl extends DaoSupportImpl<Major> implements MajorDao{
    private static MajorImpl instance=null;

    public static  MajorImpl getInstance(){
        if(instance==null){
            return new MajorImpl();
        }
        return instance;
    }

}
