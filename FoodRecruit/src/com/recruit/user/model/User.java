package com.recruit.user.model;

import com.recruit.Model.BasicModel;

import java.io.Serializable;
import java.security.Identity;
import java.util.Date;

import javax.persistence.*;

/** 用户类
 *  @author Yuan
  */
@Entity
public class User extends BasicModel {
    @Column(nullable = false)
    //用户账号，也是用户名
	private String account;
    @Column(nullable = false)
    //用户密码
	private String password;
    //用户类型：1为学生 2为管理员 3为超级管理员
    private Integer type;
    //账号状态:1为通常审核 -1未审核通过，-2冻结
    private Integer status;
    //用户真实姓名
    private String name;
    //头像链接
    private String image_url;
    //性别 1 为男 0为女
	private int gender;
    //专业
    private String major;
    //班级
    private String classes;
    //手机
    private String phone;
    //邮箱
    private String email;
    private String qq;
    //地址
    private String address;
    //个人介绍
    private String self_info;
    //是否主动招收
    private String isActive;

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public User(){

    }
    
    public User(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}
    
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
		return image_url;
	}
    
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSelf_info() {
        return self_info;
    }

    public void setSelf_info(String self_info) {
        this.self_info = self_info;
    }




}
