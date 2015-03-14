package com.recruit.dao;

import com.recruit.base.DaoSupport;
import com.recruit.model.User;

public interface UserDao extends DaoSupport<User>{

    public User forAccount(String account);

    public User create(String account,String password);
}
