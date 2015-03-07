package com.recruit.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/** model基类,继承了这个类的model都会拥有下面的属性方法。
 * @author Yuan
 */
@MappedSuperclass
public class BasicModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
    每个的id都是从1开始自增长的
     */
    private Long id;
    @Column(name = "create_time")
    public Date createTime;
    @Column(name = "update_time")
    public Date updateTime;

    public BasicModel(){
        createTime=new Date();
        updateTime=new Date();
    }
    void beforeSave(){
        Date now=new Date();
        if (createTime == null) {
            createTime = now;
        }
        updateTime = now;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
