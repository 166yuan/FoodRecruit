package com.recruit.user.Dao;


/**
 * Created by Mklaus on 15/1/27.
 */
public class Authorizer {
    private UserDao userDao;

    public Authorizer() {
        this.userDao = UserDao.getInstance();
    }

    //SINGLETON
    private static class Singleton{
        public static final Authorizer INSTANCE = new Authorizer();
    }
    public static Authorizer getInstance(){
        return Singleton.INSTANCE;
    }


}
