package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.dao.ClassesDao;
import com.recruit.model.Classes;

public class ClassesImpl extends DaoSupportImpl<Classes> implements ClassesDao {
    private static ClassesImpl instance=null;

    public static  ClassesImpl getInstance(){
        if(instance==null){
            return new ClassesImpl();
        }
        return instance;
    }

}
