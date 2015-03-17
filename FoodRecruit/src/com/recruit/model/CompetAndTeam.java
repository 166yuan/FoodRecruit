package com.recruit.model;

import java.util.Date;




/** 竞赛和队伍中间表
 *  @author Yuan
 */

public class CompetAndTeam  {
	
	private Integer id;
    //用户

    private User user;
    //队伍

    private Team team;
    
    public Date createTime;
    
    public Date updateTime;
  

	public CompetAndTeam(User user, Team team) {
		super();
		this.user = user;
		this.team = team;
		
	}

	public CompetAndTeam() {
		super();
        inite();
	}
	
	/**初始化类，如所当前时间赋值给createTime 和 updateTime
	 * 
	 */
	public CompetAndTeam inite(){
		this.createTime=new Date();
        this.updateTime=new Date();
        return this;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


   
}
