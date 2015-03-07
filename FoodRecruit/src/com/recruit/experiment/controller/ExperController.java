package com.recruit.experiment.controller;

import com.recruit.experUser.bean.ExperUserBean;
import com.recruit.experUser.dao.ExperUserDao;
import com.recruit.experUser.model.ExperUser;
import com.recruit.experiment.dao.ExperimentDao;
import com.recruit.experiment.model.Experiment;

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
import java.time.DateTimeException;
import java.util.Date;
import java.util.List;

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

    @RequestMapping(value = "publish")
    public String publicExper(HttpSession session,Model model) {
        String account=(String)session.getAttribute("account");
        model.addAttribute("account", account);
        return "/View/experiment/experiment";
    }

    @RequestMapping(value = "showExper")
    public String showExperById(Long id,String from,HttpSession session,Model model){
        ExperimentDao exdao=ExperimentDao.getInstance();
        Experiment experiment = exdao.get(id);
        model.addAttribute("exper",experiment);
        System.out.println("from " + from);
        model.addAttribute("from", from);
     return "/View/experiment/show_experiment";
    }

    @RequestMapping(value = "myPublishExperiment")
    public  String ExperList(HttpSession session,Model model){
        ExperimentDao exdao=ExperimentDao.getInstance();
        Long userId = (Long)session.getAttribute("userId");

        List<Experiment> list = exdao.findMyPublishExperiment(userId);
        model.addAttribute("list",list);
        return "View/experiment/myPublishExperiment";
    }

    @RequestMapping("nendAssistant")
    public String needAssistant(HttpSession session,Model model){
        ExperimentDao eDao = ExperimentDao.getInstance();
        eDao.begin();
        List<Experiment> list = eDao.findAllNeedAssistant();
        eDao.close();
        model.addAttribute("list",list);
        //---这个url作为测试用 要替换成experimentNeedAssistant.html 那个
        return "View/experiment/experimentNeedAssistant";
    }

    @RequestMapping(value = "/addExper")
    public void newExper(HttpServletRequest request,PrintWriter out){
        ExperimentDao experDao= ExperimentDao.getInstance();
        Long experId = -1L;
        try{

            JSONObject j = createJson(request);
            Long publisherId = (Long)request.getSession().getAttribute("userId");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy k:m a");
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

    @RequestMapping("update")
    public void update(HttpServletRequest request,PrintWriter out){
        int result = 0;
        ExperimentDao eDao = ExperimentDao.getInstance();
        try{
            JSONObject j = createJson(request);
            eDao.begin();
            eDao.commit();
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

    @RequestMapping("editExper")
    public String editExperById(Long id,HttpSession session,Model model){
        ExperimentDao exdao=ExperimentDao.getInstance();
        Experiment experiment = exdao.get(id);
        model.addAttribute("exper",experiment);
        return "/View/experiment/editExper";
    }

}
