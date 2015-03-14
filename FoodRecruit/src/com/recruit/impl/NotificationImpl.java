package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.dao.NotificationDao;
import com.recruit.model.Notification;

public class NotificationImpl extends DaoSupportImpl<Notification> implements NotificationDao {
    private static NotificationImpl instance=null;

    public static  NotificationImpl getInstance(){
        if(instance==null){
            return new NotificationImpl();
        }
        return instance;
    }

}
