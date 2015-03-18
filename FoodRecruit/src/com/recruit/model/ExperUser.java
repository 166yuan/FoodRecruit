package com.recruit.model;

import java.util.Date;



/**
 * Created by Administrator on 2014/11/30.
 */
public class ExperUser  implements InstanceInterface {
	
	private Integer id;
    //实验id
    private Experiment experiment;
    //用户id
    private User user;
    //score ID
    private Score score;
    //实验是否过期
    private Boolean isPassed;
    //是否评分完毕
    private Boolean isEvaluate;
    //是否同意成为助手
    private Boolean isAgree;

    public Date createTime;
    
    public Date updateTime;
    
    public ExperUser(){
    	inite();
    }

    

    public ExperUser(Experiment experiment, User user, Score score,
			Boolean isPassed, Boolean isEvaluate, Boolean isAgree) {
		super();
		this.experiment = experiment;
		this.user = user;
		this.score = score;
		this.isPassed = isPassed;
		this.isEvaluate = isEvaluate;
		this.isAgree = isAgree;
		
	}

    /**初始化类，如所当前时间赋值给createTime 和 updateTime
	 * isPassed = false;isEvaluate=false;isAgree=false;
	 */
	public ExperUser inite(){
		this.createTime=new Date();
        this.updateTime=new Date();
        isPassed=false;
        isEvaluate=false;
        isAgree = false;
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



	public Experiment getExperiment() {
		return experiment;
	}



	public void setExperiment(Experiment experiment) {
		this.experiment = experiment;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Score getScore() {
		return score;
	}



	public void setScore(Score score) {
		this.score = score;
	}



	public Boolean getIsPassed() {
        return isPassed;
    }

    public void setIsPassed(Boolean isPassed) {
        this.isPassed = isPassed;
    }

    public Boolean getIsEvaluate() {
        return isEvaluate;
    }

    public void setIsEvaluate(Boolean isEvaluate) {
        this.isEvaluate = isEvaluate;
    }

    public Boolean getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(Boolean isAgree) {
        this.isAgree = isAgree;
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
