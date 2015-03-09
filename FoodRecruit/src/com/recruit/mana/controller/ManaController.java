package com.recruit.mana.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.recruit.Bean.PageBean;
import com.recruit.Model.Classes;
import com.recruit.Model.Major;
import com.recruit.mana.bean.ClaMajBean;
import com.recruit.mana.dao.ClassDao;
import com.recruit.mana.dao.MajorDao;
import com.recruit.mana.bean.NotiUserBean;
import com.recruit.notification.dao.NotificationDao;
import com.recruit.notification.model.Notification;
import com.recruit.user.Dao.UserDao;
import com.recruit.user.model.User;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
    public String index(Model model){
        UserDao userDao= UserDao.getInstance();
        //取得所有用户信息
        List<User> list=userDao.getAllUser();
        model.addAttribute("list",list);
        return "View/mana/userManager";
    }

    /**
     * 用户展示页面，由用户id取得用户数据，返回前端
     * @param id 用户id
     * @param model
     * @return 用户修改界面
     */
    @RequestMapping("showuserbyid")
    public String showUserById(Long id,Model model){
        UserDao userDao=UserDao.getInstance();
        User user=userDao.getUserById(id);
        model.addAttribute("user",user);
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
        NotificationDao notificationDao = NotificationDao.getInstance();
        List<Notification>list=notificationDao.getAllNotification(type);
        List<NotiUserBean>nlist=NotiUserBean.buildList(list);
        model.addAttribute("list",nlist);
        model.addAttribute("type",type);
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
        NotificationDao notificationDao=NotificationDao.getInstance();
        Notification notification=notificationDao.getNotiById(id);
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
        model.addAttribute("name",name);
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
        MajorDao majorDao=MajorDao.getInstance();
        //分页时要统计所有的元素个数
        int total=majorDao.countAllMajor();
        //构造pagebean其中mana和majormanager是spring mvc的映射名。
        PageBean pageBean=PageBean.getInstance(page,total,"/mana","/majormanager");
        model.addAttribute("list",majorDao.getAllMajor(pageBean));
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("classpage","active");
        majorDao.close();
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
        ClassDao classDao=ClassDao.getInstance();
        //分页时要统计所有的元素个数
        int total=classDao.countAllClass();
        Object obj=session.getAttribute("yearList");
        if(obj==null) {
            List<Integer> yearList = classDao.getAllYear();
            int year=yearList.get(0);
            List<Major>majorList=MajorDao.getInstance().getAllMajorByYear(year);
            System.out.println(yearList.size());
            session.setAttribute("majorList",majorList);
            session.setAttribute("yearList", yearList);
        }
        PageBean pageBean=PageBean.getInstance(page,total,"/mana","/classmanager");
        List<ClaMajBean>list=ClaMajBean.buildList(classDao.getAllClass(pageBean));
        System.out.println("the size of all class is:"+list.size());
        model.addAttribute("list", list);
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("classpage","active");
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
        System.out.println("the gender is:" + gender);
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
        }
        return "View/mana/editUser";
    }

    /**
     * 反馈回复
     * @param id 回复对象id
     * @param content 回复内容
     */
    @RequestMapping("reply")
    public void reply(Long id,String content){
        NotificationDao notificationDao=NotificationDao.getInstance();
        Notification notification=new Notification();
        try {
        notificationDao.begin();
        notification.setUserId(id);
        notification.setInfo(content);
        notification.setType(4);
        notification.setIsNew(true);
        notificationDao.save(notification);
        notificationDao.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        notificationDao.close();
        }

    }

    /**
     * 新增专业
     * @param name 名称
     * @param year 年级
     * @param out json输出
     */
    @RequestMapping("addmajor")
    public void addMajor(String name,int year,PrintWriter out){
        MajorDao majorDao=MajorDao.getInstance();
        int result=1;
        try{
        majorDao.begin();
            Major major=new Major();
            major.setMajorName(name);
            major.setYear(year);
            majorDao.save(major);
            majorDao.commit();
            out.print(result);
        }catch (Exception e){
        e.printStackTrace();
            result=-1;
            out.print(result);
        }finally {
        majorDao.close();
        }
    }

    /**
     * 新增班级
     * @param name 班级名称
     * @param majorId 所属专业id
     * @param out
     */
    @RequestMapping("addclass")
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

    /**
     * 根据年级获取所有的班级
     * @param year 对应年级
     * @return
     */
    @RequestMapping("getmajor")
    public @ResponseBody List<Major> getMajor(int year){
        MajorDao majorDao=MajorDao.getInstance();
        List<Major> list=majorDao.getAllMajorByYear(year);
        return list;
    }




}
