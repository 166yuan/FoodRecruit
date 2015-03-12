package com.recruit.notification.controller;

import com.recruit.Model.BasicModel;
import com.recruit.notification.dao.NotificationDao;
import com.recruit.notification.model.Notification;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Mklaus on 15/2/1.
 */
@Controller
@RequestMapping("/notification")
public class NotificationController extends BasicModel {
    private static final int SUCCESS = 1;
    private static final int FAILURE = -1;

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

    @RequestMapping("readed")
    public void setReaded(Long notificationId,PrintWriter out){
        NotificationDao notificationDao = NotificationDao.getInstance();
        int result = 0;
        try {
            notificationDao.begin();

            Notification noti = notificationDao.get(notificationId);

            noti.setIsNew(false);

            notificationDao.update(noti);

            notificationDao.commit();

            result = SUCCESS;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            notificationDao.close();
        }
        out.print(result);
    }

    @RequestMapping("myNotification")
    public String myNotification(HttpServletRequest req,Model model){
        NotificationDao notificationDao = NotificationDao.getInstance();
        Long uid = (Long)req.getSession().getAttribute("userId");
        System.out.println("In ");
        try {
            notificationDao.begin();

            List<Notification> list = notificationDao.getUnreadNotificationByUserId(uid);

            notificationDao.commit();

            model.addAttribute("list",list);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            notificationDao.close();
        }

        return "View/notification/unread";
    }

    @RequestMapping("allNotification")
    public String allNotification(HttpServletRequest req,Model model){
        NotificationDao notificationDao = NotificationDao.getInstance();
        Long uid = (Long)req.getSession().getAttribute("userId");
        System.out.println("In ");
        try {
            notificationDao.begin();

            List<Notification> list = notificationDao.getAllNotificationByUserId(uid);

            notificationDao.commit();

            model.addAttribute("list",list);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            notificationDao.close();
        }

        return "View/notification/allNotification";
    }

}
