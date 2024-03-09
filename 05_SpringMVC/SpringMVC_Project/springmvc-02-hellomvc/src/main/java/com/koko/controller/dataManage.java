package com.koko.controller;

import com.koko.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class dataManage {

    @RequestMapping("/test1")
    public String hello(@RequestParam("username") String name){
        System.out.println(name);
        return "hello";
    }

    @RequestMapping("/test2")
    public String user(User user){
        System.out.println(user);
        return "hello";
    }

    @RequestMapping("/test3")
    public String test(Model model, String name){
        model.addAttribute("msg",name); //获取表单提交的值
        return "hello"; //跳转到test页面显示输入的值
    }
}
