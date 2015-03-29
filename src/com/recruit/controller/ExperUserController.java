package com.recruit.controller;

import com.recruit.base.BaseController;
import com.recruit.base.PageBean;
import com.recruit.impl.ExperUserImpl;
import com.recruit.impl.ExperimentImpl;
import com.recruit.impl.NotificationImpl;
import com.recruit.impl.UserImpl;
import com.recruit.model.ExperUser;
import com.recruit.model.Experiment;
import com.recruit.model.Notification;
import com.recruit.model.User;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Mklaus on 15/2/1.
 */
@Controller
@RequestMapping("/experUser")
public class ExperUserController extends BaseController {
    private static final int SUCCESS = 1;
    private static final int FAILURE = -1;

    //从request中获取json数据
    public JSONObject createJson(HttpServletRequest request) throws IOException {
        StringBuffer sb = new StringBuffer();
        String line = null;
        BufferedReader br = request.getReader();

        while ((line = br.readLine()) != null){
            sb.append(line);
        }

        JSONObject j = JSONObject.fromObject(sb.toString());
        return j;
    }



    @RequestMapping("join")
    public void join(Integer experId,HttpServletRequest request,PrintWriter out){
        Integer userId=(Integer)request.getSession().getAttribute("userId");
        User user=userDao.getById(userId);
        Experiment experiment=experimentDao.getById(experId);
        int result = 0;
        try {
            if(experUserDao.findByExperAndUserId(experId,userId)!=null){
                result=-2;
            }else{

            //-----创建Experiment 与 助手 联系 (Score要在同意后才新建一个）
            ExperUser experUser=experUserDao.create(user,experiment);
            experUserDao.save(experUser);
            //-----创建通知notification

                //获取实验发布者的ID
            User publisher=experiment.getPublisher();
            Notification noti = new Notification();
            noti.setReceiver(publisher);
            noti.setType(0);
            noti.setRefId(experId);
            noti.setInfo("你有一个新的助手申请");
            notificationDao.save(noti);
            result = 1;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        out.print(result);
    }

    @RequestMapping("myattendExper")
    public String myAttendExper(HttpSession session,int page,Model model){
        if (page==0){
            page=1;
        }
        Integer uid=(Integer)session.getAttribute("userId");
        int total=experUserDao.countMyAttendExper(uid);
        PageBean pageBean=PageBean.getInstance(page,total,"/experUser","/myattendExper");
        List<ExperUser> list=experUserDao.getByUser(uid,pageBean);
        model.addAttribute("list",list);
        model.addAttribute("pageBean",pageBean);
        return "View/experiment/myAttendExper";
    }

    @RequestMapping("acceptUser")
    public void acceptUser(Integer euid,PrintWriter out){
        int result=1;
        ExperUser experUser=experUserDao.getById(euid);
        if (experUser!=null){
            experUser.setIsAgree(true);
            experUserDao.update(experUser);
        }else {
            result=-1;
        }
    out.print(result);
    }

    @RequestMapping("cancelUser")
    public void cancelUser(Integer euid,PrintWriter out){
        int result=1;
        ExperUser experUser=experUserDao.getById(euid);
        if (experUser!=null){
            experUser.setIsAgree(false);
            experUserDao.update(experUser);
        }else {
            result=-1;
        }
        out.print(result);
    }

    @RequestMapping("sentNoti")
    public void sentNoti(Integer euid,PrintWriter out){
        int result = 1;

        System.out.println("In 1");

        ExperUser experUser = experUserDao.getById(euid);

        if (experUser != null){
            System.out.println("Infasf");

            if (experUser.getIsAgree()){
                User receiver = experUser.getUser();
                Notification noti = new Notification();
                noti.setReceiver(receiver);
                noti.setType(1);
                noti.setRefId(experUser.getExperiment().getId());
                noti.setInfo("你已经被招收为 " + experUser.getExperiment().getName() + " 的实验助手。");
                notificationDao.save(noti);

            }else {
                User receiver = experUser.getUser();
                Notification noti = new Notification();
                noti.setReceiver(receiver);
                noti.setType(2);
                noti.setRefId(experUser.getExperiment().getId());
                noti.setInfo("你未能通过成为 " + experUser.getExperiment().getName() + " 的实验助手。");
                notificationDao.save(noti);
            }
        }else {
            result = -1;
        }

        out.print(result);
    }

}
