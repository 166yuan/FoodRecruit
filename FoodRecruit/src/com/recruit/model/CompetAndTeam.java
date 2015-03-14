package com.recruit.model;




/** 竞赛和队伍中间表
 *  @author Yuan
 */

public class CompetAndTeam  {
	
	private Integer id;
    //用户

    private User user;
    //队伍

    private Team team;
    
    private BasicModel basicModel;
  

	public CompetAndTeam(User user, Team team) {
		super();
		this.user = user;
		this.team = team;
		
	}

	public CompetAndTeam() {
		super();
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

	public BasicModel getBasicModel() {
		return basicModel;
	}

	public void setBasicModel(BasicModel basicModel) {
		this.basicModel = basicModel;
	}

	@Override
	public String toString() {
		return "CompetAndTeam [id=" + id + ", user=" + user + ", team=" + team
				+ ", basicModel=" + basicModel + "]";
	}



	

   
}
