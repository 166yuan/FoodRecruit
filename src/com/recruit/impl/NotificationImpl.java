package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.bean.NotiUserBean;
import com.recruit.bean.PageBean;
import com.recruit.dao.NotificationDao;
import com.recruit.model.Notification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class NotificationImpl extends DaoSupportImpl<Notification> implements NotificationDao {
    public List<Notification> getAllByType(int type,PageBean pageBean){
        String hql=null;
        if(type==3){
           hql="from Notification n";
        }else if(type==2){
            hql="from Notification n where n.isNew=false";
        }else {
            hql="from Notification n where n.isNew=true";
        }
        return this.findByHql(hql,pageBean.getCurPage(),pageBean.getPerPage());
    }
    public Integer getSizeByType(int type){
        String hql=null;
        if(type==3){
            hql="from Notification n";
        }else if(type==2){
            hql="from Notification n where n.isNew=false";
        }else {
            hql="from Notification n where n.isNew=true";
        }
        return this.getSize(hql);
    }

    public List<NotiUserBean>buildList(List<Notification>list){

        List<NotiUserBean>list1=new ArrayList<NotiUserBean>();
        Iterator<Notification>iterator=list.iterator();
        while (iterator.hasNext()){
            NotiUserBean nbean=new NotiUserBean();
            Notification notification=iterator.next();
            nbean.setCreateTime(notification.getCreateTime());
            nbean.setInfo(notification.getInfo());
            nbean.setIsNew(notification.getIsNew());
            nbean.setType(notification.getType());
            nbean.setName(notification.getCreator().getName());
            list1.add(nbean);
        }
        return list1;
    }
    public List<Notification>getUnreadNotificationByUserId(Integer userId){
        Map<String,Object>map=new HashMap<String, Object>();
        map.put("receiver",userId);
        map.put("isNew",true);
        return this.findByProperties(map,1,200);
    }

    public List<Notification>getAllNotificationByUserId(Integer userId){
        Map<String,Object>map=new HashMap<String, Object>();
        map.put("receiver",userId);
        return this.findByProperties(map,1,200);
    }

}
