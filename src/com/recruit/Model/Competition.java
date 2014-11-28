package com.recruit.Model;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Administrator on 2014/11/21.
 */
@Entity
public class Competition extends BasicModel{

    private String image_url;
	private String link;
    private String name;
    private String information;
    private Integer numberLimit;
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

    public Integer getNumberLimit() {
        return numberLimit;
    }

    public void setNumberLimit(Integer numberLimit) {
        this.numberLimit = numberLimit;
    }
}
