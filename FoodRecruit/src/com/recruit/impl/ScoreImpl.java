package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.dao.ScoreDao;
import com.recruit.model.Score;

public class ScoreImpl extends DaoSupportImpl<Score> implements ScoreDao {
    private static ScoreImpl instance=null;

    public static  ScoreImpl getInstance(){
        if(instance==null){
            instance= new ScoreImpl();
        }
        return instance;
    }

}
