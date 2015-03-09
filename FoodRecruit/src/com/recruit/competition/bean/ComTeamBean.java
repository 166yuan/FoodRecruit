package com.recruit.competition.bean;

import com.recruit.competition.dao.ComDao;
import com.recruit.competition.model.CompetAndTeam;
import com.recruit.competition.model.Competition;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2015/3/2.
 */
public class ComTeamBean {
    private String competName;
    private Long competId;
    private Long teamId;
    private Date beginTime;
    private Date endTime;
    private static Date now=new Date();
    private static ComDao comDao=ComDao.getInstance();

    /**
     * 构建单个对象
     * @param competAndTeam
     * @return
     */
    public static ComTeamBean build(CompetAndTeam competAndTeam){
    ComTeamBean comTeamBean=new ComTeamBean();
    Long comId=competAndTeam.getCompet_id();
        comTeamBean.setCompetId(comId);
        Competition competition=comDao.getById(comId);
        comTeamBean.setCompetName(competition.getName());
        comTeamBean.setBeginTime(competition.getBeginTime());
        comTeamBean.setEndTime(competition.getEndTime());
        comTeamBean.setTeamId(competAndTeam.getTeam_id());
        return comTeamBean;
    }

    /**
     * 把CompetAndTeam 列表构建成ComTeamBean列表
     * @param list ComTeamBean列表
     * @return ComTeamBean列表
     */
    public static List<ComTeamBean> buildList1(List<CompetAndTeam>list){
        List<ComTeamBean>list1=new ArrayList<ComTeamBean>();
        Iterator<CompetAndTeam>iterator=list.iterator();
        while (iterator.hasNext()){
            CompetAndTeam competAndTeam=iterator.next();
           Competition competition= comDao.getById(competAndTeam.getCompet_id());
           Date date= competition.getEndTime();
            if(date.before(now)){
                list1.add(build(competAndTeam));
            }
        }
        return list1;
    }

    public static List<ComTeamBean> buildList2(List<CompetAndTeam>list){
        List<ComTeamBean>list1=new ArrayList<ComTeamBean>();
        Iterator<CompetAndTeam>iterator=list.iterator();
        while (iterator.hasNext()){
            CompetAndTeam competAndTeam=iterator.next();
            Competition competition= comDao.getById(competAndTeam.getCompet_id());
            Date date= competition.getEndTime();
            if(!date.before(now)){
                list1.add(build(competAndTeam));
            }
        }
        return list1;
    }

    public static List<ComTeamBean>buildList(List<CompetAndTeam>list){
        List<ComTeamBean>list1=new ArrayList<ComTeamBean>();
        Iterator<CompetAndTeam>iterator=list.iterator();
        while (iterator.hasNext()){
            list1.add(build(iterator.next()));
        }
        return list1;
    }

    public String getCompetName() {
        return competName;
    }

    public void setCompetName(String competName) {
        this.competName = competName;
    }

    public Long getCompetId() {
        return competId;
    }

    public void setCompetId(Long competId) {
        this.competId = competId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
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
}
