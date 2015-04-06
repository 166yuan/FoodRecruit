package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.base.PageBean;
import com.recruit.dao.ExperUserDao;
import com.recruit.model.ExperUser;
import com.recruit.model.Experiment;
import com.recruit.model.Score;
import com.recruit.model.User;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ExperUserImpl extends DaoSupportImpl<ExperUser> implements ExperUserDao {
    public ExperUser findByExperAndUserId(Integer experId,Integer userId){
        String hql="from ExperUser eu where eu.experiment.id="+experId+" and eu.user.id="+userId;
        List<ExperUser> list=this.findByHql(hql,0,10);
        if (list.size()==0)
            return null;
        else {
            return list.get(0);
        }

    }

    public List<ExperUser>findByExper(Integer experId){
        String hql="from ExperUser eu where eu.experiment.id="+experId;
        return this.findByHql(hql,1,10);
    }

    public ExperUser create(User user,Experiment experiment){
        ExperUser experUser=new ExperUser();
        experUser.setExperiment(experiment);
        experUser.setUser(user);
        return experUser;
    }

    public List<ExperUser>getByExperiment(Integer experId){
        Map<String,Object>map=new HashMap<String, Object>();
        map.put("experiment", experId);
        return this.findByProperties(map,1,10);
    }
    public List<ExperUser>getByUser(Integer userId,PageBean pageBean){
        Map<String,Object>map=new HashMap<String, Object>();
        map.put("user",userId);
        return this.findByProperties(map,pageBean.getCurPage(),pageBean.getPerPage());
    }

    public Integer countMyAttendExper(Integer uid){
        String hql="from ExperUser eu where eu.user="+uid;
        return this.getSize(hql);
    }

    public List<ExperUser>getByPublish(Integer userId){
        String hql="from ExperUser eu where eu.experiment.publisher="+userId;
        return this.findByHql(hql,1,10);
    }

}
