package com.recruit.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        String result="尼玛这是测试啊";
        request.setAttribute("test",result);
        return "/View/home/login";
    }
    @RequestMapping("/login")
    public String login(String username,String password,HttpServletRequest request){

    System.out.println(request.toString());

       if (username.equals("123")&&password.equals("1234"))
       {    request.setAttribute("username",username);
           return "/View/home/success";}

        else{
           return  "/View/home/error";
       }
    }
}