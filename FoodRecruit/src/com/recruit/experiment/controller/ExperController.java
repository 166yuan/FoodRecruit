package com.recruit.experiment.controller;

import com.recruit.experUser.bean.ExperUserBean;
import com.recruit.experUser.dao.ExperUserDao;
import com.recruit.experUser.model.ExperUser;
import com.recruit.experiment.bean.ExperStatusBean;
import com.recruit.experiment.dao.ExperimentDao;
import com.recruit.experiment.model.Experiment;

import com.recruit.user.Dao.UserDao;
import com.recruit.user.model.User;
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
        ExperimentDao exdao=ExperimentDao.getInstance();
        Experiment experiment = exdao.get(id);
        model.addAttribute("exper",experiment);
        System.out.println("from " + from);
        model.addAttribute("from", from);
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
        ExperimentDao eDao=ExperimentDao.getInstance();
        Long userId = (Long)session.getAttribute("userId");

        DetachedCriteria dc = DetachedCriteria.forClass(Experiment.class);

        dc.add(Restrictions.eq("publishId", userId));

        if ("asc".equals(order))
            dc.addOrder(Order.asc(by));
        if ("desc".equals(order))
            dc.addOrder(Order.desc(by));

        start = start != null? start : 0;
        size  = size  != null? size  : 10;

        List<Experiment> list = eDao.search(dc, start, size);

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
        ExperimentDao eDao = ExperimentDao.getInstance();
        eDao.begin();

        DetachedCriteria dc = DetachedCriteria.forClass(Experiment.class);

        dc.add(Restrictions.eq("isOk",false));

        if ("asc".equals(order))
            dc.addOrder(Order.asc(by));
        if ("desc".equals(order))
            dc.addOrder(Order.desc(by));

        start = start != null? start : 0;
        size  = size  != null? size  : 8;

        List<Experiment> list = eDao.search(dc, start, size);

        eDao.close();
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
        ExperimentDao experDao= ExperimentDao.getInstance();
        Long experId = -1L;
        try{

            JSONObject j = createJson(request);
            Long publisherId = (Long)request.getSession().getAttribute("userId");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy k:m a", Locale.US);
            experDao.begin();
            Experiment exper=new Experiment();
            exper.setPublishId(publisherId);
            exper.setName(j.getString("name"));
            exper.setInformation(j.getString("content"));
            exper.setRequirement(j.getString("requirement"));
            exper.setBeginTime(sdf.parse(j.getString("pretime")));
            exper.setEndTime(sdf.parse(j.getString("endtime")));
            exper.setContact(j.getString("linkman"));
            exper.setQQ(j.getString("qq"));
            exper.setPhone(j.getString("phone"));
            exper.setEmail(j.getString("email"));
            exper.setNote(j.getString("note"));
            exper.setCount(j.getInt("count"));
            experDao.save(exper);

            experId = exper.getId();
            experDao.commit();
            System.out.println("test: " + experId);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            experDao.close();
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
        ExperimentDao eDao = ExperimentDao.getInstance();
        try{
            eDao.begin();
            eDao.remove(id);
            eDao.commit();
            result = 1;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            eDao.close();
        }
        out.print(result);
    }



    @RequestMapping("attendList")
    public String attendList(Long experId,Model model){
        ExperimentDao experimentDao=ExperimentDao.getInstance();
        ExperUserDao experUserDao=ExperUserDao.getInstance();
        Experiment experiment=experimentDao.getById(experId);
        List<ExperUser>list=experUserDao.getByExperId(experId);
        List<ExperUserBean>list1=ExperUserBean.buildList(list);
        model.addAttribute("list",list1);
        model.addAttribute("experName",experiment.getName());
        model.addAttribute("number",experiment.getCount());
        return "View/experiment/attendList";
    }

    @RequestMapping("employ")
    public void employ(long experId,long userId,boolean isAgree,PrintWriter out){
        int result=1;
        ExperUserDao experUserDao=ExperUserDao.getInstance();
        try{
            experUserDao.begin();
            ExperUser experUser=experUserDao.forExperIdAndUserId(experId, userId);
            experUser.setIsAgree(isAgree);
            experUserDao.save(experUser);
            experUserDao.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            experUserDao.close();
        }
        out.print(result);
    }



    @RequestMapping("update")
    public String update(Long id,Model model){
        ExperimentDao eDao = ExperimentDao.getInstance();
        Experiment experiment = eDao.get(id);
        model.addAttribute("id",id);
        model.addAttribute("exper",experiment);
        return "View/experiment/experimentUpdate";
    }

    @RequestMapping("doUpdate")
    public void doUpdate(HttpServletRequest request,PrintWriter out){
        Long result = -1L;
        ExperimentDao eDao = ExperimentDao.getInstance();
        try{
            JSONObject j = createJson(request);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy k:m a", Locale.US);
            eDao.begin();


            Experiment exper = eDao.get(j.getLong("experId"));
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
            exper.setQQ(j.getString("qq"));
            exper.setPhone(j.getString("phone"));
            exper.setEmail(j.getString("email"));
            exper.setNote(j.getString("note"));
            exper.setCount(j.getInt("count"));
            eDao.update(exper);

            result = j.getLong("experId");
            eDao.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            eDao.close();
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
        ExperimentDao eDao=ExperimentDao.getInstance();
        Long userId=(Long)session.getAttribute("userId");
        List<Experiment>elist=eDao.findMyPublishExperiment(userId);
        List<ExperStatusBean>list=ExperStatusBean.buildList(elist);
        model.addAttribute("list",list);
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
        ExperimentDao experimentDao=ExperimentDao.getInstance();
        ExperUserDao experUserDao=ExperUserDao.getInstance();
        Experiment experiment=experimentDao.getById(experId);
        List<ExperUser>list=experUserDao.getByExperId(experId);
        //过滤没被选中的实验员，以防评分出差错
        List<ExperUserBean>list1=ExperUserBean.buildList2(list);
        model.addAttribute("list",list1);
        model.addAttribute("experName",experiment.getName());
        return "View/experiment/scoreList";
    }


}
