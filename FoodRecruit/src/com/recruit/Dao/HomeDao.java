package com.recruit.Dao;

import com.recruit.Model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2014/11/23.
 */
public class HomeDao {
    static Configuration config;
    static SessionFactory factory;
    static Session session;
    static Transaction tx;
    static Query query;
    public static void addUser(String account,String password){
        User user=new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setType(0);
        user.setName("test");
        user.setCreateTime(new Date());
        openSession();
        session.save(user);
        tx.commit();
        closeSession();
    }

    public static int findUser(String account,String password){
        openSession();
        Query query = session.createQuery("from User u where u.account=? and u.password=?");
        query.setParameter(0, account);
        query.setParameter(1, password);
        List<User>list=query.list();
        closeSession();
        return list.size();
    }

    public static void  openSession(){
        config=new Configuration().configure();
        factory=config.buildSessionFactory();
        session=factory.openSession();
        tx=session.beginTransaction();
    }
    public  static void closeSession(){
        session.close();
        factory.close();
    }
}
