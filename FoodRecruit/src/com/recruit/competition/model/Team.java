package com.recruit.competition.model;

import com.recruit.Model.BasicModel;

import javax.persistence.Entity;
import javax.persistence.Table;

/** 竞赛队伍
 *  @author Yuan
 */
@Entity
public class Team extends BasicModel {
    //队伍名字
    private String name;
    //队伍
    private Integer size;
    //队伍口号
    private String slogan;
    //队长id
    private Long leader_id;
    //入队密码
    private  String password;
    //竞赛id
    private Long competition_id;
    //组队状态
    private Integer type;
    //当前人数
    private Integer currentNum;

    public Integer getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(Integer currentNum) {
        this.currentNum = currentNum;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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

    public Long getLeader_id() {
        return leader_id;
    }

    public void setLeader_id(Long leader_id) {
        this.leader_id = leader_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCompetition_id() {
        return competition_id;
    }

    public void setCompetition_id(Long competition_id) {
        this.competition_id = competition_id;
    }
}
