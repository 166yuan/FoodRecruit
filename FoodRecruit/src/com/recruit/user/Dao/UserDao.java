package com.recruit.user.Dao;

import com.recruit.BaseDao.DaoBase;
import com.recruit.user.model.User;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Mklaus on 15/1/25.
 */
public class UserDao extends DaoBase<User>{
    public UserDao(){}

    public Class classOfT(){
        return (User.class);
    }

    private static class Singleton{
        public static final UserDao INSTANCE = new UserDao();
    }

    public static UserDao getInstance(){
        return Singleton.INSTANCE;
    }

    public User forAccount(String account)
    {
        DetachedCriteria dc = DetachedCriteria.forClass(User.class)
                .add(Restrictions.eq("account", account));

        return(
                this.get(dc)
        );
    }

    public User getUserById(Long id){
        DetachedCriteria dc = DetachedCriteria.forClass(User.class)
                .add(Restrictions.eq("id", id));

        return(
                this.get(dc)
        );
    }

    public User create(String account,String password){
        User user = new User(account,password);
        user.setImage_url("/images/example.jpg");
        user.setType(1);
        user.setStatus(-1);
        this.save(user);

        return user;
    }

    public List<User>  getAllUser(){
        Query query=this.createQuery("from User u");
        List<User>list=query.list();
        return list;
    }


}
