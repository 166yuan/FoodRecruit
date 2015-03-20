package com.recruit.dao;

import com.recruit.base.DaoSupport;
import com.recruit.bean.PageBean;
import com.recruit.model.User;

import java.util.List;

public interface UserDao extends DaoSupport<User>{

    public User forAccount(String account);

    public User create(String account,String password);

    public List<User> findAll(PageBean pageBean);

}
