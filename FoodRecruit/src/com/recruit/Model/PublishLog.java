package com.recruit.Model;

import javax.persistence.Entity;

/** 发布记录，记录管理员操作
 * @author Yuan
 */
@Entity
public class PublishLog extends BasicModel{

    //发布内容归属：0实验 1竞赛
    private Integer type;
    //发布的信息
    private String info;


}
