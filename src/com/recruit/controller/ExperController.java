package com.recruit.controller;


import com.recruit.base.BaseController;
import com.recruit.bean.PageBean;
import com.recruit.bean.ExperScoreBean;
import com.recruit.impl.ExperUserImpl;
import com.recruit.impl.ExperimentImpl;

import com.recruit.impl.UserImpl;
import com.recruit.model.ExperUser;
import com.recruit.model.Experiment;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Administrator on 2015/1/29.
 */
@Controller
@RequestMapping("/exper")
public class ExperController extends BaseController {

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
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "showExper")
    public String showExperById(Integer id,HttpSession session,Model model){
        Experiment experiment =experimentDao.getById(id);
        model.addAttribute("exper", experiment);
     return "/View/experiment/show_experiment";
    }

    /**
     * 返回我发布的所有实验
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "myPublishExperiment")
    public  String myPublishExperiment(Integer page, HttpSession session, Model model){
        Integer userId = (Integer)session.getAttribute("userId");
        PageBean pageBean=PageBean.getInstance(1,0,"/exper","/myPublishExperiment");
        List<Experiment> list=new ArrayList<Experiment>();
        if(page==null){
            page=1;
        }
        try{
            int total=experimentDao.countByPublisher(userId);
            pageBean=PageBean.getInstance(page,total,"/exper","/myPublishExperiment");
            /* if ("asc".equals(order))
            dc.addOrder(Order.asc(by));
        if ("desc".equals(order))
            dc.addOrder(Order.desc(by));*/
            list= experimentDao.getMyPublishExper(userId,pageBean);

        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("list",list);
        model.addAttribute("pageBean",pageBean);
        return "View/experiment/myPublishExperiment";
    }

    /**
     * 返回所有需要招收实验助手的实验
     * @param order 升序(asc) | 降序（desc）
     * @param by    按该字段进行排序
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("nendAssistant")
    public String needAssistant(int page, String order, String by, HttpSession session, Model model){
       /* if ("asc".equals(order))
            dc.addOrder(Order.asc(by));
        if ("desc".equals(order))
            dc.addOrder(Order.desc(by));
*/
        int total=experimentDao.countNeedAssistant();
        PageBean pageBean=PageBean.getInstance(page,total,"/exper","/nendAssistant");
        List<Experiment> list = experimentDao.getNeedAssistant(pageBean);
        model.addAttribute("list",list);
        model.addAttribute("pageBean",pageBean);
        return "View/experiment/experimentNeedAssistant";
    }

    /**
     * 创建添加实验
     * @param request
     * @param out
     */
    @RequestMapping(value = "/addExper")
    public void newExper(HttpServletRequest request,HttpSession session,PrintWriter out){
        Integer publisherId = (Integer)session.getAttribute("userId");
        User user= userDao.getById(publisherId);
        Integer experId = -1;
        try{
            JSONObject j = createJson(request);
            System.out.println("the userId is:"+publisherId);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy k:m a", Locale.US);
            Experiment exper=new Experiment();
            System.out.println("exe herer");
            exper.setPublisher(user);
            System.out.println("name is:"+j.getString("name"));
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
            exper.setIsOutDate(false);
            experimentDao.save(exper);
            experId = exper.getId();
            publishLogDao.addExper(user,exper);
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
    public void delete(Integer id,HttpSession session,PrintWriter out){
        int result = 1;
        try{
           Experiment experiment=experimentDao.getById(id);
            if (experiment!=null){
                experimentDao.delete(id);
                Integer userId=(Integer)session.getAttribute("userId");
                User user=userDao.getById(userId);
                publishLogDao.deleteExper(user,experiment);
            }else {
                result=-1;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            result=-1;
        }
        out.print(result);
    }



    @RequestMapping("attendList")
    public String attendList(Integer experId,Model model){
        Experiment experiment=experimentDao.getById(experId);
        List<ExperUser>list=experUserDao.findByExper(experId);
        model.addAttribute("list",list);
        model.addAttribute("experName",experiment.getName());
        model.addAttribute("number",experiment.getCount());
        return "View/experiment/attendList";
    }

    @RequestMapping("employ")
    public void employ(Integer experId,Integer userId,boolean isAgree,PrintWriter out){
        int result=1;
        try{
            ExperUser experUser=experUserDao.findByExperAndUserId(experId,userId);
            experUser.setIsAgree(isAgree);
           experUserDao.save(experUser);
        }catch (Exception e){
            e.printStackTrace();
        }
        out.print(result);
    }



    @RequestMapping("update")
    public String update(Integer id,Model model){
        Experiment experiment = experimentDao.getById(id);
        model.addAttribute("id",id);
        model.addAttribute("exper",experiment);
        return "View/experiment/experimentUpdate";
    }

    @RequestMapping("doUpdate")
    public void doUpdate(HttpServletRequest request,PrintWriter out){
        Long result = -1L;
        try{
            JSONObject j = createJson(request);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy k:m a", Locale.US);
            Experiment exper = experimentDao.getById(j.getInt("experId"));
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
            experimentDao.update(exper);
            Integer userId=(Integer)request.getSession().getAttribute("userId");
            User user=userDao.getById(userId);
            publishLogDao.updateExper(user,exper);
            result = j.getLong("experId");
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
    public String scoreExperiment(int page,HttpSession session,Model model){
        Integer userId=(Integer)session.getAttribute("userId");
        int total=experimentDao.countNeedAssistant();
        PageBean pageBean=PageBean.getInstance(page,total,"/exper","/scoreExper");
        List<Experiment>elist=experimentDao.getAllByUser(userId,page);
        List<ExperScoreBean>list=experimentDao.buildList(elist);
        model.addAttribute("list",list);
        model.addAttribute("pageBean",pageBean);
        return "View/experiment/scoreExper";
    }

    /**
     * 对该实验的所有参与人员进行评分
     * @param experId
     * @param model
     * @return
     */
    @RequestMapping("scoreList")
    public String scoreList(Integer experId,Model model){
        Experiment experiment=experimentDao.getById(experId);
        List<ExperUser>list=experUserDao.findByExper(experId);
        model.addAttribute("list",list);
        model.addAttribute("experName",experiment.getName());
        return "View/experiment/scoreList";
    }

    @RequestMapping("myAttend")
    public String attendExperiment(HttpSession session,Model model){
        Integer userId=(Integer)session.getAttribute("userId");
        User user=userDao.getById(userId);
        return "View/experiment/myAttendExper";
    }

}
