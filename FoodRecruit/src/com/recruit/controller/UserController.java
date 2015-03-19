package com.recruit.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


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
        UserImpl uml= UserImpl.getInstance();
        int result = 0;
        Integer userId=(Integer)request.getSession().getAttribute("userId");
        if(userId!=null){
            result=3;
        }else {
            try {
                uml.startTransaction();
                User user=uml.forAccount(account);
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
            }finally {
                uml.commitTransaction();
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
    public void register(String account,String password,PrintWriter out){
        UserImpl uml=UserImpl.getInstance();
        int result = 0;
        try{
            uml.startTransaction();
            User user = uml.forAccount(account);
            if (user == null) {
                result = SUCCESS;
                user=uml.create(account,password);
                uml.save(user);
            }else {
                result = FAILURE;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
           uml.commitTransaction();
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
        UserImpl uml = UserImpl.getInstance();
        int result = 0;
        try {
            uml.startTransaction();
            String account = (String)request.getSession().getAttribute("account");
            User user = uml.forAccount(account);
            if (!user.getPassword().equals(password)){
                result = FAILURE;
            }else {
                user.setPassword(newPass);
                result = SUCCESS;
            }
            uml.commitTransaction();
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
        UserImpl uml=UserImpl.getInstance();
        MajorImpl mml=MajorImpl.getInstance();
        ClassesImpl cml=ClassesImpl.getInstance();
        int result = 0;
        User u=new User();
        try {
            uml.startTransaction();
            String account = (String)request.getSession().getAttribute("account");
            u=uml.forAccount(account);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            uml.commitTransaction();
        }

        try {
            JSONObject j = createJson(request);
            Major major=new Major();
            u.setName(j.getString("name"));
            try {
                mml.startTransaction();
                major=mml.getById(j.getInt("major"));
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                mml.commitTransaction();
            }
            u.setMajor(major);
            Classes classes=new Classes();
            try{
                cml.startTransaction();
                classes=cml.getById(j.getInt("classes"));
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                cml.commitTransaction();
            }
            u.setClasses(classes);
            u.setGender(j.getBoolean("gender"));
            u.setSelf_info(j.getString("self_info"));
            u.setEmail(j.getString("email"));
            u.setPhone(j.getString("phone"));
            u.setQq(j.getString("QQ"));
            uml.startTransaction();
            uml.update(u);

            result = SUCCESS;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            uml.commitTransaction();
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
        UserImpl uml=UserImpl.getInstance();
        User user=new User();
        try {
            uml.startTransaction();
            String account = (String)request.getSession().getAttribute("account");
            user = uml.forAccount(account);
            //去除hibernate延迟加载取数据，下面两条一定要
            uml.Instance(user);

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            uml.commitTransaction();
        }
        model.addAttribute("user", user);
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
        UserImpl uml=UserImpl.getInstance();
        try{
            uml.startTransaction();
            User user = uml.forAccount(account);
            if(user!=null){
                user.setImage_url("/images/"+uploadFile.getName());
                user.getMajor().getMajorName();
                user.getClasses().getClassName();
                model.addAttribute("user",user);
                request.getSession().setAttribute("imageUrl",user.getImage_url());
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            uml.commitTransaction();
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
        NotificationImpl nml=NotificationImpl.getInstance();
        UserImpl uml=UserImpl.getInstance();
        User user=new User();
        Integer userId=(Integer)request.getSession().getAttribute("userId");
        try{
            uml.startTransaction();
            user=uml.getById(userId);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            uml.commitTransaction();
        }

        try{
            nml.startTransaction();
            Notification notification=new Notification();
            notification.setType(3);
            notification.setInfo(info);
            notification.setReceiver(user);
            nml.save(notification);

        }catch (Exception e){
        e.printStackTrace();
        }finally {
            nml.commitTransaction();
        }
        return "View/user/infoSuccess";
    }

}