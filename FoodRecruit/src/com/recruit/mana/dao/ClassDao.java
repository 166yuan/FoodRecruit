package com.recruit.mana.dao;

import com.recruit.BaseDao.DaoBase;
import com.recruit.Bean.PageBean;
import com.recruit.Model.Classes;

import java.util.List;

/**
 * Created by Administrator on 2015/2/21.
 */
public class ClassDao extends DaoBase<Classes> {
    @Override
    protected Class classOfT() {
        return Classes.class;
    }
    //SINGLETON
    private static class Singleton{
        public static final ClassDao INSTANCE = new ClassDao();
    }
    public static ClassDao getInstance(){
        return Singleton.INSTANCE;
    }
    public List<Classes> getAllClass(PageBean pageBean){
        return  this.find("from Classes c").fetch(pageBean.getCurPage(),pageBean.getPerPage());
    }
    public List<Integer>getAllYear(){
        return this.find("select distinct m.year from Major m").query.list();
    }
    public int countAllClass(){
        return this.find("from Classes c").query.list().size();
    }

}
