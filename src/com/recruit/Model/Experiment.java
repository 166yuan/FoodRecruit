package com.recruit.Model;

import javax.persistence.Entity;

/**
 * Created by Administrator on 2014/11/30.
 */
@Entity
public class Experiment extends BasicModel {

    //实验名
    private String name;
    //实验信息
    private String information;
    //人员限制
    private Integer numberLimit;
    //实验性质
    private Integer exper_type;
    //联系人
    private String cont_name;
    //电话
    private String phone;
    //邮箱
    private String email;

    public Boolean getIsOutDate() {
        return isOutDate;
    }

    public void setIsOutDate(Boolean isOutDate) {
        this.isOutDate = isOutDate;
    }

    private  Boolean isOutDate;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getExper_type() {
        return exper_type;
    }

    public void setExper_type(Integer exper_type) {
        this.exper_type = exper_type;
    }

    public Integer getNumberLimit() {
        return numberLimit;
    }

    public void setNumberLimit(Integer numberLimit) {
        this.numberLimit = numberLimit;
    }

    public String getCont_name() {
        return cont_name;
    }

    public void setCont_name(String cont_name) {
        this.cont_name = cont_name;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    //备注
    private String note;
}
