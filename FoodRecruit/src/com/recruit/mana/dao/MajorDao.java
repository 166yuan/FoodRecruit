package com.recruit.mana.dao;

import com.recruit.BaseDao.DaoBase;
import com.recruit.Bean.PageBean;
import com.recruit.Model.Major;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Administrator on 2015/2/18.
 */
public class MajorDao extends DaoBase<Major>{
    @Override
    protected Class classOfT() {
       return Major.class;
    }

    //SINGLETON
    private static class Singleton{
        public static final MajorDao INSTANCE = new MajorDao();
    }
    public static MajorDao getInstance(){
        return Singleton.INSTANCE;
    }

    public List<Major> getAllMajor(PageBean pageBean){
      return  this.find("from Major m").fetch(pageBean.getCurPage(),pageBean.getPerPage());
    }

    public List<Major>getAllMajorByYear(int year){
        return  this.find("from Major m where m.year=?").query.setParameter(0,year).list();
    }

    public List<Integer>getAllYear(){
        return this.find("select m.year from Major m").query.list();
    }

    public int countAllMajor(){
       return this.find("from Major m").query.list().size();
    }

    public Major getMajorById(Long majorId){
        DetachedCriteria dc = DetachedCriteria.forClass(Major.class)
                .add(Restrictions.eq("id", majorId));
        return(
                this.get(dc)
        );
    }
}
