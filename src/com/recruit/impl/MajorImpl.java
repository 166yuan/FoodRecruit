package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.bean.PageBean;
import com.recruit.dao.MajorDao;
import com.recruit.model.Major;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class MajorImpl extends DaoSupportImpl<Major> implements MajorDao{
    public List<Major>getAllMajor(PageBean pageBean){
        String hql="from Major m";
       return this.findByHql(hql,pageBean.getCurPage(),pageBean.getPerPage());
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

    public boolean existNameAndYear(String name,int year){
        Map<String,Object>map=new HashMap<String, Object>();
        map.put("majorName",name);
        map.put("year",year);
        List<Major>list=this.findByProperties(map,1,10);
        System.out.println("size of:"+list.size());
        if (list.size()==0){
            return false;
        }else {
            return true;
        }
    }

}
