package com.koko.controller;

import com.koko.mapper.UserMapper;
import com.koko.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/getUser")
    public List<User> getUser(){
        return userMapper.getUser();
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable("id")int id){
        return userMapper.getUserById(id);
    }

    @GetMapping("/addUser")
    public String addUser(){
        userMapper.addUser(new User(5,"小小","123456"));
        return "ok";
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(5,"大大","123456"));
        return "ok";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(){
        userMapper.deleteUser(5);
        return "ok";
    }

}
