package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.dao.PublishLogDao;
import com.recruit.model.PublishLog;

public class PublishLogImpl extends DaoSupportImpl<PublishLog> implements PublishLogDao {
    private static PublishLogImpl instance=null;

    public static  PublishLogImpl getInstance(){
        if(instance==null){
            instance= new PublishLogImpl();
        }
        return instance;
    }

}
