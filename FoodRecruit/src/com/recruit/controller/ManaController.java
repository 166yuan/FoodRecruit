package com.recruit.controller;

import com.recruit.base.PageBean;
import com.recruit.impl.MajorImpl;
import com.recruit.impl.UserImpl;
import com.recruit.model.Major;
import com.recruit.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.PrintWriter;
import java.util.List;

/** 后台管理
 * Created by Administrator on 2015/2/9.
 */
@Controller
@RequestMapping("/mana")
public class ManaController {

    /**
     * 用户管理页面，这里用户管理做未后台的主页面
     * @param model
     * @return 用户管理（后台主页）
     */
    @RequestMapping("index")
    public String index(Model model,int page){
        UserImpl uml= UserImpl.getInstance();
        uml.startTransaction();
        //取得所有用户信息
        int total=uml.getSize();
        PageBean pageBean=PageBean.getInstance(page,total,"/mana","/index");
        List<User> list=uml.findAll(pageBean);
        list.size();
        model.addAttribute("list",list);
        model.addAttribute("pageBean",pageBean);
        uml.commitTransaction();
        return "View/mana/userManager";
    }

    /**
     * 用户展示页面，由用户id取得用户数据，返回前端
     * @param id 用户id
     * @param model
     * @return 用户修改界面
     */
    @RequestMapping("showuserbyid")
    public String showUserById(Integer id,Model model){
        UserImpl uml=UserImpl.getInstance();
        uml.startTransaction();
        User user=uml.getById(id);
        System.out.println("type:"+user.getType());
        model.addAttribute("user", user);
        uml.commitTransaction();
        return "View/mana/editUser";
    }

    /**
     * 反馈展示页面，取得所有用户反馈
     * @param model
     * @param type notification的类型，1表示未读，2表示已读，3表示所有
     * @return 反馈列表页面
     */
    @RequestMapping("showfeedback")
    public String showFeedBack(Model model,int type){
       /* NotificationDao notificationDao = NotificationDao.getInstance();
        List<Notification>list=notificationDao.getAllFeedback(type);
        List<NotiUserBean>nlist=NotiUserBean.buildList(list);
        model.addAttribute("list",nlist);
        model.addAttribute("type",type);*/
        return "View/mana/feedback";
    }

    /**
     * 用id找出对应反馈。交给前端
     * @param id 反馈id
     * @param name 用户名，减少数据读取。
     * @param model
     * @return 反馈页面
     */
    @RequestMapping("showNotiById")
    public String showNotiById(Long id,String name,Model model){
      /*  NotificationDao notificationDao=NotificationDao.getInstance();
        Notification notification=notificationDao.get(id);
        try {
            notificationDao.begin();
            notification.setIsNew(false);
            notificationDao.save(notification);
            notificationDao.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            notificationDao.close();
        }
        model.addAttribute("notification",notification);
        model.addAttribute("name",name);*/
        return "View/mana/showNotiById";
    }

    /**
     * 专业管理
     * @param model
     * @param page 第几页
     * @return
     */
    @RequestMapping("majormanager")
    public String majorManager(Model model,int page){
        MajorImpl mml=MajorImpl.getInstance();
        //分页时要统计所有的元素个数
        int total=mml.getSize();
        //构造pagebean其中mana和majormanager是spring mvc的映射名。
        PageBean pageBean=PageBean.getInstance(page,total,"/mana","/majormanager");
        List<Major>list=mml.getAllMajor(pageBean);
        model.addAttribute("list",list);
        model.addAttribute("pageBean",pageBean);
        mml.commitTransaction();
        return  "View/mana/majorManage";
    }

    /**
     * 班级管理
     * @param model
     * @param page 第几页
     * @param session
     * @return
     */
    @RequestMapping("classmanager")
    public String classManager(Model model,int page,HttpSession session){
       /*int year=0;
        ClassDao classDao=ClassDao.getInstance();
        //分页时要统计所有的元素个数
        int total=classDao.countAllClass();
            List<Integer> yearList = classDao.getAllYear();
            if(yearList.size()!=0){ year=yearList.get(0);}
            List<Major>majorList=MajorDao.getInstance().getAllMajorByYear(year);
            model.addAttribute("majorList",majorList);
            model.addAttribute("yearList", yearList);
        PageBean pageBean=PageBean.getInstance(page,total,"/mana","/classmanager");
        List<ClaMajBean>list=ClaMajBean.buildList(classDao.getAllClass(pageBean));
        model.addAttribute("list", list);
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("classpage","active");*/
        return "View/mana/classManage";
    }

    /*  ------------------------------ 展示页面都写在此线上，增删改都写在下面      ---------------------------------------     */

    /**
     * 用户修改
     * @param id
     * @param password
     * @param type
     * @param status
     * @param name
     * @param gender
     * @param major
     * @param classes
     * @param phone
     * @param email
     * @param qq
     * @param address
     * @param self_info
     * @param isActive
     * @param model
     * @return
     */
    @RequestMapping("edituser")
    public String edituser(Long id,String password,int type,int status,String name,int gender,String major,String classes
            ,String phone,String email,String qq,String address,String self_info,String isActive,Model model)
    {
     /*   System.out.println("the gender is:" + gender);
        UserDao userDao=UserDao.getInstance();
        User user=userDao.getUserById(id);
        System.out.println("user is:" + user.getName());
        if(user!=null){
            try {
                userDao.begin();
                user.setPassword(password);
                user.setType(type);
                user.setStatus(status);
                user.setName(name);
                user.setGender(gender);
                user.setMajor(major);
                user.setClasses(classes);
                user.setPhone(phone);
                user.setEmail(email);
                user.setQq(qq);
                user.setAddress(address);
                user.setSelf_info(self_info);
                user.setIsActive(isActive);
                userDao.update(user);
                model.addAttribute("user",user);
                userDao.commit();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                userDao.close();
            }
        }*/
        return "View/mana/editUser";
    }

    /**
     * 反馈回复
     * @param id 回复对象id
     * @param content 回复内容
     */
    @RequestMapping("reply")
    public void reply(Long id,String content){
     /*   NotificationDao notificationDao=NotificationDao.getInstance();
        Notification notification=new Notification();
        try {
        notificationDao.begin();
        notification.setReceiverId(id);
        notification.setInfo(content);
        notification.setType(4);
        notification.setIsNew(true);
        notificationDao.save(notification);
        notificationDao.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        notificationDao.close();
        }*/

    }

    /**
     * 新增专业
     * @param name 名称
     * @param year 年级
     * @param out json输出
     */
  /*  @RequestMapping("addmajor")
    public void addMajor(String name,int year,PrintWriter out){
        MajorDao majorDao=MajorDao.getInstance();
        int result=1;
        try{

            Major major=majorDao.getByNameAndYear(name,year);
            if(major!=null){
                result=-2;
            }else {
                majorDao.begin();
                major=new Major();
                major.setMajorName(name);
                major.setYear(year);
                majorDao.save(major);
                majorDao.commit();
            }
        }catch (Exception e){
        e.printStackTrace();
            result=-1;
        }finally {
        majorDao.close();
        }
        out.print(result);
    }*/

    /**
     * 新增班级
     * @param name 班级名称
     * @param majorId 所属专业id
     * @param out
     */
   /* @RequestMapping("addclass")
    public void addClass(String name,long majorId,PrintWriter out){
        ClassDao classDao=ClassDao.getInstance();
        Classes classes=new Classes();
        int result=1;
        try{
            classDao.begin();
            classes.setClassName(name);
            classes.setMajorId(majorId);
            classDao.save(classes);
            classDao.commit();
            out.print(result);
        }catch (Exception e){
        e.printStackTrace();
            result=-1;
            out.print(result);
        }finally {
            classDao.close();
        }

    }
*/
    /**
     * 根据年级获取所有的班级
     * @param year 对应年级
     * @return
     */
/*    @RequestMapping("getmajor")
    public @ResponseBody List<Major> getMajor(int year){
        MajorDao majorDao=MajorDao.getInstance();
        List<Major> list=majorDao.getAllMajorByYear(year);
        return list;
    }*/

    /**
     * 取得所有的竞赛
     * @return 竞赛管理页面
     */
    @RequestMapping("competManage")
    public String competManage(Model model){
      /*  ComDao comDao=ComDao.getInstance();
        List<Competition>list= comDao.getAllCompetition();
        model.addAttribute("list",list);*/
        return "View/mana/competManage";
    }

    @RequestMapping("experManage")
    public String experManage(Model model){
     /*   ExperimentDao experimentDao=ExperimentDao.getInstance();
        List<Experiment>list=experimentDao.getAllExperiment();
        model.addAttribute("list",list);*/
        return "View/mana/experManage";
    }


}
