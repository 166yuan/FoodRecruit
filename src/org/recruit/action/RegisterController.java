package org.recruit.action;

import org.recruit.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RegisterController {
	static Configuration config;
	static SessionFactory factory;
	static Session session;
	static Transaction tx;
	
	@SuppressWarnings("deprecation")
	public static void addUser(String account,String password){
		User user=new User(account, password);
		config=new Configuration().configure();
		factory=config.buildSessionFactory();
		session=factory.openSession();
		tx=session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		factory.close();
	}
	
}
