package com.recruit.experUser.model;

import com.recruit.Model.BasicModel;

import javax.persistence.Entity;

/**
 * Created by Administrator on 2014/11/30.
 */
@Entity
public class ExperUser extends BasicModel {
    //实验id
    private Long experId;
    //用户id
    private Long userId;
    //score ID
    private Long scoreId;
    //实验是否过期
    private Boolean isPassed;
    //是否评分完毕
    private Boolean isEvaluate;
    //是否同意成为助手
    private Boolean isAgree;

    public ExperUser(){
        isPassed=false;
        isEvaluate=false;
        isAgree = false;
    }

    public Long getExperId() {
        return experId;
    }

    public void setExperId(Long experId) {
        this.experId = experId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getScoreId() {
        return scoreId;
    }

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
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

    public Boolean getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(Boolean isAgree) {
        this.isAgree = isAgree;
    }
}
