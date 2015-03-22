package com.recruit.controller;

import com.recruit.base.BaseController;
import com.recruit.model.Notification;
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
public class NotificationController extends BaseController {
    private static final int SUCCESS = 1;
    private static final int FAILURE = -1;

    @RequestMapping("")
    public void m(PrintWriter out){
        int result = 0;
        out.print(result);
    }

    /**
     * 设置指定的通知为已读
     * @param notiId
     * @param out
     */
    @RequestMapping("readed")
    public void setReaded(HttpServletRequest req, Integer notiId,PrintWriter out){
        Integer uid = (Integer)req.getSession().getAttribute("userId");
        int result = 0;
        try {
            Notification noti = notificationDao.getById(notiId);
            noti.setIsNew(false);
            notificationDao.update(noti);
            result = notificationDao.getUnreadNotificationByUserId(uid).size();
        }catch (Exception ex){
            ex.printStackTrace();
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
        Integer uid = (Integer)req.getSession().getAttribute("userId");
        try {
            List<Notification> list = notificationDao.getUnreadNotificationByUserId(uid);
            model.addAttribute("list",list);
        }catch (Exception ex){
            ex.printStackTrace();
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
        Integer uid = (Integer)req.getSession().getAttribute("userId");
        int result = 0;
        try {
            List<Notification> list = notificationDao.getUnreadNotificationByUserId(uid);
            result = list.size();
        }catch (Exception ex){
            ex.printStackTrace();
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
        Integer uid = (Integer)req.getSession().getAttribute("userId");
        try {
            int unreadSize = notificationDao.getUnreadNotificationByUserId(uid).size();
            List<Notification> list = notificationDao.getAllNotificationByUserId(uid);
            model.addAttribute("list",list);
            model.addAttribute("unreadSize",unreadSize);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "View/notification/allNotification";
    }

}
