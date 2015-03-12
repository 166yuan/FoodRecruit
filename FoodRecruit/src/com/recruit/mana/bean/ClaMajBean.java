package com.recruit.mana.bean;

import com.recruit.mana.model.Classes;
import com.recruit.mana.model.Major;
import com.recruit.mana.dao.MajorDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** 专业班级bean
 * Created by Administrator on 2015/2/23.
 */
public class ClaMajBean {
    private Long classId;
    private String name;
    private int year;
    private String majorName;
    private Long majorId;

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    private static ClaMajBean build(Classes classes){
        ClaMajBean cla=new ClaMajBean();
        cla.setName(classes.getClassName());
        cla.setClassId(classes.getId());
        MajorDao majorDao=MajorDao.getInstance();
        Major major=majorDao.getMajorById(classes.getMajorId());
        if(major!=null){
            cla.setMajorId(classes.getMajorId());
            cla.setMajorName(major.getMajorName());
            cla.setYear(major.getYear());
        }
        return cla;
    }

    public static List<ClaMajBean> buildList(List<Classes> list){
        List<ClaMajBean> clalist=new ArrayList<ClaMajBean>();
        Iterator<Classes> it=list.iterator();
        while (it.hasNext()){
            clalist.add(build(it.next()));
        }
        return clalist;
    }

}
