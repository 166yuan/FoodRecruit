package com.recruit.dao;

import com.recruit.base.DaoSupport;
import com.recruit.bean.PageBean;
import com.recruit.model.CompetAndTeam;
import com.recruit.model.User;

import java.util.List;

public interface CompetAndTeamDao extends DaoSupport<CompetAndTeam>{
    public List<CompetAndTeam> getByUser(User user,PageBean pageBean);
    public Integer getSizeByType(Integer userId,int type);
}
