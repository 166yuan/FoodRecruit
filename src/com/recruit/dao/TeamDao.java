package com.recruit.dao;

import com.recruit.base.DaoSupport;
import com.recruit.bean.MyTeamBean;
import com.recruit.bean.TeamBean;
import com.recruit.model.Team;

import java.util.List;

public interface TeamDao extends DaoSupport<Team>{
    public List<Team> findByComId(Integer comId);
    public  TeamBean build(Team team);
    public boolean exitMember(Integer userId,Team team);
    public MyTeamBean buildMyTeam(Team team);
}
