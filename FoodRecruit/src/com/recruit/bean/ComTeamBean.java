package com.recruit.bean;

import java.util.Date;

/**
 * Created by Administrator on 2015/3/19.
 */
public class ComTeamBean {
    private String competName;
    private Integer competId;
    private Integer teamId;
    private Date beginTime;
    private Date endTime;

    public String getCompetName() {
        return competName;
    }

    public void setCompetName(String competName) {
        this.competName = competName;
    }

    public Integer getCompetId() {
        return competId;
    }

    public void setCompetId(Integer competId) {
        this.competId = competId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
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
}
