package com.recruit.score.dao;

import com.recruit.BaseDao.DaoBase;
import com.recruit.score.model.Score;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

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

    public Score getByExperIdAndUserId(long experId,long userId){
        DetachedCriteria dc=DetachedCriteria.forClass(Score.class);
        dc.add(Restrictions.eq("exper_id",experId)).add(Restrictions.eq("userId",userId));
        return this.get(dc);
    }
}
