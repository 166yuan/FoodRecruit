package com.recruit.model;



/**
 *  信息反馈类
 * Created by Administrator on 2014/11/30.
 */

public class Notification {
	
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
    private Long refId;
    
    private BasicModel basicModel;

    public Notification() {
        this.isNew = true;
    }
    

    public Notification(User creator, User receiver, String info, Integer type,
			Boolean isNew, Long refId) {
		super();
		this.creator = creator;
		this.receiver = receiver;
		this.info = info;
		this.type = type;
		this.isNew = isNew;
		this.refId = refId;
	}


	public Long getRefId() {
        return refId;
    }

    public void setRefId(Long refId) {
        this.refId = refId;
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
		return "Notification [creator=" + creator + ", receiver=" + receiver
				+ ", info=" + info + ", type=" + type + ", isNew=" + isNew
				+ ", refId=" + refId + "]";
	}
    
    
}
