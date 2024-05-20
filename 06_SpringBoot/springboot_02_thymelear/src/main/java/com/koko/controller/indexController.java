package com.koko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

@Controller
public class indexController {

    @RequestMapping("/h1")
    public String test01(Model model){
        //存数据
        model.addAttribute("msg","Hello,Thymeleaf");
        //classpath:/templates/index.html
        return "index";
    }

    @RequestMapping("/t2")
    public String test2(Map<String,Object> map){
        //存入数据
        map.put("msg","<h1>Hello</h1>");
        map.put("users", Arrays.asList("koko01","koko02"));
        //classpath:/templates/test.html
        return "index";
    }

}
