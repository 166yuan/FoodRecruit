package com.recruit.controller;

import com.recruit.base.BaseController;
import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2015/3/13.
 */

@Controller
@RequestMapping("home")
public class HomeController extends BaseController {
    @RequestMapping("index")
    public String index(Model model){

    model.addAttribute("test","me");
    return "index2";
    }

    @RequestMapping("login")
    public String login(HttpServletRequest request){
        Cookie[]cookies=request.getCookies();
        boolean islogin=false;
        for (int i=0;i<cookies.length;i++){
            System.out.println("cookie:"+cookies[i].getName());
            if (cookies[i].getName().equals("userLogin")){

                islogin=true;
                break;
            }
        }
        if (islogin==false){
            return "View/user/login";
        }else {
            return "redirect:/user/home";
        }
    }
}
