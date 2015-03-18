package com.recruit.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/** 竞赛队伍
 *  @author Yuan
 */

public class Team implements InstanceInterface{
	
	private Integer id;
	
    //队伍名字
    private String name;
    //队伍最多人数
    private Integer maxSize;
    //队伍口号
    private String slogan;
    //队长id
    private User leader;
    //入队密码
    private  String password;
    //竞赛id
    private Competition competition;
    //组队状态
    private Integer type;
    
    public Date createTime;
    
    public Date updateTime;
    
    private Set<CompetAndTeam> participants = new HashSet<CompetAndTeam>();
    

	public Team() {
		super();
        inite();
	}


	public Team(String name, Integer maxSize, String slogan, User leader,
			String password, Competition competition, Integer type) {
		super();
		this.name = name;
		this.maxSize = maxSize;
		this.slogan = slogan;
		this.leader = leader;
		this.password = password;
		this.competition = competition;
		this.type = type;
	}

	
	/**初始化类，如所当前时间赋值给createTime 和 updateTime
	 * 
	 */
	public Team inite(){
		this.createTime=new Date();
        this.updateTime=new Date();
        return this;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getMaxSize() {
		return maxSize;
	}


	public void setMaxSize(Integer maxSize) {
		this.maxSize = maxSize;
	}


	public String getSlogan() {
		return slogan;
	}


	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}


	public User getLeader() {
		return leader;
	}


	public void setLeader(User leader) {
		this.leader = leader;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Competition getCompetition() {
		return competition;
	}


	public void setCompetition(Competition competition) {
		this.competition = competition;
	}


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	


	


	public Set<CompetAndTeam> getParticipants() {
		return participants;
	}


	public void setParticipants(Set<CompetAndTeam> participants) {
		this.participants = participants;
	}


	@Override
	public String toString() {
		return "[createTime=" + createTime + "]";
	}

	@Override
	public InstanceInterface toInstanceModel(InstanceInterface... iis) {

		for(InstanceInterface ii:iis){
			System.out.println(ii.toString());
		}
		
		return this;
	}



   
}
