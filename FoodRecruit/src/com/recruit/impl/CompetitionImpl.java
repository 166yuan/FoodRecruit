package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.bean.PageBean;
import com.recruit.dao.CompetitionDao;
import com.recruit.model.Competition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompetitionImpl extends DaoSupportImpl<Competition> implements CompetitionDao {
    public List<Competition>getAllCompetition(PageBean pageBean){
        String hql="from Competition c";
       return this.findByHql(hql,pageBean.getCurPage(),pageBean.getPerPage());
    }
}
