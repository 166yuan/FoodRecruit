package com.recruit.bean;

import com.recruit.model.ExperUser;
import com.recruit.model.Experiment;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/3/16.
 */
public class ExperScoreBean {
    String experName;
    Integer experId;
    int status;
    Date beginTime;

    public static ExperScoreBean build(Experiment experiment){
        List<ExperUser>list=experiment.getExperUser();
        System.out.println(list.size());
        if (list.size()==0)return null;
        ExperScoreBean esBean=new ExperScoreBean();
        esBean.setBeginTime(experiment.getBeginTime());
        esBean.setExperName(experiment.getName());
        esBean.setExperId(experiment.getId());
        int status=0;
        for(int i=0;i<list.size();i++)
        {
            if(list.get(0).getIsEvaluate()==true){
                status++;
            }
        }
        if(status==list.size()){
            esBean.setStatus(1);
        }else if (status>0&&status<list.size()){
            esBean.setStatus(-1);
        }else {
            esBean.setStatus(0);
        }
        return esBean;
    }
    public String getExperName() {
        return experName;
    }

    public void setExperName(String experName) {
        this.experName = experName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getExperId() {
        return experId;
    }

    public void setExperId(Integer experId) {
        this.experId = experId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }
}
