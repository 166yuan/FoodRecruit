package com.recruit.experiment.model;

import com.recruit.Model.BasicModel;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Administrator on 2014/11/30.
 */
@Entity
public class Experiment extends BasicModel {

    //实验名
    private String name;
    //实验信息
    private String information;
    //实验要求
    private String requirement;
    //实验性质
    private String type;
    //联系人
    private String contact;
    //电话
    private String phone;
    //邮箱
    private String email;
    //QQ
    private String QQ;
    //所需实验人数
    private int count;
   //发布者id
    private Long publishId;
    //发布者姓名
    private String publishName;
    //备注
    private String note;
   //开始时间
    private Date beginTime;
    //结束时间
    private Date endTime;
    //是否已经招够助手
    private boolean isOk;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Experiment(){
        isOk = false;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean isOk) {
        this.isOk = isOk;
    }

    public String getPublishName() {
        return publishName;
    }

    public void setPublishName(String publishName) {
        this.publishName = publishName;
    }

    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    public Boolean getIsOutDate() {
        return isOutDate;
    }

    public void setIsOutDate(Boolean isOutDate) {
        this.isOutDate = isOutDate;
    }

    private  Boolean isOutDate;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
