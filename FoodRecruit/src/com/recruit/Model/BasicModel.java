package com.recruit.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/** model基类
 * @author Yuan
 */
@MappedSuperclass
public class BasicModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "create_time")
    public Date createTime;
    @Column(name = "update_time")
    public Date updateTime;

    void beforeSave(){
        Date now=new Date();
        if (createTime == null) {
            createTime = now;
        }
        updateTime = now;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
