package com.recruit.model;

import java.util.Date;



/** 发布记录，记录管理员操作
 * @author Yuan
 */
public class PublishLog  implements InstanceInterface{

	private Integer id;
	
    //发布内容归属：0实验 1竞赛
    private Integer type;
    //发布的信息
    private String info;

    public Date createTime;
    
    public Date updateTime;
    
    public PublishLog() {
		super();
        inite();
	}

	public PublishLog(Integer type, String info) {
		super();
		this.type = type;
		this.info = info;
	}

	
	/**初始化类，如所当前时间赋值给createTime 和 updateTime
	 * 
	 */
	public PublishLog inite(){
		this.createTime=new Date();
        this.updateTime=new Date();
        return this;
	}
	
	public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
