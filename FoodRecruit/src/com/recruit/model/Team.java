package com.recruit.model;

import java.util.ArrayList;
import java.util.List;


/** 竞赛队伍
 *  @author Yuan
 */

public class Team{
	
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
    
    private BasicModel basicModel;
    
    private List<CompetAndTeam> participtList = new ArrayList<CompetAndTeam>();
    

	public Team() {
		super();
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


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public BasicModel getBasicModel() {
		return basicModel;
	}


	public void setBasicModel(BasicModel basicModel) {
		this.basicModel = basicModel;
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


	public List<CompetAndTeam> getParticiptList() {
		return participtList;
	}


	public void setParticiptList(List<CompetAndTeam> participtList) {
		this.participtList = participtList;
	}


	@Override
	public String toString() {
		return "Team [name=" + name + ", maxSize=" + maxSize + ", slogan="
				+ slogan + ", leader=" + leader + ", password=" + password
				+ ", competition=" + competition + ", type=" + type + "]";
	}



   
}
