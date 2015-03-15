package com.recruit.controller;


import com.recruit.bean.ExperUserBean;
import com.recruit.impl.ExperUserImpl;
import com.recruit.impl.ExperimentImpl;

import com.recruit.impl.UserImpl;
import com.recruit.model.ExperUser;
import com.recruit.model.Experiment;
import com.recruit.model.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import net.sf.json.JSONObject;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Administrator on 2015/1/29.
 */
@Controller
@RequestMapping("/exper")
public class ExperController {

    //从request中提取出json数据
    public JSONObject createJson (HttpServletRequest request) throws IOException {
        StringBuffer sb = new StringBuffer();
        String line = null;
        BufferedReader br = request.getReader();
        while((line = br.readLine()) != null){
            sb.append(line);
        }

        JSONObject json = JSONObject.fromObject(sb.toString());
        return json;
    }

    /**
     * 跳转到实验发布页面
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "publish")
    public String publicExper(HttpSession session,Model model) {
        String account=(String)session.getAttribute("account");
        model.addAttribute("account", account);
        return "/View/experiment/experiment";
    }

    /**
     * 根据跟定的id 跳转到显示该实验信息的界面
     * @param id
     * @param from  利用from 在show_experiment页面中判断面包屑的显示
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "showExper")
    public String showExperById(Long id,String from,HttpSession session,Model model){
        ExperimentImpl eml=ExperimentImpl.getInstance();
        eml.startTransaction();
        Experiment experiment =eml.getById(id);
        model.addAttribute("exper", experiment);
        System.out.println("from " + from);
        model.addAttribute("from", from);
        eml.commitTransaction();
     return "/View/experiment/show_experiment";
    }

    /**
     * 返回我发布的所有实验
     * @param start 返回结果的起始数
     * @param size  返回结果的个数
     * @param order 升序(asc) | 降序（desc）
     * @param by    按该字段进行排序
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "myPublishExperiment")
    public  String myPublishExperiment(Integer start, Integer size, String order, String by, HttpSession session, Model model){
        ExperimentImpl eml =ExperimentImpl.getInstance();
        eml.startTransaction();
        Long userId = (Long)session.getAttribute("userId");

       /* if ("asc".equals(order))
            dc.addOrder(Order.asc(by));
        if ("desc".equals(order))
            dc.addOrder(Order.desc(by));*/

        start = start != null? start : 0;
        size  = size  != null? size  : 10;

        List<Experiment> list = eml.findByProperty("publishId",userId);
        eml.commitTransaction();
        model.addAttribute("list",list);
        return "View/experiment/myPublishExperiment";
    }

    /**
     * 返回所有需要招收实验助手的实验
     * @param start 返回结果的起始数
     * @param size  返回结果的个数
     * @param order 升序(asc) | 降序（desc）
     * @param by    按该字段进行排序
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("nendAssistant")
    public String needAssistant(Integer start, Integer size, String order, String by, HttpSession session, Model model){
       ExperimentImpl eml=ExperimentImpl.getInstance();
       /* if ("asc".equals(order))
            dc.addOrder(Order.asc(by));
        if ("desc".equals(order))
            dc.addOrder(Order.desc(by));
*/
        start = start != null? start : 0;
        size  = size  != null? size  : 8;

        List<Experiment> list = eml.findByProperty("isOk",false);
        eml.commitTransaction();
        model.addAttribute("list",list);
        return "View/experiment/experimentNeedAssistant";
    }

    /**
     * 创建添加实验
     * @param request
     * @param out
     */
    @RequestMapping(value = "/addExper")
    public void newExper(HttpServletRequest request,PrintWriter out){
        ExperimentImpl eml=ExperimentImpl.getInstance();
        UserImpl uml=UserImpl.getInstance();
        Integer experId = -1;
        try{
            JSONObject j = createJson(request);
            Long publisherId = (Long)request.getSession().getAttribute("userId");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy k:m a", Locale.US);
            eml.startTransaction();
            User user= uml.getById(publisherId);
            Experiment exper=new Experiment();
            exper.setPublisher(user);
            exper.setName(j.getString("name"));
            exper.setInformation(j.getString("content"));
            exper.setRequirement(j.getString("requirement"));
            exper.setBeginTime(sdf.parse(j.getString("pretime")));
            exper.setEndTime(sdf.parse(j.getString("endtime")));
            exper.setContact(j.getString("linkman"));
            exper.setType(j.getString("type"));
            exper.setQQ(j.getString("qq"));
            exper.setPhone(j.getString("phone"));
            exper.setEmail(j.getString("email"));
            exper.setNote(j.getString("note"));
            exper.setCount(j.getInt("count"));
            eml.save(exper);
            experId = exper.getId();
           eml.commitTransaction();
        }catch (Exception e){
            e.printStackTrace();
        }
        out.print(experId);
    }


    /**
     * 根据 id 删除 实验
     * @param id
     * @param out
     */
    @RequestMapping("delete")
    public void delete(Long id,PrintWriter out){
        int result = 0;
        ExperimentImpl eml=ExperimentImpl.getInstance();
        try{
            eml.startTransaction();
            eml.delete(id);
            result = 1;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        out.print(result);
    }



    @RequestMapping("attendList")
    public String attendList(Long experId,Model model){
        ExperimentImpl eml=ExperimentImpl.getInstance();
        ExperUserImpl euml=ExperUserImpl.getInstance();
        Experiment experiment=eml.getById(experId);
        List<ExperUser>list=euml.findByProperty("experiment",experiment);
        List<ExperUserBean>list1=ExperUserBean.buildList(list);
        model.addAttribute("list",list1);
        model.addAttribute("experName",experiment.getName());
        model.addAttribute("number",experiment.getCount());
        return "View/experiment/attendList";
    }

    @RequestMapping("employ")
    public void employ(Integer experId,Integer userId,boolean isAgree,PrintWriter out){
        int result=1;
        ExperUserImpl euml=ExperUserImpl.getInstance();
        try{
            euml.startTransaction();
            ExperUser experUser=euml.findByExperAndUserId(experId,userId);
            experUser.setIsAgree(isAgree);
            euml.save(experUser);
            euml.commitTransaction();
        }catch (Exception e){
            e.printStackTrace();
        }
        out.print(result);
    }



    @RequestMapping("update")
    public String update(Long id,Model model){
        ExperimentImpl eml=ExperimentImpl.getInstance();
        Experiment experiment = eml.getById(id);
        model.addAttribute("id",id);
        model.addAttribute("exper",experiment);
        return "View/experiment/experimentUpdate";
    }

    @RequestMapping("doUpdate")
    public void doUpdate(HttpServletRequest request,PrintWriter out){
        Long result = -1L;
        ExperimentImpl eml=ExperimentImpl.getInstance();
        try{
            JSONObject j = createJson(request);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy k:m a", Locale.US);
            eml.startTransaction();
            Experiment exper = eml.getById(j.getLong("experId"));
            String pretime=j.getString("pretime");
            String endtime=j.getString("endtime");
            pretime=handleLocale(pretime);
            endtime=handleLocale(endtime);
            exper.setName(j.getString("name"));
            exper.setInformation(j.getString("content"));
            exper.setRequirement(j.getString("requirement"));
            exper.setBeginTime(sdf.parse(pretime));
            exper.setEndTime(sdf.parse(endtime));
            exper.setContact(j.getString("linkman"));
            exper.setType(j.getString("type"));
            exper.setQQ(j.getString("qq"));
            exper.setPhone(j.getString("phone"));
            exper.setEmail(j.getString("email"));
            exper.setNote(j.getString("note"));
            exper.setCount(j.getInt("count"));
            eml.update(exper);
            result = j.getLong("experId");
            eml.commitTransaction();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        out.print(result);
    }

    public String handleLocale(String date){
    String pics[]=date.split(" ");
    if(pics[2].equals("上午")){
    return pics[0]+" "+pics[1]+" am";
    }else if (pics[2].equals("下午")){
    return pics[0]+" "+pics[1]+" pm";
    }else{
        return date;
    }
    }

    /**
     * 实验评价页面
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("scoreExper")
    public String scoreExperiment(HttpSession session,Model model){
        ExperimentImpl eml=ExperimentImpl.getInstance();
        UserImpl uml=UserImpl.getInstance();
        Long userId=(Long)session.getAttribute("userId");
        User user=uml.getById(userId);
        List<Experiment>elist=eml.getAllByUser(user);
        model.addAttribute("list",elist);
        return "View/experiment/scoreExper";
    }

    /**
     * 对该实验的所有参与人员进行评分
     * @param experId
     * @param model
     * @return
     */
    @RequestMapping("scoreList")
    public String scoreList(Long experId,Model model){
        ExperimentImpl eml=ExperimentImpl.getInstance();
        ExperUserImpl euml=ExperUserImpl.getInstance();
        Experiment experiment=eml.getById(experId);
        List<ExperUser>list=euml.findByProperty("experiment",experiment);
        model.addAttribute("list",list);
        model.addAttribute("experName",experiment.getName());
        return "View/experiment/scoreList";
    }

    @RequestMapping("myAttend")
    public String attendExperiment(HttpSession session,Model model){
        UserImpl uml=UserImpl.getInstance();
        Long userId=(Long)session.getAttribute("userId");
        User user=uml.getById(userId);
        ExperUserImpl euml=ExperUserImpl.getInstance();
        List<ExperUser>list=euml.findByProperty("user",user);
        return "View/experiment/myAttendExper";
    }

}
