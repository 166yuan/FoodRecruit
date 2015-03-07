package com.recruit.publicLog.model;

import com.recruit.Model.BasicModel;

import javax.persistence.Entity;

/** 发布记录，记录管理员操作
 * @author Yuan
 */
@Entity
public class PublishLog extends BasicModel {

    //发布内容归属：0实验 1竞赛
    private Integer type;

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

    //发布的信息
    private String info;


}
