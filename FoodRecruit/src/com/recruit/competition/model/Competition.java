package com.recruit.competition.model;

import com.recruit.Model.BasicModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/** 竞赛类
 * @author Yuan
 */
@Entity
public class Competition extends BasicModel {

    //竞赛介绍的图片链接
    private String image_url;
    //竞赛页面链接
	private String link;
    //竞赛名称
    private String name;
    //竞赛介绍
    @Column(length = 65534)
    private String information;
    //竞赛队伍人数限制
    private Integer minNumber;

    private Integer maxNumber;

    private Date beginTime;

    private Date endTime;
    public Competition(){

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
}
