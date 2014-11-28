package com.recruit.Model;

import java.util.Date;

/**
 * Created by Administrator on 2014/11/21.
 */
public class Competition {
    private Integer id;
    private String image_url;
	private String link;
    private String name;
    private String information;
    private Integer numberLimit;
    private Date createTime;
    private Date updateTime;
    public Competition(){

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

    public Integer getNumberLimit() {
        return numberLimit;
    }

    public void setNumberLimit(Integer numberLimit) {
        this.numberLimit = numberLimit;
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
