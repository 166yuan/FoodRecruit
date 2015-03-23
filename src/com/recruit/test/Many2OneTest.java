package com.recruit.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.Date;


import com.recruit.base.BaseController;
import com.recruit.bean.PageBean;
import com.recruit.dao.MajorDao;
import com.recruit.impl.MajorImpl;
import com.recruit.impl.TeamImpl;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
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
import sun.net.www.http.HttpClient;

public class Many2OneTest extends BaseController{
    BufferedReader in = null;

    String content = null;
    @Test
    public void zhuabao() throws MalformedURLException {
        URL ur=new URL("http://www.xxzs.org/school_view2.asp?id=1");

    }

	//private SessionFactory sessionFactory;
	//private Session session;
	//private Transaction transaction;
	@Test
    public void testMajor(){
        Map<String,Object>map=new HashMap<String, Object>();
        map.put("majorName","软件工程");
        map.put("year",2012);
        if(majorDao==null){
            System.out.println("null");
        }

    }

	@Test
	public void test() {
		
		
		ExperimentImpl experimentImpl = new ExperimentImpl();

		 

			User user = new User();
			user.setId(1);
			
			Experiment experiment = new Experiment();
			experiment.setPublisher(user);
			
			List<Experiment> list = experimentImpl.findByProperties(experiment,1,10);
		
		for(Experiment exp:list){
			System.out.println(exp.getId());
		}

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
   public void testHql(){
       String hql="from CompetAndTeam cat where cat.user.id=2";
       TeamImpl tml=new TeamImpl();

       Query query=tml.createQuery(hql);
       List<CompetAndTeam>list=query.list();
       Iterator<CompetAndTeam>iterator=list.iterator();
       while (iterator.hasNext()){
           System.out.println(iterator.next().getId());
       }

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
