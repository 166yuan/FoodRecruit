package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.dao.PublishLogDao;
import com.recruit.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class PublishLogImpl extends DaoSupportImpl<PublishLog> implements PublishLogDao {
    /**
     * 记录用户发布实验事件
     * @param user
     */
    public void addExper(User user,Experiment experiment){
        PublishLog publishLog=new PublishLog();
        publishLog.setType(0);
        publishLog.setInfo("账号:<a href='/mana/showuserbyid?id="+user.getId()+"'>"+user.getAccount()+"</a> 发布了实验:<a href='/exper/showExper?id="+experiment.getId()+"'>"+experiment.getName()+"</a>");
        this.save(publishLog);
    }

    public void updateExper(User user,Experiment experiment){
        PublishLog publishLog=new PublishLog();
        publishLog.setType(0);
        publishLog.setInfo("账号:<a href='/mana/showuserbyid?id="+user.getId()+"'>"+user.getAccount()+"</a>更新了实验:<a href='/exper/showExper?id="+experiment.getId()+"'>"+experiment.getName()+"</a>");
        this.save(publishLog);
    }

    public void deleteExper(User user,Experiment experiment){
        PublishLog publishLog=new PublishLog();
        publishLog.setType(0);
        publishLog.setInfo("账号:<a href='/mana/showuserbyid?id="+user.getId()+"'>"+user.getAccount()+"</a>删除了实验:<a href='/exper/showExper?id="+experiment.getId()+"'>"+experiment.getName()+"</a>");
        this.save(publishLog);
    }

    public void addUser(User user){
        PublishLog publishLog=new PublishLog();
        publishLog.setType(2);
        publishLog.setInfo("新增用户：<a href='/mana/showuserbyid?id="+user.getId()+ "'>"+user.getAccount()+"</a>");
        this.save(publishLog);
    }

    public void addUser(User operator,User user){
        PublishLog publishLog=new PublishLog();
        publishLog.setType(2);
        publishLog.setInfo("超级管理员:<a href='/mana/showuserbyid?id="+operator.getId()+"'>"+operator.getAccount()+"</a>"+"新增用户：<a href='/mana/showuserbyid?id="+user.getId()+ "'>"+user.getAccount()+"</a>");
        this.save(publishLog);
    }

    public void updateUser(User user){
        PublishLog publishLog=new PublishLog();
        publishLog.setType(2);
        publishLog.setInfo("用户：<a href='/mana/showuserbyid?id="+user.getId()+ "'>"+user.getAccount()+"</a>修改了自己资料");
        this.save(publishLog);
    }

    public void updateUser(User operator,User user){
        PublishLog publishLog=new PublishLog();
        publishLog.setType(2);
        publishLog.setInfo("超级管理员:<a href='/mana/showuserbyid?id="+operator.getId()+"'>"+operator.getAccount()+"</a>"+"修改了用户：<a href='/mana/showuserbyid?id="+user.getId()+ "'>"+user.getAccount()+"</a>资料");
        this.save(publishLog);
    }

    public void deleteUser(User operator,User user){
        PublishLog publishLog=new PublishLog();
        publishLog.setType(2);
        publishLog.setInfo("超级管理员:<a href='/mana/showuserbyid?id="+operator.getId()+"'>"+operator.getAccount()+"</a>"+"删除了用户：<a href='/mana/showuserbyid?id="+user.getId()+ "'>"+user.getAccount()+"</a>");
        this.save(publishLog);
    }

    public void publicCompetition(User user,Competition competition){
        PublishLog publishLog=new PublishLog();
        publishLog.setType(1);
        publishLog.setInfo("账号:<a href='/mana/showuserbyid?id="+user.getId()+"'>"+user.getAccount()+"</a> 发布了竞赛:<a href='/compet/getById?id="+competition.getId()+"'>"+competition.getName()+"</a>");
        this.save(publishLog);
    }

    public void updateCompetition(User user,Competition competition){
        PublishLog publishLog=new PublishLog();
        publishLog.setType(1);
        publishLog.setInfo("账号:<a href='/mana/showuserbyid?id="+user.getId()+"'>"+user.getAccount()+"</a> 更新了竞赛:<a href='/compet/getById?id="+competition.getId()+"'>"+competition.getName()+"</a>");
        this.save(publishLog);
    }

    public void deleteCompetition(User user,Competition competition){
        PublishLog publishLog=new PublishLog();
        publishLog.setType(1);
        publishLog.setInfo("账号:<a href='/mana/showuserbyid?id="+user.getId()+"'>"+user.getAccount()+"</a> 删除了竞赛:<a href='/compet/getById?id="+competition.getId()+"'>"+competition.getName()+"</a>");
        this.save(publishLog);
    }

    public void addMajor(User user,Major major){
        PublishLog publishLog=new PublishLog();
        publishLog.setType(3);
        publishLog.setInfo("超级管理员:<a href='/mana/showuserbyid?id="+user.getId()+"'>"+user.getAccount()+"</a>"+"新增专业:"+major.getMajorName());
        this.save(publishLog);
    }

    public void deleteMajor(User user,Major major){
        PublishLog publishLog=new PublishLog();
        publishLog.setType(3);
        publishLog.setInfo("超级管理员:<a href='/mana/showuserbyid?id="+user.getId()+"'>"+user.getAccount()+"</a>"+"删除专业:"+major.getMajorName());
        this.save(publishLog);
    }

    public void addClasses(User user,Classes classes){
        PublishLog publishLog=new PublishLog();
        publishLog.setType(3);
        publishLog.setInfo("超级管理员:<a href='/mana/showuserbyid?id="+user.getId()+"'>"+user.getAccount()+"</a>"+"新增班级:"+classes.getClassName());
        this.save(publishLog);
    }

    public void deleteClasses(User user,Classes classes){
        PublishLog publishLog=new PublishLog();
        publishLog.setType(3);
        publishLog.setInfo("超级管理员:<a href='/mana/showuserbyid?id="+user.getId()+"'>"+user.getAccount()+"</a>"+"删除班级:"+classes.getClassName());
        this.save(publishLog);
    }


}
