package com.recruit.model;



/**
 * Created by Administrator on 2014/11/30.
 */
public class ExperUser  {
	
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

    private BasicModel basicModel;
    
    public ExperUser(){
        isPassed=false;
        isEvaluate=false;
        isAgree = false;
    }

    

    public ExperUser(Experiment experiment, User user, Score score,
			Boolean isPassed, Boolean isEvaluate, Boolean isAgree,
			BasicModel basicModel) {
		super();
		this.experiment = experiment;
		this.user = user;
		this.score = score;
		this.isPassed = isPassed;
		this.isEvaluate = isEvaluate;
		this.isAgree = isAgree;
		this.basicModel = basicModel;
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
		return "ExperUser [experiment=" + experiment + ", user=" + user
				+ ", score=" + score + ", isPassed=" + isPassed
				+ ", isEvaluate=" + isEvaluate + ", isAgree=" + isAgree + "]";
	}
    
    
}
