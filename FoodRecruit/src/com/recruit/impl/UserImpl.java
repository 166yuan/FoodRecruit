package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.dao.UserDao;
import com.recruit.model.User;
import org.hibernate.Query;

import java.util.List;

public class UserImpl extends DaoSupportImpl<User> implements UserDao{

   private static UserImpl instance=null;

   public static  UserImpl getInstance(){
       if(instance==null){
        return new UserImpl();
       }
       return instance;
   }

    @Override
    public User forAccount(String account) {
        List<User> list=this.findByProperty("account",account);
        return list.get(0);
    }

    @Override
    public User create(String account, String password) {
    User user=new User();
    user.setAddress(account);
    user.setPassword(password);
    user.setStatus(-2);
    user.setIsActive(false);
    user.setGender(-1);
    return user;
    }
}
