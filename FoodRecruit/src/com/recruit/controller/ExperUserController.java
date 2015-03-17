package com.recruit.controller;

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
    public void join(Integer experId,HttpServletRequest request,PrintWriter out){
        Integer userId=(Integer)request.getSession().getAttribute("userId");
        ExperimentImpl eml=ExperimentImpl.getInstance();
        ExperUserImpl euml=ExperUserImpl.getInstance();
        UserImpl uml=UserImpl.getInstance();
        uml.startTransaction();
        User user=uml.getById(userId);
        uml.commitTransaction();
        eml.startTransaction();
        Experiment experiment=eml.getById(experId);
        eml.commitTransaction();
        int result = 0;
        try {
            euml.startTransaction();
            if(euml.findByExperAndUserId(experId,userId)!=null){
                result=-2;
            }else{

            //-----创建Experiment 与 助手 联系 (Score要在同意后才新建一个）
            ExperUser experUser=euml.create(user,experiment);
            euml.save(experUser);
            euml.commitTransaction();
            //-----创建通知notification

                //获取实验发布者的ID
            User publisher=experiment.getPublisher();
            NotificationImpl nml=NotificationImpl.getInstance();
            nml.startTransaction();
            Notification noti = new Notification();
            noti.setReceiver(publisher);
            noti.setType(0);
            noti.setInfo("你有一个新的助手申请");
            nml.save(noti);
            nml.commitTransaction();
            result = 1;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        out.print(result);
    }

}
