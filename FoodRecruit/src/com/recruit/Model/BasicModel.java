package com.recruit.model;

import java.util.Date;

/** model基类,继承了这个类的model都会拥有下面的属性方法。
 * @author Yuan
 */

public class BasicModel{


   
    public Date createTime;
    
    public Date updateTime;
    


    public BasicModel(){
        createTime=new Date();
        updateTime=new Date();
    }
    
    
    
public BasicModel(Date createTime, Date updateTime) {
		super();
		this.createTime = createTime;
		this.updateTime = updateTime;
	}



//    void beforeSave(){
//        Date now=new Date();
//        if (createTime == null) {
//            createTime = now;
//        }
//        updateTime = now;
//    }



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
