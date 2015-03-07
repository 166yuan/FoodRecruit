package com.recruit.notification.controller;

import com.recruit.Model.BasicModel;
import com.recruit.notification.dao.NotificationDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.PrintWriter;

/**
 * Created by Mklaus on 15/2/1.
 */
@Controller
@RequestMapping("/notification")
public class NotificationController extends BasicModel {
    @RequestMapping("")
    public void m(PrintWriter out){
        NotificationDao notificationDao = NotificationDao.getInstance();
        int result = 0;
        try {
            notificationDao.begin();

            notificationDao.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            notificationDao.close();
        }
        out.print(result);
    }
}
