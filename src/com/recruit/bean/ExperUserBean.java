package com.recruit.bean;

import com.recruit.model.ExperUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2015/3/15.
 */
public class ExperUserBean {
    private Integer experId;
    private Integer userId;
    private String name;
    private String major;
    private String classes;
    private Date appTime;
    private Boolean gender;
    private double score;
    private Boolean isAgree;
    private Boolean isEvaluate;

    public static ExperUserBean build(ExperUser experUser){
        ExperUserBean euBean=new ExperUserBean();
        euBean.setExperId(experUser.getExperiment().getId());
        euBean.setUserId(experUser.getUser().getId());
        euBean.setIsAgree(experUser.getIsAgree());
       // euBean.setAppTime();
        euBean.setName(experUser.getUser().getName());
        euBean.setGender(experUser.getUser().getGender());
        euBean.setIsEvaluate(experUser.getIsEvaluate());
        return euBean;
    }

    public static List<ExperUserBean> buildList(List<ExperUser>list){
        List<ExperUserBean>euList=new ArrayList<ExperUserBean>();
        Iterator<ExperUser> iterator=list.iterator();
        while(iterator.hasNext()){
            euList.add(build(iterator.next()));
        }
        return euList;
    }

    public Integer getExperId() {
        return experId;
    }

    public void setExperId(Integer experId) {
        this.experId = experId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Date getAppTime() {
        return appTime;
    }

    public void setAppTime(Date appTime) {
        this.appTime = appTime;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Boolean getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(Boolean isAgree) {
        this.isAgree = isAgree;
    }

    public Boolean getIsEvaluate() {
        return isEvaluate;
    }

    public void setIsEvaluate(Boolean isEvaluate) {
        this.isEvaluate = isEvaluate;
    }
}
