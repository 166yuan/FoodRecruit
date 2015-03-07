package com.recruit.Model;

import javax.persistence.Entity;

/**
 * Created by Administrator on 2015/2/13.
 */
@Entity
public class Classes extends  BasicModel{
    private String className;

    private Long majorId;

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
