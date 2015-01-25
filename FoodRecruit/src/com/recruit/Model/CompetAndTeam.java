package com.recruit.Model;

import javax.persistence.Entity;

/** 竞赛和队伍中间表
 *  @author Yuan
 */
@Entity
public class CompetAndTeam extends BasicModel{
    private Integer user_id;
    private Integer team_id;
    private Integer compet_id;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public Integer getCompet_id() {
        return compet_id;
    }

    public void setCompet_id(Integer compet_id) {
        this.compet_id = compet_id;
    }
}
