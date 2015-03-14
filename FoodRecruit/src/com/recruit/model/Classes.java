package com.recruit.model;



/**
 * Created by Administrator on 2015/2/13.
 */

public class Classes {
	
	private Integer id;
    private String className;

    private Major major;

    private BasicModel basicModel;
  
    

    public Classes() {
		super();
	}

	public Classes(String className, Major major, BasicModel basicModel) {
		super();
		this.className = className;
		this.major = major;
		this.basicModel = basicModel;
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

	public BasicModel getBasicModel() {
		return basicModel;
	}

	public void setBasicModel(BasicModel basicModel) {
		this.basicModel = basicModel;
	}

	public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
