package com.recruit.user.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import com.recruit.notification.dao.NotificationDao;
import com.recruit.notification.model.Notification;
import com.recruit.user.Dao.UserDao;
import com.recruit.user.model.User;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import java.io.*;

/*
 * @author Yuan
 */
@Controller
@RequestMapping("/user")
public class UserController {
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
        UserDao userDao = UserDao.getInstance();
        int result = 0;
        try {
            userDao.begin();
            User user = userDao.forAccount(account);
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
            userDao.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            userDao.close();
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
    public void register(String account,String password,PrintWriter out){
        UserDao userDao = UserDao.getInstance();
        int result = 0;
        try{
            userDao.begin();
            User user = userDao.forAccount(account);
            if (user == null) {
                result = SUCCESS;
                userDao.create(account, password);
            }else {
                result = FAILURE;
            }
            userDao.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            userDao.close();
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
        UserDao userDao = UserDao.getInstance();
        int result = 0;
        try {
            userDao.begin();

            String account = (String)request.getSession().getAttribute("account");
            User user = userDao.forAccount(account);

            if (!user.getPassword().equals(password)){
                result = FAILURE;
            }else {
                user.setPassword(newPass);
                result = SUCCESS;
            }

            userDao.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            userDao.close();
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
        UserDao userDao = UserDao.getInstance();
        int result = 0;
        try {
            userDao.begin();
            String account = (String)request.getSession().getAttribute("account");
            User u = userDao.forAccount(account);
            JSONObject j = createJson(request);

            u.setName(j.getString("name"));
            u.setMajor(j.getString("major"));
            u.setClasses(j.getString("classes"));
            u.setGender(j.getInt("gender"));
            u.setSelf_info(j.getString("self_info"));
            u.setEmail(j.getString("email"));
            u.setPhone(j.getString("phone"));
            u.setQq(j.getString("QQ"));

            result = SUCCESS;

            userDao.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            userDao.close();
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
        UserDao userDao = UserDao.getInstance();
        try {
            userDao.begin();
            String account = (String)request.getSession().getAttribute("account");
            User user = userDao.forAccount(account);
            model.addAttribute("user",user);
            userDao.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            userDao.close();
        }
        return "/View/user/profile";
    }


    //---------------------------------- 头像上传 ----------------------------------
    //---------------------------------- 头像上传 ----------------------------------

    /**
     * 上传图片
     * @param request
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/upload")
    public String update3(DefaultMultipartHttpServletRequest request,HttpSession session,Model model){
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
        UserDao userDao=UserDao.getInstance();
        try{
            userDao.begin();
            User user = userDao.forAccount(account);
            if(user!=null){
                user.setImage_url("/images/"+uploadFile.getName());
                model.addAttribute("user",user);
                request.getSession().setAttribute("imageUrl",user.getImage_url());
            }
            userDao.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            userDao.close();
        }
        return "/View/user/profile";
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
        NotificationDao notificationDao=NotificationDao.getInstance();
        UserDao userDao=UserDao.getInstance();
        String account = (String)request.getSession().getAttribute("account");
        User user = userDao.forAccount(account);
        try{
            notificationDao.begin();
            Notification notification=new Notification();
            notification.setType(3);
            notification.setInfo(info);
            notification.setUserId(user.getId());
            notificationDao.save(notification);
            notificationDao.commit();
        }catch (Exception e){
        e.printStackTrace();
        }finally {
        notificationDao.close();
        }
        return "View/user/infoSuccess";
    }

}