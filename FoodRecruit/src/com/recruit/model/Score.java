package com.recruit.model;

import java.util.Date;



/** 实验评价
 * @author Yuan
 */
public class Score {
	
	private Integer id;

	//实验id
    private Experiment experiment;
    //实验员id
    private User student;
    //评价人id
    private User teacher;

    //责任心 20分
    private Integer duty;
    //纪律20 分
    private Integer discipline;
    //整洁 15
    private  Integer tidy;
    //细心15分
    private  Integer care;
    //操作规范10分
    private Integer operation;
    // 改错态度10分
    private Integer fault;
    //完成效率 10
    private  Integer efficiency;
    //建议分5
    private  Integer advise;
    //a项总分
    private  Integer scoreA;
    //b项总分
    private  Integer scoreB;

    //第三方评价
    //注重整洁20分
    private  Integer Ttidy;
    //细心，爱惜仪器20分
    private  Integer Tcare;
    //操作规范，严谨15分
    private  Integer Toperation;
// 积极与实验员联系 15
    private  Integer Tconnect;

    //科联会员10分
    private Integer member;
    //主动联系科联负责人备案20分
    private  Integer recorded;
    //附加分
    private Integer append;

    //科联跟踪评分总分
    private Integer secscore;
    private Double total;

    public Date createTime;
    
    public Date updateTime;
    
    public Score() {
		super();
        inite();
	}


	public Score(Experiment experiment, User student, User teacher,
			Integer duty, Integer discipline, Integer tidy, Integer care,
			Integer operation, Integer fault, Integer efficiency,
			Integer advise, Integer scoreA, Integer scoreB, Integer ttidy,
			Integer tcare, Integer toperation, Integer tconnect,
			Integer member, Integer recorded, Integer append, Integer secscore,
			Double total) {
		super();
		this.experiment = experiment;
		this.student = student;
		this.teacher = teacher;
		this.duty = duty;
		this.discipline = discipline;
		this.tidy = tidy;
		this.care = care;
		this.operation = operation;
		this.fault = fault;
		this.efficiency = efficiency;
		this.advise = advise;
		this.scoreA = scoreA;
		this.scoreB = scoreB;
		Ttidy = ttidy;
		Tcare = tcare;
		Toperation = toperation;
		Tconnect = tconnect;
		this.member = member;
		this.recorded = recorded;
		this.append = append;
		this.secscore = secscore;
		this.total = total;
	}

	/**初始化类，如所当前时间赋值给createTime 和 updateTime
	 * 
	 */
	public Score inite(){
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


	public Integer getDuty() {
        return duty;
    }


    public Integer getDiscipline() {
        return discipline;
    }

    public Integer getTidy() {
        return tidy;
    }

    public Integer getCare() {
        return care;
    }

    public Integer getOperation() {
        return operation;
    }

    public Integer getFault() {
        return fault;
    }

    public Integer getAdvise() {
        return advise;
    }

    public Integer getEfficiency() {
        return efficiency;
    }

    public Integer getScoreB() {
        return scoreB;
    }

    public Integer getScoreA() {
        return scoreA;
    }

    public Integer getTtidy() {
        return Ttidy;
    }

    public Integer getTcare() {
        return Tcare;
    }

    public Integer getToperation() {
        return Toperation;
    }

    public Integer getTconnect() {
        return Tconnect;
    }

    public Integer getMember() {
        return member;
    }

    public Integer getRecorded() {
        return recorded;
    }

    public Integer getAppend() {
        return append;
    }

    public Double getTotal() {
        return total;
    }

    public void setDuty(Integer duty) {
        this.duty = duty;
    }

    public void setDiscipline(Integer discipline) {
        this.discipline = discipline;
    }

    public void setTidy(Integer tidy) {
        this.tidy = tidy;
    }

    public void setCare(Integer care) {
        this.care = care;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public void setFault(Integer fault) {
        this.fault = fault;
    }

    public void setEfficiency(Integer efficiency) {
        this.efficiency = efficiency;
    }

    public void setAdvise(Integer advise) {
        this.advise = advise;
    }

    public void setScoreA() {
        this.scoreA =duty+discipline+tidy+care+operation+fault+efficiency+advise;
    }

    public void setScoreB(Integer scoreB) {
        this.scoreB = scoreB;
    }

    public void setTtidy(Integer ttidy) {
        Ttidy = ttidy;
    }

    public void setTcare(Integer tcare) {
        Tcare = tcare;
    }

    public void setToperation(Integer toperation) {
        Toperation = toperation;
    }

    public void setTconnect(Integer tconnect) {
        Tconnect = tconnect;
    }

    public void setMember(Integer member) {
        this.member = member;
    }

    public void setRecorded(Integer recorded) {
        this.recorded = recorded;
    }

    public void setAppend(Integer append) {
        this.append = append;
    }

    public void setSecscore() {
        this.secscore = Ttidy+Tcare+Tconnect+Toperation+member+recorded;
    }

    public void setTotal() {
        this.total = (scoreA+scoreB)*0.5*0.8+secscore*0.2+append;
    }



    public Experiment getExperiment() {
		return experiment;
	}


	public void setExperiment(Experiment experiment) {
		this.experiment = experiment;
	}


	public User getStudent() {
		return student;
	}


	public void setStudent(User student) {
		this.student = student;
	}


	public User getTeacher() {
		return teacher;
	}


	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}


	public void setScoreA(Integer scoreA) {
		this.scoreA = scoreA;
	}


	public void setSecscore(Integer secscore) {
		this.secscore = secscore;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


	public Integer getSecscore() {
        return secscore;
    }


	@Override
	public String toString() {
		return "Score [experiment=" + experiment + ", student=" + student
				+ ", teacher=" + teacher + ", duty=" + duty + ", discipline="
				+ discipline + ", tidy=" + tidy + ", care=" + care
				+ ", operation=" + operation + ", fault=" + fault
				+ ", efficiency=" + efficiency + ", advise=" + advise
				+ ", scoreA=" + scoreA + ", scoreB=" + scoreB + ", Ttidy="
				+ Ttidy + ", Tcare=" + Tcare + ", Toperation=" + Toperation
				+ ", Tconnect=" + Tconnect + ", member=" + member
				+ ", recorded=" + recorded + ", append=" + append
				+ ", secscore=" + secscore + ", total=" + total + "]";
	}
	
}
