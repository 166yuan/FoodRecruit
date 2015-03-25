package com.recruit.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import com.recruit.base.BaseController;
import com.recruit.impl.ClassesImpl;
import com.recruit.impl.MajorImpl;
import com.recruit.impl.NotificationImpl;
import com.recruit.impl.UserImpl;
import com.recruit.model.Classes;
import com.recruit.model.Major;
import com.recruit.model.Notification;
import com.recruit.model.User;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Yuan
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    public static final int SUCCESS = 1;
    public static final int FAILURE = -1;
    public static final int ADMIN=2;
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

    //---------------------------------- 登录注册 ----------------------------------
    //---------------------------------- 登录注册 ----------------------------------

    /**-----------------------
     *  跳转到登录页面
     */
    @RequestMapping("/login")
    public String sayHello(HttpServletRequest request){
        return "/View/user/login";
    }

    /**-----------------------
     *  进行登录认证
     */
    @RequestMapping("/doLogin")
    public void login(String account,String password,HttpServletRequest request,PrintWriter out){
        int result = 0;
        Integer userId=(Integer)request.getSession().getAttribute("userId");
        if(userId!=null){
            result=3;
        }else {
            try {
                User user=userDao.forAccount(account);
                if (user != null){
                    if(user.getStatus() != 1){
                        result = -2;
                    }else {
                        if (user.getPassword().equals(password)) {
                            result = SUCCESS;
                            request.getSession().setAttribute("account", account);
                            request.getSession().setAttribute("userId",user.getId());
                            request.getSession().setAttribute("user_type",user.getType());
                            request.getSession().setAttribute("imageUrl",user.getImage_url());
                            if(user.getType()==3){
                                result=ADMIN;
                            }
                        } else {
                            result = FAILURE;
                        }
                    }
                }else {
                    result = FAILURE;
                }

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        out.print(result);
    }


    /**-----------------------
     * 登出
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().setAttribute("account",null);
        request.getSession().removeAttribute("userId");
        return "redirect:/user/login";
    }

    /**------------------------
     * 注册处理
     *
     * @param account   注册帐号
     * @param password  注册密码
     * @param out
     */
    @RequestMapping("/register")
    public void register(String account,String password,HttpSession session,PrintWriter out){
        int result = 0;
        try{
            User user = userDao.forAccount(account);
            if (user == null) {
                result = SUCCESS;
                user=userDao.create(account,password);
                userDao.save(user);
                Integer userId=(Integer)session.getAttribute("userId");
                if (userId!=null){
                    User operator=userDao.getById(userId);
                    if(operator.getType()==3){
                        publishLogDao.addUser(operator,user);
                    }
                }
                publishLogDao.addUser(user);
            }else {
                result = FAILURE;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        out.print(result);
    }


    @RequestMapping("home")
    public String home(HttpServletRequest request,Model model){
        return "View/user/myspace";
    }

    /**-----------------------
     * 修改密码
     * @param password 旧密码
     * @param newPass  新密码
     * @param request
     * @param out
     */
    @RequestMapping("passwd")
    public void passwd(String password,String newPass,HttpServletRequest request,PrintWriter out){
        int result = 0;
        try {
            String account = (String)request.getSession().getAttribute("account");
            User user = userDao.forAccount(account);
            if (!user.getPassword().equals(password)){
                result = FAILURE;
            }else {
                user.setPassword(newPass);
                userDao.update(user);
                result = SUCCESS;
                publishLogDao.updateUser(user);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        out.print(result);
    }

    //---------------------------------- 个人信息 ----------------------------------
    //---------------------------------- 个人信息 ----------------------------------

    /**
     * 更新个人资料
     * @param request
     * @param out
     */
    @RequestMapping("/updateProfile")
    public void updateProfile(HttpServletRequest request,PrintWriter out){
        int result = 0;
        User u=new User();
        try {
            String account = (String)request.getSession().getAttribute("account");
            u=userDao.forAccount(account);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            JSONObject j = createJson(request);
            Major major=new Major();
            u.setName(j.getString("name"));
            try {
                major=majorDao.getById(j.getInt("major"));
            }catch (Exception e){
                e.printStackTrace();
            }
            u.setMajor(major);
            Classes classes=new Classes();
            try{
                System.out.println("class:"+j.get("classes"));
                classes=classesDao.getById(j.getInt("classes"));
            }catch (Exception e){
                e.printStackTrace();
            }
            u.setClasses(classes);
            u.setGender(j.getBoolean("gender"));
            u.setSelf_info(j.getString("self_info"));
            u.setEmail(j.getString("email"));
            u.setPhone(j.getString("phone"));
            u.setQq(j.getString("QQ"));
            userDao.update(u);
            result = SUCCESS;
            publishLogDao.updateUser(u);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        out.print(result);
    }

    /**
     * 获取个人资料
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/getProfile")
    public String getProfile(HttpServletRequest request,Model model){
        Integer id=(Integer)request.getSession().getAttribute("userId");
        User user=null;
        List<Classes> classesList=new ArrayList<Classes>();
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
        return "/View/user/profile";
    }


    //---------------------------------- 头像上传 ----------------------------------
    //---------------------------------- 头像上传 ----------------------------------

    /**
     * 上传图片
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("/upload")
    public String update3(DefaultMultipartHttpServletRequest request,HttpSession session){
        CommonsMultipartFile file=(CommonsMultipartFile)request.getFile("file");
        if(file.isEmpty()){
            return null;
        }
        String fileName =request.getRealPath("/images/")+File.separator+System.currentTimeMillis()+file.getOriginalFilename().
                substring(file.getOriginalFilename().lastIndexOf("."));
        File uploadFile = new File(fileName);
        try{
            FileCopyUtils.copy(file.getBytes(),uploadFile);
        }catch (Exception e){
            e.printStackTrace();
        }

        String account = (String)request.getSession().getAttribute("account");
        try{
            User user = userDao.forAccount(account);
            if(user!=null){
                user.setImage_url("/images/"+uploadFile.getName());
                userDao.update(user);
                request.getSession().setAttribute("imageUrl",user.getImage_url());
                publishLogDao.updateUser(user);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/user/getProfile";
    }


    //---------------------------------- 信息反馈 ----------------------------------
    //---------------------------------- 信息反馈 ----------------------------------

    /**
     * 跳转反馈页面
     * @return
     */
    @RequestMapping("feedback")
    public String feedback(){
    return "View/user/feedBack";
    }

    /**
     * 添加反馈
     * @param info
     * @param request
     * @return
     */
    @RequestMapping("addfeedback")
    public String addfeedBack(String info,HttpServletRequest request){
        User user=new User();
        Integer userId=(Integer)request.getSession().getAttribute("userId");
        try{
            user=userDao.getById(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            Notification notification=new Notification();
            notification.setType(3);
            notification.setInfo(info);
            notification.setCreator(user);
            notificationDao.save(notification);
        }catch (Exception e){
        e.printStackTrace();
        }
        return "View/user/infoSuccess";
    }

}