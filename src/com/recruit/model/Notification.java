package com.recruit.model;

import java.util.Date;



/**
 *  信息反馈类
 * Created by Administrator on 2014/11/30.
 */

public class Notification  implements InstanceInterface{
	
	private Integer id;
	
    //通知发起人id
    private User creator;
    //信息接受人id
    private User receiver;
    //信息内容
    private String info;
    //反馈类型  0申请通知 1录取通知 2 竞赛通知 3反馈 4回复 9只是消息
    private Integer type;
    //true:未读  false:已读
    private Boolean isNew;

    //参考关联id 表示该通知关联的实验id 或者是 在竞赛中关联的队伍id
    private Integer refId;
    
    public Date createTime;
    
    public Date updateTime;

    public Notification() {
        this.isNew = true;
        this.createTime=new Date();
        this.updateTime=new Date();
    }
    

    public Notification(User creator, User receiver, String info, Integer type,
			Boolean isNew, Integer refId) {
		super();
		this.creator = creator;
		this.receiver = receiver;
		this.info = info;
		this.type = type;
		this.isNew = isNew;
		this.refId = refId;
	}
    /**初始化类，如所当前时间赋值给createTime 和 updateTime
	 * isNew = true;
	 */
	public Notification inite(){
		this.createTime=new Date();
        this.updateTime=new Date();
        this.isNew=true;
        return this;
	}

	public Integer getRefId() {
        return refId;
    }

    public void setRefId(Integer refId) {
        this.refId = refId;
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


	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
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

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
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
