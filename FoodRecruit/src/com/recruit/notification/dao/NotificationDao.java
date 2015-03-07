package com.recruit.notification.dao;

import com.recruit.BaseDao.DaoBase;
import com.recruit.notification.model.Notification;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Mklaus on 15/1/27.
 */
public class NotificationDao extends DaoBase<Notification>{
    public Class classOfT(){
        return Notification.class;
    }

    //SINGLETON
    private static class Singleton{
        public static final NotificationDao INSTANCE = new NotificationDao();
    }

    public static NotificationDao getInstance(){
        return Singleton.INSTANCE;
    }

    //根据接受者ID 查看输入该接受者的通知
    public List<Notification> forUserId(Long userId){
        DetachedCriteria dc = DetachedCriteria.forClass(Notification.class)
                .add(Restrictions.eq("userId",userId));
        List<Notification> list = this.search(dc);
        return list;
    }

    public Notification CreateNotification(){
        Notification notification = new Notification();
        this.save(notification);
        return notification;
    }

    public List<Notification> getAllNotification(int type){
        Query query;
        if(type==1){
            query=this.createQuery("from Notification no where type=3 and isNew=1 order by create_time desc");
        }else if(type==2){
            query=this.createQuery("from Notification no where type=3 and isNew=0 order by create_time desc");
        }else {
            query=this.createQuery("from Notification no where type=3 order by create_time desc");
        }
        List<Notification> list=query.list();
        return list;
    }

    public Notification getNotiById(Long id){
        DetachedCriteria dc = DetachedCriteria.forClass(Notification.class)
                .add(Restrictions.eq("id",id));
        return(
                this.get(dc)
        );
    }
}
