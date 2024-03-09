package com.koko.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class JdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/list")
    public List<Map<String, Object>> userList(){
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    //新增一个用户
    @GetMapping("/add")
    public String addUser(){
        //插入语句，注意时间问题
        String sql = "insert into user(id, name,pwd)" +
                " values (4,'赵六','123')";
        jdbcTemplate.update(sql);

        //查询
        return "add_ok";
    }

    //修改用户信息
    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id){
        //插入语句，注意时间问题
        String sql = "update user set name=?,pwd=? where id="+id;

        //封装
        Object[] objects = new Object[2];
        objects[0]="小明";
        objects[1]="123456";
        jdbcTemplate.update(sql,objects);

        //查询
        return "update_ok";
    }

    //删除用户
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        //插入语句，注意时间问题
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql,id);

        //查询
        return "delete_ok";
    }

}
