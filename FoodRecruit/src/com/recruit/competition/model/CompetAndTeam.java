package com.recruit.competition.model;

import com.recruit.Model.BasicModel;

import javax.persistence.Entity;

/** 竞赛和队伍中间表
 *  @author Yuan
 */
@Entity
public class CompetAndTeam extends BasicModel {
    //用户id
    private Long user_id;
    //队伍id
    private Long team_id;
    //竞赛id
    private Long compet_id;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Long team_id) {
        this.team_id = team_id;
    }

    public Long getCompet_id() {
        return compet_id;
    }

    public void setCompet_id(Long compet_id) {
        this.compet_id = compet_id;
    }
}
