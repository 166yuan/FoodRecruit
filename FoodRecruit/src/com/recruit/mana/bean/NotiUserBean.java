package com.recruit.mana.bean;

import com.recruit.notification.dao.NotificationDao;
import com.recruit.notification.model.Notification;
import com.recruit.user.Dao.UserDao;
import com.recruit.user.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/** 用户通知bean。
 *  连结
 */
public class NotiUserBean {
   private Long userId;
    private long notiId;
    private String info;
    private Integer type;
    private Boolean isNew;
    private String name;
    private Date createTime;
    static UserDao userDao=UserDao.getInstance();
    public static NotiUserBean build(Notification notification){
        NotiUserBean notiUserBean=new NotiUserBean();
        notiUserBean.userId=notification.getUserId();
        notiUserBean.info=notification.getInfo();
        notiUserBean.isNew=notification.getIsNew();
        notiUserBean.type=notification.getType();
        notiUserBean.createTime=notification.getCreateTime();
        notiUserBean.notiId=notification.getId();
        User user=userDao.getUserById(notification.getUserId());
        notiUserBean.name=user.getName();
        return  notiUserBean;
    }
    public static List<NotiUserBean> buildList(List<Notification> list){
        List<NotiUserBean> notilist=new ArrayList<NotiUserBean>();
        Iterator<Notification>it=list.iterator();
        while (it.hasNext()){
        notilist.add(build(it.next()));
        }
        return notilist;
    }

    public Long getUserId() {
        return userId;
    }

    public String getInfo() {
        return info;
    }

    public Integer getType() {
        return type;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public String getName() {
        return name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public long getNotiId() {
        return notiId;
    }
}
