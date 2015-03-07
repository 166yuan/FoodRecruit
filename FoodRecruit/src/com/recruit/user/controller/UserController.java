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

    @RequestMapping("/login")
    public String sayHello(HttpServletRequest request){
        return "/View/user/login";
    }

    @RequestMapping("/doLogin")
    public void login(String account,String password,HttpServletRequest request,PrintWriter out){
        UserDao userDao = UserDao.getInstance();
        int result = 0;
        try {
            userDao.begin();
            User user = userDao.forAccount(account);
            if (user != null){
                //    将account 改为 userId
                if(user.getStatus() != 1){
                    result = -2;
                }else {
                    if (user.getPassword().equals(password)) {
                        result = SUCCESS;
                        request.getSession().setAttribute("account", account);
                        request.getSession().setAttribute("userId",user.getId());
                        request.getSession().setAttribute("user_type",user.getType());
                        request.getSession().setAttribute("imageUrl",user.getImage_url());
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

    @RequestMapping("")
    public void m(PrintWriter out){
        UserDao userDao = UserDao.getInstance();
        int result = 0;
        try {
            userDao.begin();

            userDao.commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            userDao.close();
        }
        out.print(result);
    }
    @RequestMapping("home")
    public String home(HttpServletRequest request,Model model){
        return "View/user/myspace";
    }
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

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().setAttribute("account",null);
        return "redirect:/user/login";
    }
    @RequestMapping("/uploadImage")
    public  String uploadImage(){
        return "View/user/upload";
    }

    @RequestMapping("/upload")
    public String update3(DefaultMultipartHttpServletRequest request,HttpSession session,Model model){
        CommonsMultipartFile file=(CommonsMultipartFile)request.getFile("file");
        if(file.isEmpty()){
            return null;
        }
        String fileName =request.getRealPath("/images/")+File.separator+System.currentTimeMillis()+file.getOriginalFilename().
                substring(file.getOriginalFilename().lastIndexOf("."));
        File uploadFile = new File(fileName);
        System.out.println(uploadFile.getPath());
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

    @RequestMapping("feedback")
    public String feedback(){
    return "View/user/feedBack";
    }

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