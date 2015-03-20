package com.recruit.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2014/11/30.
 */
public class Experiment  implements InstanceInterface{

	private Integer id;
	
    //实验名
    private String name;
    //实验信息
    private String information;
    //实验要求
    private String requirement;
    //实验性质
    private String type;
    //联系人
    private String contact;
    //电话
    private String phone;
    //邮箱
    private String email;
    //QQ
    private String QQ;
    //所需实验人数
    private Integer count;
   //发布者id
    private User publisher;
    //备注
    private String note;
   //开始时间
    private Date beginTime;
    //结束时间
    private Date endTime;
    //是否已经招够助手
    private Boolean isOk;
    
    public Date createTime;
    
    public Date updateTime;
    
    Set<ExperUser> experUsers = new HashSet<ExperUser>();

    

	public Experiment() {
		inite();
	}

	public Experiment(String name, String information, String requirement,
			String type, String contact, String phone, String email, String qQ,
			int count, User publisher, String note, Date beginTime,
			Date endTime, boolean isOk, Boolean isOutDate) {
		super();
		this.name = name;
		this.information = information;
		this.requirement = requirement;
		this.type = type;
		this.contact = contact;
		this.phone = phone;
		this.email = email;
		QQ = qQ;
		this.count = count;
		this.publisher = publisher;
		this.note = note;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.isOk = isOk;
		this.isOutDate = isOutDate;
	}
	
	/**初始化类，如所当前时间赋值给createTime 和 updateTime isOk=false
	 * 
	 */
	public Experiment inite(){
		this.createTime=new Date();
        this.updateTime=new Date();
        isOk=false;
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

	public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean isOk) {
        this.isOk = isOk;
    }

    public ArrayList<ExperUser>getExperUser(){
        return new ArrayList<ExperUser>(experUsers);
    }

    public User getPublisher() {
		return publisher;
	}

	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}

	public Boolean getIsOutDate() {
        return isOutDate;
    }

    public void setIsOutDate(Boolean isOutDate) {
        this.isOutDate = isOutDate;
    }

    private  Boolean isOutDate;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    
	public Boolean getIsOk() {
		return isOk;
	}

	public void setIsOk(Boolean isOk) {
		this.isOk = isOk;
	}

	public Set<ExperUser> getExperUsers() {
		return experUsers;
	}

	public void setExperUsers(Set<ExperUser> experUsers) {
		this.experUsers = experUsers;
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
