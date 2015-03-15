package com.recruit.controller;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Mklaus on 15/2/1.
 */
@Controller
@RequestMapping("/experUser")
public class ExperUserController{
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
    public void join(String experId,HttpServletRequest request,PrintWriter out){
        UserDao userDao = UserDao.getInstance();
        ExperUserDao euDao = ExperUserDao.getInstance();
        ExperimentDao eDao = ExperimentDao.getInstance();
        NotificationDao nDao  = NotificationDao.getInstance();

        int result = 0;
        try {
            Long EID = Long.parseLong(experId);
            String account = (String)request.getSession().getAttribute("account");
            euDao.begin();
            Long userId = userDao.forAccount(account).getId();

            if(euDao.forExperIdAndUserId(EID,userId)!=null){
                result=-2;
            }else{

            //-----创建Experiment 与 助手 联系 (Score要在同意后才新建一个）
            ExperUser eu = euDao.createExperUser();
            eu.setExperId(EID);
            eu.setUserId(userId);
            euDao.commit();
            //-----创建通知notification

                //获取实验发布者的ID
            Experiment experiment = eDao.get(EID);
            Long publisherId = experiment.getPublishId();

            nDao.begin();
            Notification noti = nDao.Create();
            noti.setReceiverId(publisherId);
            noti.setType(0);
            noti.setInfo("你有一个新的助手申请");
            nDao.commit();
            result = 1;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            euDao.close();
            nDao.close();
        }
        out.print(result);
    }

}
