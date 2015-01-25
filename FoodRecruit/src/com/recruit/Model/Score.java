package com.recruit.Model;

import javax.persistence.Entity;

/** 实验评价
 * @author Yuan
 */
@Entity
public class Score extends BasicModel{
//实验员
private String userId;
 //
private String fromId;
private Integer duty;
private Integer discipline;
private Integer prepare;
private Integer careful;
private Integer criterion;
private Integer ontime;
private Integer thought;
private Double Total;

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double total) {
        Total = total;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getDuty() {
        return duty;
    }

    public void setDuty(Integer duty) {
        this.duty = duty;
    }

    public Integer getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Integer discipline) {
        this.discipline = discipline;
    }

    public Integer getPrepare() {
        return prepare;
    }

    public void setPrepare(Integer prepare) {
        this.prepare = prepare;
    }

    public Integer getCareful() {
        return careful;
    }

    public void setCareful(Integer careful) {
        this.careful = careful;
    }

    public Integer getCriterion() {
        return criterion;
    }

    public void setCriterion(Integer criterion) {
        this.criterion = criterion;
    }

    public Integer getOntime() {
        return ontime;
    }

    public void setOntime(Integer ontime) {
        this.ontime = ontime;
    }

    public Integer getThought() {
        return thought;
    }

    public void setThought(Integer thought) {
        this.thought = thought;
    }
}
