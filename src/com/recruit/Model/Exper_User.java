package com.recruit.Model;

import javax.persistence.Entity;

/**
 * Created by Administrator on 2014/11/30.
 */
@Entity
public class Exper_User extends BasicModel{
    private String experId;
    private String userId;
    //实验是否过期
    private Boolean isPassed;
    //是否评分完毕
    private Boolean isEvaluate;
    public Exper_User(){
        isPassed=false;
        isEvaluate=false;
    }

    public String getExperId() {
        return experId;
    }

    public void setExperId(String experId) {
        this.experId = experId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getIsPassed() {
        return isPassed;
    }

    public void setIsPassed(Boolean isPassed) {
        this.isPassed = isPassed;
    }

    public Boolean getIsEvaluate() {
        return isEvaluate;
    }

    public void setIsEvaluate(Boolean isEvaluate) {
        this.isEvaluate = isEvaluate;
    }
}
