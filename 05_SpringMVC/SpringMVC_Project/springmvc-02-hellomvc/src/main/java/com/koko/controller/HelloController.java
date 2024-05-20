package com.koko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/Hello")
public class HelloController {

    //真实访问地址 : 项目名/Hello/h1
    @RequestMapping("/h1")
    public String sayHello(Model model) {
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg", "hello,SpringMVC");
        return "hello";//会被视图解析器处理；
    }

}
