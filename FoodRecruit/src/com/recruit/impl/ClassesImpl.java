package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.dao.ClassesDao;
import com.recruit.model.Classes;
import org.hibernate.Query;

import java.util.Iterator;
import java.util.List;

public class ClassesImpl extends DaoSupportImpl<Classes> implements ClassesDao {
    private static ClassesImpl instance=null;

    public static  ClassesImpl getInstance(){
        if(instance==null){
            instance= new ClassesImpl();
        }
        return instance;
    }

    public void Instance(List<Classes>list){
        Iterator<Classes>it=list.iterator();
        while (it.hasNext()){
            it.next().getMajor().getMajorName();
        }
    }

}
