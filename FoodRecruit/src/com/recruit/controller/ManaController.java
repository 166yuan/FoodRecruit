package com.recruit.controller;

import com.recruit.base.NotiUserBean;
import com.recruit.base.PageBean;
import com.recruit.impl.*;
import com.recruit.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.PrintWriter;
import java.util.ArrayList;
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
    public String index(Model model,Integer page){
        UserImpl uml= UserImpl.getInstance();
        PageBean pageBean=PageBean.getInstance(1,0,"/mana","/index");
        int total=0;
        List<User> list=new ArrayList<User>();
        if(page==null){
            page=1;
        }
        try{
            uml.startTransaction();
            total=uml.getSize();
            pageBean=PageBean.getInstance(page,total,"/mana","/index");
            list=uml.findAll(pageBean);
            uml.Instance(list);
        }catch (Exception e){
        e.printStackTrace();
        }finally {
            uml.commitTransaction();
        }
        model.addAttribute("list",list);
        model.addAttribute("pageBean",pageBean);
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
        User user=null;
        try {
            uml.startTransaction();
            user=uml.getById(id);
            uml.Instance(user);
        }catch (Exception e){
        e.printStackTrace();
        }finally {
            uml.commitTransaction();
        }
        model.addAttribute("user", user);
        return "View/mana/editUser";
    }

    /**
     * 反馈展示页面，取得所有用户反馈
     * @param model
     * @param type notification的类型，1表示未读，2表示已读，3表示所有
     * @return 反馈列表页面
     */
    @RequestMapping("showfeedback")
    public String showFeedBack(int page,Model model,int type){
        if(type==0){
            type=1;
        }
        NotificationImpl nml=NotificationImpl.getInstance();
        List<NotiUserBean>nlist= null;
        PageBean pageBean=PageBean.getInstance(1,0,"/mana","/showfeedback");
        try {
            nml.startTransaction();
            int total=nml.getSizeByType(type);
            pageBean=PageBean.getInstance(page,total,"/mana","/showfeedback");
            List<Notification>list=nml.getAllByType(type,pageBean);
            nlist = nml.buildList(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            nml.commitTransaction();
        }
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
    public String showNotiById(Integer id,String name,Model model){
        NotificationImpl nml=NotificationImpl.getInstance();
        Notification notification=new Notification();
        try {
            nml.startTransaction();
            notification=nml.getById(id);
            notification.setIsNew(false);
            nml.update(notification);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            nml.commitTransaction();
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
        if (page==0){
            page=1;
        }
        MajorImpl mml=MajorImpl.getInstance();
        PageBean pageBean= PageBean.getInstance(1, 0, "/mana", "/majormanager");
        List<Major>list= new ArrayList<Major>();
        try {
            mml.startTransaction();
            //分页时要统计所有的元素个数
            int total=mml.getSize();
            //构造pagebean其中mana和majormanager是spring mvc的映射名。
            pageBean = PageBean.getInstance(page, total, "/mana", "/majormanager");
            list = mml.getAllMajor(pageBean);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mml.commitTransaction();
        }
        model.addAttribute("list",list);
        model.addAttribute("pageBean",pageBean);
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
        if (page==0){
            page=1;
        }
        int year=0;
        ClassesImpl cml=ClassesImpl.getInstance();
        MajorImpl mml=MajorImpl.getInstance();
        PageBean pageBean=PageBean.getInstance(1,0,"/mana","/classmanager");
        List<Major>majorList=new ArrayList<Major>();
        List<Integer>yearList=new ArrayList<Integer>();
        List<Classes>classesList=new ArrayList<Classes>();
        try{
            mml.startTransaction();
            yearList = mml.getAllYear();
            if(yearList.size()!=0){
                year=yearList.get(0);
                majorList=mml.getMajorByYear(year);
            }
        }catch (Exception e){
        e.printStackTrace();
        }finally {
           mml.commitTransaction();
        }

        try {
            cml.startTransaction();
            int total=cml.getSize();
            pageBean = PageBean.getInstance(page, total, "/mana", "/classmanager");
            classesList=cml.findByPage(pageBean.getCurPage(), pageBean.getPerPage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cml.commitTransaction();
        }
        model.addAttribute("majorList",majorList);
        model.addAttribute("yearList", yearList);
        model.addAttribute("list", classesList);
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
    public String edituser(Integer id,String password,int type,int status,String name,Boolean gender,Integer major,Integer classes
            ,String phone,String email,String qq,String address,String self_info,Boolean isActive,Model model)
    {
        Classes cla= null;
        ClassesImpl cml=ClassesImpl.getInstance();
        try {
            cml.startTransaction();
            cla = cml.getById(classes);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            cml.commitTransaction();
        }
        MajorImpl mml=MajorImpl.getInstance();
        Major major1= null;
        try {
            mml.startTransaction();
            major1 = mml.getById(major);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mml.commitTransaction();
        }
        UserImpl uml=UserImpl.getInstance();
        User user= null;
        try {
            uml.startTransaction();
            user = uml.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            uml.commitTransaction();
        }
        if(user!=null){
            try {
                user.setPassword(password);
                user.setType(type);
                user.setStatus(status);
                user.setName(name);
                user.setGender(gender);
                user.setMajor(major1);
                user.setClasses(cla);
                user.setPhone(phone);
                user.setEmail(email);
                user.setQq(qq);
                user.setAddress(address);
                user.setSelf_info(self_info);
                user.setIsActive(isActive);
                uml.startTransaction();
                uml.update(user);
                uml.Instance(user);
                uml.commitTransaction();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        model.addAttribute("user",user);
        return "View/mana/editUser";
    }

    /**
     * 反馈回复
     * @param id 回复对象id
     * @param content 回复内容
     */
    @RequestMapping("reply")
    public void reply(Integer id,HttpSession session,String content){
        NotificationImpl nml=NotificationImpl.getInstance();
        UserImpl uml=UserImpl.getInstance();
        User recervier=new User();
        User creater=new User();
        try {
            uml.startTransaction();
            recervier=uml.getById(id);
            Integer cid=(Integer)session.getAttribute("userId");
            creater=uml.getById(cid);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            uml.commitTransaction();
        }
        Notification notification=new Notification();
        try {
        notification.setReceiver(recervier);
        notification.setInfo(content);
        notification.setType(4);
        notification.setIsNew(true);
        notification.setCreator(creater);
            nml.startTransaction();
            nml.save(notification);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            nml.commitTransaction();
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
        MajorImpl mml=MajorImpl.getInstance();
        int result=1;
        Major major=new Major();
        try{
            if(major!=null){
                result=-2;
            }else {
                mml.startTransaction();
                major.setMajorName(name);
                major.setYear(year);
                mml.save(major);
            }
        }catch (Exception e){
        e.printStackTrace();
            result=-1;
        }finally {
        mml.commitTransaction();
        }
        out.print(result);
    }

    /**
     * 新增班级
     * @param name 班级名称
     * @param majorId 所属专业id
     * @param out
     */
    @RequestMapping("addclass")
    public void addClass(String name,Integer majorId,PrintWriter out){
        ClassesImpl cml=ClassesImpl.getInstance();
        Classes classes=new Classes();
        Major major=new Major();
        MajorImpl mml=MajorImpl.getInstance();
        try {
            mml.startTransaction();
            major=mml.getById(majorId);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mml.commitTransaction();
        }

        int result=1;
        try{
           cml.startTransaction();
            classes.setClassName(name);
            classes.setMajor(major);
            cml.save(classes);
            out.print(result);
        }catch (Exception e){
        e.printStackTrace();
            result=-1;
            out.print(result);
        }finally {
            cml.commitTransaction();
        }

    }
    /**
     * 根据年级获取所有的班级
     * @param year 对应年级
     * @return
     */
    @RequestMapping("getmajor")
    public @ResponseBody List<Major> getMajor(int year){
        MajorImpl mml=MajorImpl.getInstance();
        List<Major> list=new ArrayList<Major>();
        try {
            mml.startTransaction();
            list=mml.getMajorByYear(year);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mml.commitTransaction();
        }
        return list;
    }

    /**
     * 取得所有的竞赛
     * @return 竞赛管理页面
     */
    @RequestMapping("competManage")
    public String competManage(Model model,int page){
        if(page==0){
            page=1;
        }
        CompetitionImpl cml=CompetitionImpl.getInstance();
        PageBean pageBean=PageBean.getInstance(1,0,"/mana","/competManage");
        List<Competition>list=new ArrayList<Competition>();
        try {
        cml.startTransaction();
            int total=cml.getSize();
            pageBean=PageBean.getInstance(page,total,"/mana","/competManage");
            list=cml.findByPage(pageBean.getCurPage(),pageBean.getPerPage());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        cml.commitTransaction();
        }
        model.addAttribute("list",list);
        return "View/mana/competManage";
    }

    @RequestMapping("experManage")
    public String experManage(Model model,int page){
        ExperimentImpl eml=ExperimentImpl.getInstance();
        eml.startTransaction();
        int total=eml.getSize();
        PageBean pageBean=PageBean.getInstance(page,total,"/mana","/experManage");
        List<Experiment>list=eml.findByPage(pageBean.getCurPage(),pageBean.getPerPage());
        eml.commitTransaction();
        model.addAttribute("list",list);
        model.addAttribute("pageBean",pageBean);
        return "View/mana/experManage";
    }


}
