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

    /**
     * 设置指定的通知为已读
     * @param notiId
     * @param out
     */
    @RequestMapping("readed")
    public void setReaded(HttpServletRequest req, Long notiId,PrintWriter out){
        NotificationDao notificationDao = NotificationDao.getInstance();
        Long uid = (Long)req.getSession().getAttribute("userId");
        int result = 0;
        try {
            notificationDao.begin();

            Notification noti = notificationDao.get(notiId);

            noti.setIsNew(false);

            notificationDao.update(noti);

            result = notificationDao.getUnreadNotificationByUserId(uid).size();

            notificationDao.commit();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            notificationDao.close();
        }
        out.print(result);
    }

    /**
     * 得到个人所有未读通知
     * @param req
     * @param model
     * @return
     */
    @RequestMapping("myNotification")
    public String myNotification(HttpServletRequest req,Model model){
        NotificationDao notificationDao = NotificationDao.getInstance();
        Long uid = (Long)req.getSession().getAttribute("userId");
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

    /**
     * 判断个人是否有新的通知 并返回新通知个数 用于/common/header.jsp
     * @param req
     * @param out
     */
    @RequestMapping("getNew")
    public void haveNewNotification(HttpServletRequest req,PrintWriter out){
        NotificationDao notificationDao = NotificationDao.getInstance();
        Long uid = (Long)req.getSession().getAttribute("userId");

        int result = 0;
        try {
            notificationDao.begin();

            List<Notification> list = notificationDao.getUnreadNotificationByUserId(uid);

            result = list.size();

            notificationDao.commit();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            notificationDao.close();
        }

        out.print(result);
    }

    /**
     * 返回个人的所有通知
     * @param req
     * @param model
     * @return
     */
    @RequestMapping("allNotification")
    public String allNotification(HttpServletRequest req,Model model){
        NotificationDao notificationDao = NotificationDao.getInstance();
        Long uid = (Long)req.getSession().getAttribute("userId");
        try {
            notificationDao.begin();

            int unreadSize = notificationDao.getUnreadNotificationByUserId(uid).size();

            List<Notification> list = notificationDao.getAllNotificationByUserId(uid);

            notificationDao.commit();

            model.addAttribute("list",list);
            model.addAttribute("unreadSize",unreadSize);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            notificationDao.close();
        }

        return "View/notification/allNotification";
    }

}
