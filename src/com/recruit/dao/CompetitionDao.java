package com.recruit.dao;

import com.recruit.base.DaoSupport;
import com.recruit.bean.PageBean;
import com.recruit.model.Competition;

import java.util.List;

public interface CompetitionDao extends DaoSupport<Competition>{
    public List<Competition> getAllCompetition(PageBean pageBean);
    public List<Competition>getAllPublishCompetition(PageBean pageBean);
}
