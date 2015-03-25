package com.recruit.controller;

import com.recruit.base.BaseController;
import com.recruit.bean.ClassesBean;
import com.recruit.bean.NotiUserBean;
import com.recruit.bean.PageBean;
import com.recruit.impl.*;
import com.recruit.model.*;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/** 后台管理
 * Created by Administrator on 2015/2/9.
 */
@Controller
@RequestMapping("/mana")
public class ManaController extends BaseController {
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
     * 用户管理页面，这里用户管理做未后台的主页面
     * @param model
     * @return 用户管理（后台主页）
     */
    @RequestMapping("index")
    public String index(Model model,Integer page){
        PageBean pageBean=PageBean.getInstance(1,0,"/mana","/index");
        int total=0;
        List<User> list=new ArrayList<User>();
        if(page==null){
            page=1;
        }
        try{
            total=userDao.getSize();
            pageBean=PageBean.getInstance(page,total,"/mana","/index");
            list=userDao.findAll(pageBean);
        }catch (Exception e){
        e.printStackTrace();
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
        User user=null;
        List<Classes>classesList=new ArrayList<Classes>();
        try {
            user=userDao.getById(id);
        }catch (Exception e) {
            e.printStackTrace();
        }
        if (user.getMajor()!=null){
            Integer mid=user.getMajor().getId();
            classesList=classesDao.getClassByMajor(mid);
        }
        List<Major>majorlist=majorDao.findAll();
        model.addAttribute("user", user);
        model.addAttribute("majorList",majorlist);
        model.addAttribute("classList",classesList);
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
        List<NotiUserBean>nlist= null;
        PageBean pageBean=PageBean.getInstance(1,0,"/mana","/showfeedback");
        try {
            int total=notificationDao.getSizeByType(type);
            pageBean=PageBean.getInstance(page,total,"/mana","/showfeedback");
            List<Notification>list=notificationDao.getAllByType(type,pageBean);
            nlist = notificationDao.buildList(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("list",nlist);
        model.addAttribute("type",type);
        return "View/mana/feedback";
    }

    /**
     * 用id找出对应反馈。交给前端
     * @param id 反馈id
     * @param model
     * @return 反馈页面
     */
    @RequestMapping("showNotiById")
    public String showNotiById(Integer id,Model model){
        Notification notification=new Notification();
        try {
            notification=notificationDao.getById(id);
            notification.setIsNew(false);
            notificationDao.update(notification);
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("notification",notification);
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
        PageBean pageBean= PageBean.getInstance(1, 0, "/mana", "/majormanager");
        List<Major>list= new ArrayList<Major>();
        try {
            //分页时要统计所有的元素个数
            int total=majorDao.getSize();
            //构造pagebean其中mana和majormanager是spring mvc的映射名。
            pageBean = PageBean.getInstance(page, total, "/mana", "/majormanager");
            list = majorDao.getAllMajor(pageBean);
        } catch (Exception e) {
            e.printStackTrace();
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
        PageBean pageBean=PageBean.getInstance(1,0,"/mana","/classmanager");
        List<Major>majorList=new ArrayList<Major>();
        List<Integer>yearList=new ArrayList<Integer>();
        List<Classes>classesList=new ArrayList<Classes>();
        try{
            yearList = majorDao.getAllYear();
            if(yearList.size()!=0){
                year=yearList.get(0);
                majorList=majorDao.getMajorByYear(year);
            }
        }catch (Exception e){
        e.printStackTrace();
        }
        try {
            int total=classesDao.getSize();
            pageBean = PageBean.getInstance(page, total, "/mana", "/classmanager");
            classesList=classesDao.findByPage(pageBean.getCurPage(), pageBean.getPerPage());
        } catch (Exception e) {
            e.printStackTrace();
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
            ,String phone,String email,String qq,String address,String self_info,Boolean isActive,HttpSession session,Model model)
    {
        Classes cla= null;
        try {
            cla = classesDao.getById(classes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Major major1= null;
        try {
            major1 = majorDao.getById(major);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user= null;
        try {
            user = userDao.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
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
                userDao.update(user);
                Integer opid=(Integer)session.getAttribute("userId");
                User operator=userDao.getById(opid);
                publishLogDao.updateUser(operator,user);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        model.addAttribute("user",user);
        return "redirect:/mana/showuserbyid?id="+id;
    }

    /**
     * 反馈回复
     * @param id 回复对象id
     * @param content 回复内容
     */
    @RequestMapping("reply")
    public void reply(Integer id,String content,HttpSession session,PrintWriter out){
        int result=1;
        User recervier=new User();
        User creater=new User();
        try {
            recervier=userDao.getById(id);
            Integer cid=(Integer)session.getAttribute("userId");
            creater=userDao.getById(cid);
        }catch (Exception e){
            e.printStackTrace();
            result=-1;
        }
        Notification notification=new Notification();
        try {
            content=new String(content.getBytes("iso-8859-1"),"UTF-8");
        notification.setReceiver(recervier);
        notification.setInfo(content);
        notification.setType(4);
        notification.setIsNew(true);
        notification.setCreator(creater);
            notificationDao.save(notification);
        }catch (Exception e){
            e.printStackTrace();
            result=-1;
        }
        out.print(result);
        }

    /**
     * 新增专业
     * @param out json输出
     */
    @RequestMapping("addmajor")
    public void addMajor(HttpServletRequest request,PrintWriter out){
        int result=1;
        Major major=new Major();
        try{
            JSONObject j = createJson(request);
            String name=j.getString("name");
            int year=j.getInt("year");
            System.out.println(name);
            if(majorDao.existNameAndYear(name,year)){
                result=-2;
            }else {
                major.setMajorName(name);
                major.setYear(year);
                majorDao.save(major);
              Integer userId= (Integer) request.getSession().getAttribute("userId");
              User user= userDao.getById(userId);
                publishLogDao.addMajor(user,major);
            }
        }catch (Exception e){
        e.printStackTrace();
            result=-1;
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
    public void addClass(String name,Integer majorId,HttpSession session,PrintWriter out){
        Classes classes=new Classes();
        Major major=new Major();
        try {
            major=majorDao.getById(majorId);
        }catch (Exception e){
            e.printStackTrace();
        }
        int result=1;
        try{
            classes.setClassName(name);
            classes.setMajor(major);
            classesDao.save(classes);
            Integer userId=(Integer)session.getAttribute("userId");
            User user=userDao.getById(userId);
            publishLogDao.addClasses(user,classes);
            out.print(result);
        }catch (Exception e){
        e.printStackTrace();
            result=-1;
            out.print(result);
        }
    }
    /**
     * 根据年级获取所有的班级
     * @param year 对应年级
     * @return
     */
    @RequestMapping("getmajor")
    public @ResponseBody List<Major> getMajor(int year){
        List<Major> list=new ArrayList<Major>();
        try {
            list=majorDao.getMajorByYear(year);
        }catch (Exception e){
            e.printStackTrace();
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
        PageBean pageBean=PageBean.getInstance(1,0,"/mana","/competManage");
        List<Competition>list=new ArrayList<Competition>();
        try {
            int total=competitionDao.getSize();
            pageBean=PageBean.getInstance(page,total,"/mana","/competManage");
            list=competitionDao.findByPage(pageBean.getCurPage(),pageBean.getPerPage());
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("list",list);
        return "View/mana/competManage";
    }

    @RequestMapping("experManage")
    public String experManage(Model model,int page){
        int total=experimentDao.getSize();
        PageBean pageBean=PageBean.getInstance(page,total,"/mana","/experManage");
        List<Experiment>list=experimentDao.findByPage(pageBean.getCurPage(),pageBean.getPerPage());
        model.addAttribute("list",list);
        model.addAttribute("pageBean",pageBean);
        return "View/mana/experManage";
    }

    @RequestMapping("getClassByMajor")
    public @ResponseBody List<ClassesBean>getByMajor(Integer mid){
        List<Classes>list=new ArrayList<Classes>();
        List<ClassesBean>beanList=new ArrayList<ClassesBean>();
        list=classesDao.getClassByMajor(mid);
        for (int i=0;i<list.size();i++){
            Classes cla=list.get(i);
            ClassesBean classesBean=new ClassesBean();
            classesBean.setId(cla.getId());
            classesBean.setClassName(cla.getClassName());
            beanList.add(classesBean);
        }
        return beanList;
    }
    @RequestMapping("activeByid")
    public void activeByUserId(Integer uid,PrintWriter out){
          int result=1;
           User user= userDao.getById(uid);
        if (user!=null){
            user.setStatus(1);
            userDao.update(user);
        }else {
            result=-1;
        }
        out.print(result);
    }
    @RequestMapping("cancleByid")
    public void cancelByUserId(Integer uid,PrintWriter out){
        int result=1;
        User user= userDao.getById(uid);
        if (user!=null){
            user.setStatus(-1);
            userDao.update(user);
        }else {
            result=-1;
        }
        out.print(result);
    }
    @RequestMapping("freezeByid")
    public void freezeByUserId(Integer uid,PrintWriter out){
        int result=1;
        User user= userDao.getById(uid);
        if (user!=null){
            user.setStatus(-2);
            userDao.update(user);
        }else {
            result=-1;
        }
        out.print(result);
    }

    @RequestMapping("deleteUser")
    public void deleteUser(Integer userId,HttpSession session,PrintWriter out){
        int result=1;
        User user=userDao.getById(userId);
        if (user!=null){
            userDao.delete(userId);
            Integer opid=(Integer)session.getAttribute("userId");
            User operator=userDao.getById(opid);
            publishLogDao.deleteUser(operator,user);
        }else {
            result=-1;
        }
        out.print(result);
    }

    @RequestMapping("deleteMajor")
    public void deleteMajor(Integer majorId,HttpSession session,PrintWriter out){
        System.out.println("majorId:"+majorId);
        int result=1;
        Major major=majorDao.getById(majorId);
        if (major!=null){
            majorDao.delete(majorId);
            Integer userId=(Integer)session.getAttribute("userId");
            User user=userDao.getById(userId);
            publishLogDao.deleteMajor(user,major);
        }else {
            result=-1;
        }
        out.print(result);
    }

    @RequestMapping("deleteClass")
    public void deleteClass(Integer classId,HttpSession session,PrintWriter out){
        int result=1;
        Classes classes=classesDao.getById(classId);
        if (classes!=null){
            classesDao.delete(classId);
            Integer userId=(Integer)session.getAttribute("userId");
            User user=userDao.getById(userId);
            publishLogDao.deleteClasses(user,classes);
        }else {
            result=-1;
        }
        out.print(result);
    }
    @RequestMapping("publishLog")
    public String publishLog(int page,Model model){
        int total=publishLogDao.getSize();
        PageBean pageBean=PageBean.getInstance(page,total,"/mana","/publishLog");
        List<PublishLog>list=publishLogDao.findByPage(pageBean.getCurPage(),pageBean.getPerPage());
        model.addAttribute("list",list);
        model.addAttribute("pageBean",pageBean);
        return "View/mana/publishLog";
    }
}
