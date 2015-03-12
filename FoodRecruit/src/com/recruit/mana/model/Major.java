package com.recruit.mana.model;

import com.recruit.Model.BasicModel;

import javax.persistence.Entity;

/**
 * Created by Administrator on 2015/2/13.
 */
@Entity
public class Major extends BasicModel {
    private String majorName;

    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
}
