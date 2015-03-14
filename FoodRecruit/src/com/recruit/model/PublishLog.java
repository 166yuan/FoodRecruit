package com.recruit.model;



/** 发布记录，记录管理员操作
 * @author Yuan
 */
public class PublishLog {

	private Integer id;
	
    //发布内容归属：0实验 1竞赛
    private Integer type;
    //发布的信息
    private String info;

    private BasicModel basicModel;
    
    public PublishLog() {
		super();
	}

	public PublishLog(Integer type, String info) {
		super();
		this.type = type;
		this.info = info;
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

	@Override
	public String toString() {
		return "PublishLog [type=" + type + ", info=" + info + "]";
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




}
