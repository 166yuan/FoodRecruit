package com.recruit.notification.dao;

import com.recruit.BaseDao.DaoBase;
import com.recruit.notification.model.Notification;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
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

    //根据接受者ID 获取所有的通知
    public List<Notification> getAllNotificationByUserId(Long userId){
        DetachedCriteria dc = DetachedCriteria.forClass(Notification.class)
                .add(Restrictions.eq("receiverId",userId));
        List<Notification> list = this.search(dc);
        return list;
    }

    //根据用户ID 返回所有未读的通知
    public List<Notification> getUnreadNotificationByUserId(Long userId){
        DetachedCriteria dc = DetachedCriteria.forClass(Notification.class)
                .add(Restrictions.eq("receiverId",userId))
                .add(Restrictions.eq("isNew",true));
        List<Notification> list = this.search(dc);
        return list;
    }

    public Notification Create(){
        Notification notification = new Notification();

        Date now = new Date();
        notification.setCreateTime(now);

        this.save(notification);
        return notification;
    }


    public List<Notification> getAllFeedback(int type){
        DetachedCriteria dc = DetachedCriteria.forClass(Notification.class);
        if(type==1){
            dc.add(Restrictions.eq("type",3)).add(Restrictions.eq("isNew",true));
            dc.addOrder(Order.desc("createTime"));
        }else if(type==2){
            dc.add(Restrictions.eq("type",3)).add(Restrictions.eq("isNew",false));
            dc.addOrder(Order.desc("createTime"));
        }else {
            dc.add(Restrictions.eq("type",3));
            dc.addOrder(Order.desc("createTime"));
        }
        return this.search(dc);
    }
}
