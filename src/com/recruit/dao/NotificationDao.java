package com.recruit.dao;

import com.recruit.base.DaoSupport;
import com.recruit.bean.NotiUserBean;
import com.recruit.bean.PageBean;
import com.recruit.model.Notification;

import java.util.List;

public interface NotificationDao extends DaoSupport<Notification>{
    public List<Notification> getAllByType(int type,PageBean pageBean);
    public Integer getSizeByType(int type);
    public List<NotiUserBean>buildList(List<Notification>list);
}
