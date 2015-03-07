package com.recruit.notification.model;

import com.recruit.Model.BasicModel;

import javax.persistence.Entity;

/**
 *  信息反馈类
 * Created by Administrator on 2014/11/30.
 */
@Entity
public class Notification extends BasicModel {
    //信息接受人id
    private Long userId;
    //信息内容
    private String info;
    //反馈类型 默认为 0申请通知 1录取通知 2 竞赛通知 3反馈 4.回复用户
    private Integer type;
    //true:未读  false:已读
    private Boolean isNew;

    public Notification(){
        isNew = true;
    }
    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}
