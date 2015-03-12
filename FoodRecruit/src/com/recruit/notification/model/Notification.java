package com.recruit.notification.model;

import com.recruit.Model.BasicModel;

import javax.persistence.Entity;

/**
 *  信息反馈类
 * Created by Administrator on 2014/11/30.
 */
@Entity
public class Notification extends BasicModel {
    //通知发起人id
    private Long creatorId;
    //信息接受人id
    private Long receiverId;
    //信息内容
    private String info;
    //反馈类型  0申请通知 1录取通知 2 竞赛通知 3反馈 4回复 9只是消息
    private Integer type;
    //true:未读  false:已读
    private Boolean isNew;

    //参考关联id 表示该通知关联的实验id 或者是 在竞赛中关联的队伍id
    private Long refId;

    public Notification() {
        this.isNew = true;
    }

    public Long getRefId() {
        return refId;
    }

    public void setRefId(Long refId) {
        this.refId = refId;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }
}
