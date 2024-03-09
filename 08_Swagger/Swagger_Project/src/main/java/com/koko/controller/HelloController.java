package com.koko.controller;

import com.koko.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "1、模块类")
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/user")
    public User user(){
        return new User();
    }

    @ApiOperation("2、接口方法")
    @GetMapping("/hello02")
    public String toHello02(@ApiParam("5、接口中的参数、方法和字段") String username){
        return "hello" + username;
    }

}
