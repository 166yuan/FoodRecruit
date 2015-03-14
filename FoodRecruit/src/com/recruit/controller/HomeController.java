package com.recruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2015/3/13.
 */

@Controller
@RequestMapping("home")
public class HomeController {
    @RequestMapping("index")
    public String index(Model model){

    model.addAttribute("test","me");
    return "index2";
    }
}
