package com.recruit.impl;

import com.recruit.base.DaoSupportImpl;
import com.recruit.bean.PageBean;
import com.recruit.dao.UserDao;
import com.recruit.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class UserImpl extends DaoSupportImpl<User> implements UserDao{
    @Override
    public User forAccount(String account) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("account",account);
        List<User> list=this.findByProperties(map, 1, 10);
        if (list.size()!=0)return list.get(0);
        else return null;
    }

    @Override
    public User create(String account, String password) {
    User user=new User();
    user.setAccount(account);
    user.setPassword(password);
    user.setStatus(-1);
    user.setType(1);
    user.setIsActive(false);
    user.setGender(null);
    user.setImage_url("/images/example.jpg");
    return user;
    }

    public List<User>findAll(PageBean pageBean){
        String hql="from User u";
        return this.findByHql(hql,pageBean.getCurPage(),pageBean.getPerPage());
    }



}
