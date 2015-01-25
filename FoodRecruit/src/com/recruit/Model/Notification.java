package com.recruit.Model;

import javax.persistence.Entity;

/**
 * Created by Administrator on 2014/11/30.
 */
@Entity
public class Notification extends BasicModel{
private String userId;
private String info;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    //反馈类型 默认为 0 反馈 1录取通知 2 竞赛通知
private Integer type;
}
