package com.recruit.model;

import java.util.Date;



/**
 * Created by Administrator on 2015/2/13.
 */

public class Major  implements InstanceInterface{
	
	private Integer id;
	
    private String majorName;

    private Integer year;
    
    public Date createTime;
    
    public Date updateTime;

    
    
    public Major() {
		super();
        inite();
	}

	public Major(String majorName, int year) {
		super();
		this.majorName = majorName;
		this.year = year;
	}

	/**初始化类，如所当前时间赋值给createTime 和 updateTime
	 * 
	 */
	public Major inite(){
		this.createTime=new Date();
        this.updateTime=new Date();
        return this;
	}
	
	public Integer getYear() {
        return year;
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

	public void setYear(Integer year) {
        this.year = year;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
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
