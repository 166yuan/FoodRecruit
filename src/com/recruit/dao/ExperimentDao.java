package com.recruit.dao;

import com.recruit.base.DaoSupport;
import com.recruit.bean.ExperScoreBean;
import com.recruit.bean.PageBean;
import com.recruit.model.Experiment;
import com.recruit.model.User;

import java.util.List;

public interface ExperimentDao extends DaoSupport<Experiment>{
public List<Experiment> getAllByUser(Integer userId,int page);
    public List<Experiment> getNeedAssistant(PageBean pageBean);
    public List<Experiment>getMyPublishExper(Integer userId,PageBean pageBean);
    public Integer countByPublisher(Integer pid);
    public Integer countNeedAssistant();
    public List<ExperScoreBean> buildList(List<Experiment>elist);
}
