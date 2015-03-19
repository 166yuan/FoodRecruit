package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.base.PageBean;
import com.recruit.dao.CompetitionDao;
import com.recruit.model.Competition;

import java.util.List;


public class CompetitionImpl extends DaoSupportImpl<Competition> implements CompetitionDao {
    private static CompetitionImpl instance=null;

    public static  CompetitionImpl getInstance(){
        if(instance==null){
            instance= new CompetitionImpl();
        }
        return instance;
    }

    public List<Competition>getAllCompetition(PageBean pageBean){
        String hql="from Competition c";
       return this.findByHql(hql,pageBean.getCurPage(),pageBean.getPerPage());
    }
}
