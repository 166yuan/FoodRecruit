package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.base.PageBean;
import com.recruit.dao.MajorDao;
import com.recruit.model.Major;
import org.hibernate.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MajorImpl extends DaoSupportImpl<Major> implements MajorDao{
    private static MajorImpl instance=null;

    public static  MajorImpl getInstance(){
        if(instance==null){
            instance= new MajorImpl();
        }
        return instance;
    }

    public List<Major>getAllMajor(PageBean pageBean){
        Major major=new Major();
       return this.findByProperties(major,pageBean.getCurPage(),pageBean.getPerPage());
    }
    public List<Major>getMajorByYear(int year){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("year",year);
        return this.findByProperties(map,1,50);
    }
    public List<Integer>getAllYear(){
        String hql="select distinct year from Major m";
        Query query=this.createQuery(hql);
        return query.list();
    }

    public boolean getByNameAndYear(String name,int year){
        Map<String,Object>map=new HashMap<String, Object>();
        map.put("name",name);
        map.put("year",year);
        List<Major>list=this.findByProperties(map,1,10);
        if (list.size()!=0){
            return false;
        }else {
            return true;
        }
    }
}
