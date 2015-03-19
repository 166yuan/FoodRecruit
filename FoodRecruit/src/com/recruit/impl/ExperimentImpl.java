package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.base.PageBean;
import com.recruit.bean.ExperScoreBean;
import com.recruit.dao.ExperimentDao;
import com.recruit.model.ExperUser;
import com.recruit.model.Experiment;
import com.recruit.model.User;

import java.util.*;

public class ExperimentImpl extends DaoSupportImpl<Experiment> implements ExperimentDao {

    private static ExperimentImpl instance=null;

    public static  ExperimentImpl getInstance(){
        if(instance==null){
            instance= new ExperimentImpl();
        }
        return instance;
    }

    @Override
    public List<Experiment> getAllByUser(Integer userId,int page) {
        String hql="from Experiment t where t.publisher.id="+userId;
        return this.findByHql(hql,page,10);
    }

   public List<Experiment> getNeedAssistant(PageBean pageBean){
       Map<String,Object>map=new HashMap<String, Object>();
       map.put("isOk",false);
       return this.findByProperties(map,pageBean.getCurPage(),pageBean.getPerPage());
   }

    public List<Experiment>getMyPublishExper(Integer userId,PageBean pageBean){
        Map<String,Object>map=new HashMap<String, Object>();
        //这里的变量名publisher一定要和model类里一致
        map.put("publisher",userId);
        return this.findByProperties(map,pageBean.getCurPage(),pageBean.getPerPage());
    }

    public Integer countByPublisher(Integer pid){
        String hql="from Experiment e where e.publisher="+pid;
        return this.getSize(hql);
    }

    public Integer countNeedAssistant(){
        Map<String,Object>map=new HashMap<String, Object>();
        map.put("isOk",false);
        return this.getFindByPropertiesSize(map);
    }

    public List<ExperScoreBean> buildList(List<Experiment>elist){
        List<ExperScoreBean> list=new ArrayList<ExperScoreBean>();
        Iterator<Experiment>iterator=elist.iterator();
        while (iterator.hasNext()){
          ExperScoreBean esBean=  ExperScoreBean.build(iterator.next());
            list.add(esBean);
        }
        return list;
    }
}
