package com.recruit.score.dao;

import com.recruit.BaseDao.DaoBase;
import com.recruit.score.model.Score;

/**
 * Created by Mklaus on 15/1/26.
 */
public class ScoreDao extends DaoBase<Score> {
    public Class classOfT(){
        return Score.class;
    }

    //SINGLETON
    private static class Singleton{
        public static final ScoreDao INSTANCE = new ScoreDao();
    }
    public static ScoreDao getInstance(){
        return Singleton.INSTANCE;
    }
}
