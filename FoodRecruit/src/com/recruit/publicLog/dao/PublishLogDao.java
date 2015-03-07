package com.recruit.publicLog.dao;

import com.recruit.BaseDao.DaoBase;
import com.recruit.publicLog.model.PublishLog;

/**
 * Created by Mklaus on 15/1/27.
 */
public class PublishLogDao extends DaoBase<PublishLog>{
    public Class classOfT(){
        return PublishLog.class;
    }

    //SINGLETON
    private static class Singleton{
        public static final PublishLogDao INSTANCE = new PublishLogDao();
    }
    public static PublishLogDao getInstance(){
        return Singleton.INSTANCE;
    }
}
