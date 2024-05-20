package com.koko.mapper;

import com.koko.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper//这个注解表示了这是一个mybatis的mapper类
@Repository
public interface UserMapper {

    public User queryUserByName(String name);

}

