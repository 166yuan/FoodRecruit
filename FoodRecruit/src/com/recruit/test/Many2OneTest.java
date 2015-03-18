package com.recruit.test;

import static org.junit.Assert.*;

import java.util.*;


import com.recruit.base.PageBean;
import com.recruit.bean.ExperScoreBean;
import com.recruit.impl.ExperUserImpl;
import com.recruit.impl.TeamImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.recruit.impl.ExperimentImpl;
import com.recruit.impl.UserImpl;
import com.recruit.model.Classes;
import com.recruit.model.CompetAndTeam;
import com.recruit.model.Competition;
import com.recruit.model.ExperUser;
import com.recruit.model.Experiment;
import com.recruit.model.Major;
import com.recruit.model.Notification;
import com.recruit.model.PublishLog;
import com.recruit.model.Score;
import com.recruit.model.Team;
import com.recruit.model.User;
import com.recruit.util.HibernateUtils;

public class Many2OneTest {

	//private SessionFactory sessionFactory;
	//private Session session;
	//private Transaction transaction;
	
	@Test
	public void test() {
		
		
		ExperimentImpl experimentImpl = new ExperimentImpl();
		 experimentImpl.startTransaction();
		 

			User user = new User();
			user.setId(1);
			
			Experiment experiment = new Experiment();
			experiment.setPublisher(user);
			
			List<Experiment> list = experimentImpl.findByProperties(experiment,1,10);
		
		for(Experiment exp:list){
			System.out.println(exp.getId());
		}
		experimentImpl.commitTransaction();
		//List<User> list = userImpl.findByTime("2015-03-13 23:58:57", "2015-03-14 13:59:47");
		//List<User> list = userImpl.findByPage(2, 3);
		//List<User> list = userImpl.findByProperty("gender", 0);
		//List<User> list = userImpl.findByPage(1, 4, "createTime", true);
		
		
		
		/*
		Map<String, Object> map = new HashMap<>();
		map.put("type", 2);
		map.put("gender", 0);
		map.put("password", "123456");
		
		List<User> list = userImpl.findByProperties(map, 1, 5);
		
		for(User user1:list){
			System.out.println(user1.getId());
		}
		
		userImpl.commitTransaction();
		
		*/
		
	

		
	}

    @Test
	public void testgetUser(){
        TeamImpl tml=TeamImpl.getInstance();
        tml.startTransaction();
        List<Team>list=tml.findByComId(1);
        tml.commitTransaction();
        list.get(0);
    }

    @Test
    public void testPageBean(){
        ExperimentImpl eml=ExperimentImpl.getInstance();
        eml.startTransaction();
       /* if ("asc".equals(order))
            dc.addOrder(Order.asc(by));
        if ("desc".equals(order))
            dc.addOrder(Order.desc(by));
*/
        int total=eml.countNeedAssistant();
        PageBean pageBean=PageBean.getInstance(1,total,"/exper","/nendAssistant");
        List<Experiment> list = eml.getNeedAssistant(pageBean);
        eml.commitTransaction();

    }
    @Test
	public void insertData(){
		
		Competition  competition = new Competition("http:www.baidu.com", "http:www.baidu.com", 
				"竞赛名字", "这里是竞赛说明", 30, 
				50, new Date(), new Date()).inite();
		
		
		Major major = new Major("计算机科学与技术", 2012).inite();
		Classes classes = new Classes("计机班", major).inite();
		User user = new User("帐号名", "123456", 1, 1, "牵手无奈",
				"http:www.baidu.com", true, major, classes, 
				"13265137743", "123456@qq.com", "835781618", 
				"广东省湛江", "自我介绍，我是好人",true).inite();
		Team team = new Team("队名", 5, "口号", user, "123456", competition, 1).inite();
		CompetAndTeam competAndTeam = new CompetAndTeam(user, team).inite();
		Experiment experiment = new Experiment("实验名字", "实验介绍", "要求", "类型",
				"张志斌", "123456", "123456@qq.com", "123456", 100, user, 
				"提示note", new Date(), new Date(), true, true).inite();
		Score score = new Score(experiment, user, user, 10, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1,1.0).inite();
		ExperUser experUser = new ExperUser(experiment, user, score, true, true, true).inite();
		PublishLog publishLog = new PublishLog(1, "记录行为").inite();
		Notification notification = new Notification(user, user, "事件提醒", 1, true, 2000).inite();
		
		
		UserImpl userImpl = new UserImpl();
		userImpl.startTransaction();
		
		Session session = userImpl.getSession();
		
		session.save(competition);
		//session.save(basicModel);
		session.save(major);
		session.save(classes);
		session.save(user);
		session.save(team);
		session.save(competAndTeam);
		session.save(experiment);
		session.save(score);
		session.save(experUser);
		session.save(publishLog);
		session.save(notification);
		
		userImpl.commitTransaction();
		
	}
	
	
	//@Before
	public void init(){
		System.out.println("init");
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
		.applySettings(configuration.getProperties()).buildServiceRegistry();
		//sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		//session=sessionFactory.openSession();
		//transaction=session.beginTransaction();
	}
	//@After
	public void after(){
		System.out.println("after");
		//transaction.commit();
		//session.close();
		//sessionFactory.close();
	}

}
