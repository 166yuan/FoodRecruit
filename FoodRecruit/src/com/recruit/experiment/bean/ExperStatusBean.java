package com.recruit.experiment.bean;

import com.recruit.experUser.dao.ExperUserDao;
import com.recruit.experUser.model.ExperUser;
import com.recruit.experiment.model.Experiment;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/** 实验状态bean
 * Created by Administrator on 2015/3/9.
 */
public class ExperStatusBean {
    private Long experId;
    private String name;
    private Date beginTime;
    private Date endTime;
    //1表示评分结束 0表示未开始评分 -1表示评分中（未结束）
    private int status;
    static ExperUserDao exDao = ExperUserDao.getInstance();
    public static ExperStatusBean build(Experiment experiment) {
        ExperStatusBean ebean = new ExperStatusBean();
        ebean.setName(experiment.getName());
        ebean.setExperId(experiment.getId());
        ebean.setBeginTime(experiment.getBeginTime());
        ebean.setEndTime(experiment.getEndTime());
        List<ExperUser> list = exDao.getByExperId(experiment.getId());
        int all = list.size();
        int temp = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIsEvaluate() == true) {
                temp++;
            }
        }
        if (temp == all) {
            ebean.setStatus(1);
        } else if (temp != 0 && temp < all) {
            ebean.setStatus(-1);
        } else if (temp == 0) {
            ebean.setStatus(0);
        }
        return ebean;
    }
    public static List<ExperStatusBean>  buildList(List<Experiment>list){
        List<ExperStatusBean>elist=new ArrayList<ExperStatusBean>();
        Iterator<Experiment>it=list.iterator();
        while (it.hasNext()){
            Experiment experiment=it.next();
            int number=exDao.countByExperId(experiment.getId());
            if(number!=0){
                elist.add(build(experiment));
            }
        }
        return elist;
    }

    public Long getExperId() {
        return experId;
    }

    public void setExperId(Long experId) {
        this.experId = experId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
