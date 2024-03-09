package com.koko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestFulController {

    //http://localhost:8080/add1/1/3
    @GetMapping("/add1/{a}/{b}")
    public String test1(@PathVariable int a, @PathVariable String b, Model model){
        String res=a+b;
        model.addAttribute("msg","结果1为"+res);
        return "hello";
    }

    //映射访问路径,必须是Get请求
    @RequestMapping(value = "/add2/{a}/{b}",method = {RequestMethod.GET})
    public String index2(@PathVariable int a, @PathVariable String b, Model model){
        String res=a+b;
        model.addAttribute("msg","结果2为"+res);
        return "hello";
    }

    //转发
    @RequestMapping("/test1")
    public String test1(Model model){
        //转发
        model.addAttribute("msg","转发");
        return "hello";
    }

    //重定向
    @RequestMapping("/test2")
    public String test2(){
        //重定向
        return "redirect:/index.jsp";
    }

}
