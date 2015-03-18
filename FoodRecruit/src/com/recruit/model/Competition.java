package com.recruit.model;


import java.util.Date;

/** 竞赛类
 * @author Yuan
 */

public class Competition implements InstanceInterface{
	private Integer id;
    //竞赛介绍的图片链接
    private String image_url;
    //竞赛页面链接
	private String link;
    //竞赛名称
    private String name;
    //竞赛介绍
    private String information;
    //竞赛队伍人数限制
    private Integer minNumber;

    private Integer maxNumber;

    private Date beginTime;

    private Date endTime;
    
    public Date createTime;
    
    public Date updateTime;
    
    public Competition(){
    	super();
        inite();
    }
    
    
    
    public Competition(String image_url, String link, String name,
			String information, Integer minNumber, Integer maxNumber,
			Date beginTime, Date endTime) {
		super();
		this.image_url = image_url;
		this.link = link;
		this.name = name;
		this.information = information;
		this.minNumber = minNumber;
		this.maxNumber = maxNumber;
		this.beginTime = beginTime;
		this.endTime = endTime;
		
	}


    /**初始化类，如所当前时间赋值给createTime 和 updateTime
	 * 
	 */
	public Competition inite(){
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



	public String getImage_url() {
		return image_url;
	}
    
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}

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

    public Integer getMinNumber() {
        return minNumber;
    }

    public void setMinNumber(Integer minNumber) {
        this.minNumber = minNumber;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
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
