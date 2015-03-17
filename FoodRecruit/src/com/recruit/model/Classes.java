package com.recruit.model;

import java.util.Date;



/**
 * Created by Administrator on 2015/2/13.
 */

public class Classes {
	
	private Integer id;
    private String className;

    private Major major;

    public Date createTime;
    
    public Date updateTime;
  
    

    public Classes() {
		super();
		inite();
	}

	public Classes(String className, Major major) {
		super();
		this.className = className;
		this.major = major;
		
	}
	
	/**初始化类，如所当前时间赋值给createTime 和 updateTime
	 * 
	 */
	public Classes inite(){
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

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}



	public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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
