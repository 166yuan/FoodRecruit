package com.recruit.bean;

import java.util.List;

/**
 * Created by Administrator on 2015/3/19.
 */
public class MyTeamBean {
    String Leader;
    //竞赛名称
    String comName;
    //组队状态
    boolean teamType;

     List<String> nameList;

    public String getLeader() {
        return Leader;
    }

    public void setLeader(String leader) {
        Leader = leader;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public boolean isTeamType() {
        return teamType;
    }

    public void setTeamType(boolean teamType) {
        this.teamType = teamType;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }
}
