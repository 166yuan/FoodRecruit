package com.recruit.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruit.Dao.HomeDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class LoginController {
    @RequestMapping("/hello")
    public String sayHello(HttpServletRequest request){
        return "/View/home/login";
    }
    @RequestMapping("/login")
    public String login(String username,String password,HttpServletRequest request){

    System.out.println(request.toString());
        int temp=HomeDao.findUser(username,password);
       if (temp>=1)
       {    request.setAttribute("username",username);
           return "/View/home/myspace";
       }
        else{
           return  "/View/home/error";
       }
    }
    @RequestMapping("/register")
    public String register(String account,String password,HttpServletRequest request){
        try{
            HomeDao.addUser(account,password);
            request.setAttribute("username",account);
            return "/View/home/myspace";
        }catch (Exception e){
            e.printStackTrace();

        }
        return  "/View/home/error";
    }
}