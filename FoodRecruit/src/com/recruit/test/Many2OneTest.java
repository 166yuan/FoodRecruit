package com.recruit.test;

import static org.junit.Assert.*;

import java.util.Date;








import java.util.List;

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

import com.recruit.impl.UserImpl;
import com.recruit.model.BasicModel;
import com.recruit.model.Classes;
import com.recruit.model.Major;
import com.recruit.model.User;
import com.recruit.util.HibernateUtils;

public class Many2OneTest {

	//private SessionFactory sessionFactory;
	//private Session session;
	//private Transaction transaction;
	
	@Test
	public void test() {
		
		
		UserImpl userImpl = new UserImpl();
		
		
		userImpl.startTransaction();
		
		
		
		
		
		BasicModel basicModel = new BasicModel(new Date(), new Date());
		
		//Major major = new Major("计算机科学与技术", 2012, basicModel);
		//Classes classes = new Classes("计机班", major, basicModel);
		User user = new User("帐号名", "123456", 1, 1, "牵手无奈",
				"http:www.baidu.com", 1, null, null, 
				"13265137743", "123456@qq.com", "835781618", 
				"广东省湛江", "自我介绍，我是好人",true, basicModel);
		
		userImpl.save(user);
		//List<User> list = userImpl.findByTime("2015-03-13 23:58:57", "2015-03-14 13:59:47");
		//List<User> list = userImpl.findByPage(2, 3);
		//List<User> list = userImpl.findByProperty("gender", 0);
//		for(User user:list){
//			System.out.println(user.getId());
//		}
		
		userImpl.commitTransaction();
		
		userImpl.startTransaction();
		
		User user2 = userImpl.getById(user.getId());
		System.out.println("id="+user2.getId());
		
		List<User> list = userImpl.findAll();
		for(User user1:list){
			System.out.println(user1.getId());
		}
		
		userImpl.commitTransaction();
		
		/*
		
		Competition  competition = new Competition("http:www.baidu.com", "http:www.baidu.com", 
				"竞赛名字", "这里是竞赛说明", 30, 
				50, new Date(), new Date());
		BasicModel basicModel = new BasicModel(new Date(), new Date());
		
		Major major = new Major("计算机科学与技术", 2012, basicModel);
		Classes classes = new Classes("计机班", major, basicModel);
		User user = new User("帐号名", "123456", 1, 1, "牵手无奈",
				"http:www.baidu.com", 1, major, classes, 
				"13265137743", "123456@qq.com", "835781618", 
				"广东省湛江", "自我介绍，我是好人",true, basicModel);
		Team team = new Team("队名", 5, "口号", user, "123456", competition, 1);
		CompetAndTeam competAndTeam = new CompetAndTeam(user, team);
		Experiment experiment = new Experiment("实验名字", "实验介绍", "要求", "类型",
				"张志斌", "123456", "123456@qq.com", "123456", 100, user, 
				"提示note", new Date(), new Date(), true, true);
		Score score = new Score(experiment, user, user, 10, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1,1.0);
		ExperUser experUser = new ExperUser(experiment, user, score, true, true, true, basicModel);
		PublishLog publishLog = new PublishLog(1, "记录行为");
		Notification notification = new Notification(user, user, "事件提醒", 1, true, 2000l);
		
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
		
		*/
		
		//CompetAndTeam competAndTeam = (CompetAndTeam)session.get(CompetAndTeam.class, 1);
		//System.out.println(competAndTeam.toString());
		
		
		
//		Father father = new Father("bin");
//		Child child1=new Child("child1", father);
//		Child child2=new Child("child1", father);
//		session.save(father);
//		session.save(child1);
//		session.save(child2);
//		Child child = (Child) session.get(Child.class, 1);
//		System.out.println(child.toString());
//		Father father = child.getFather();
//		System.out.println(father.toString());
//		Father father = (Father) session.get(Father.class, 1);
//		Iterator<Child> it =father.getChildren().iterator();
//		System.out.println("大小--"+father.getChildren().size());
//		while(it.hasNext()){
//			System.out.println(it.next().toString());
//		}
		
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
