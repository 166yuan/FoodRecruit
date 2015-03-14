package com.recruit.model;



/**
 * Created by Administrator on 2015/2/13.
 */

public class Major {
	
	private Integer id;
	
    private String majorName;

    private int year;
    
    private BasicModel basicModel;

    
    
    public Major() {
		super();
	}

	public Major(String majorName, int year, BasicModel basicModel) {
		super();
		this.majorName = majorName;
		this.year = year;
		this.basicModel = basicModel;
	}

	public int getYear() {
        return year;
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

	public void setYear(int year) {
        this.year = year;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
}
