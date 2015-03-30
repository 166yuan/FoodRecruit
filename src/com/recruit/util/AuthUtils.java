package com.recruit.util;

import com.recruit.model.User;

/**
 * Created by Administrator on 2015/3/30.
 */
public class AuthUtils {
    public static boolean isPermit(User user){
        boolean isallow=true;
        if (user.getName()==null)isallow=false;
        if (user.getClasses()==null)isallow=false;
        if (user.getMajor()==null)isallow=false;
        if (user.getPhone()==null)isallow=false;
        System.out.println("finish auth !");
        return isallow;
    }
}
