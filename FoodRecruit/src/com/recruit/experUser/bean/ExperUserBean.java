package com.recruit.experUser.bean;

import com.recruit.experUser.model.ExperUser;
import com.recruit.user.Dao.UserDao;
import com.recruit.user.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/** 记录申请人信息的bean
 * Created by Administrator on 2015/3/5.
 */
public class ExperUserBean {
    private Long experId;
    private Long userId;
    private String name;
    private String major;
    private String classes;
    private Date appTime;
    private int gender;
    private Boolean isAgree;
    static UserDao userDao=UserDao.getInstance();
    public static ExperUserBean  build(ExperUser experUser){
        Long userId=experUser.getUserId();
        User user=userDao.getUserById(userId);
        ExperUserBean experUserBean=new ExperUserBean();
        experUserBean.setExperId(experUser.getExperId());
        experUserBean.setUserId(userId);
        experUserBean.setIsAgree(experUser.getIsAgree());
        experUserBean.setAppTime(experUser.getCreateTime());
        experUserBean.setName(user.getName());
        experUserBean.setGender(user.getGender());
        //后期要修改这里
        experUserBean.setClasses(user.getClasses());
        experUserBean.setMajor(user.getMajor());
        return experUserBean;
    }
    public static List<ExperUserBean> buildList(List<ExperUser>list){
        List<ExperUserBean>euList=new ArrayList<ExperUserBean>();
        Iterator<ExperUser>iterator=list.iterator();
        while(iterator.hasNext()){
        euList.add(build(iterator.next()));
        }
        return euList;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Long getExperId() {
        return experId;
    }

    public void setExperId(Long experId) {
        this.experId = experId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Boolean getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(Boolean isAgree) {
        this.isAgree = isAgree;
    }

    public Date getAppTime() {
        return appTime;
    }

    public void setAppTime(Date appTime) {
        this.appTime = appTime;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}