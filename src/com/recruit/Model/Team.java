package com.recruit.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2014/11/21.
 */
@Entity
public class Team extends BasicModel{
    private String name;
    private Integer size;
    private String slogan;
    private Integer leader_id;
    private  String password;
    private Integer competition_id;

    public Team() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public Integer getLeader_id() {
        return leader_id;
    }

    public void setLeader_id(Integer leader_id) {
        this.leader_id = leader_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCompetition_id() {
        return competition_id;
    }

    public void setCompetition_id(Integer competition_id) {
        this.competition_id = competition_id;
    }
}
