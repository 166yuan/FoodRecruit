package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.dao.CompetAndTeamDao;
import com.recruit.model.CompetAndTeam;


public class CompetAndTeamImpl extends DaoSupportImpl<CompetAndTeam> implements CompetAndTeamDao {
    private static CompetAndTeamImpl instance=null;

    public static  CompetAndTeamImpl getInstance(){
        if(instance==null){
            instance= new CompetAndTeamImpl();
        }
        return instance;
    }

}
