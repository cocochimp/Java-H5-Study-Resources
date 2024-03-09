package com.koko.mapper;

import com.koko.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper : 表示本类是一个 MyBatis 的 Mapper
@Mapper
@Repository
public interface UserMapper {

    //获取所有员工信息
    List<User> getUser();

    //查询员工
    User getUserById(Integer id);

    //增加员工
    int addUser(User user);

    //修改员工
    int updateUser(User user);

    //删除员工
    int deleteUser(int id);

}
