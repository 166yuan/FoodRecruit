package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.dao.TeamDao;
import com.recruit.model.Team;

public class TeamImpl extends DaoSupportImpl<Team> implements TeamDao {
    private static TeamImpl instance=null;

    public static  TeamImpl getInstance(){
        if(instance==null){
            return new TeamImpl();
        }
        return instance;
    }

}
