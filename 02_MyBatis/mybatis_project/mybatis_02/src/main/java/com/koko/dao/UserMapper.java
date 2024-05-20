package com.koko.dao;

import com.koko.pojo.User;
import java.util.List;

public interface UserMapper {
    List<User> getUserList();

    //查询用户
    User getUserById(int id);

    //添加用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);

}