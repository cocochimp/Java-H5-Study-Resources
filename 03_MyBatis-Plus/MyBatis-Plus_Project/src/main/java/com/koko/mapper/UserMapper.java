package com.koko.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.koko.pojo.User;
import org.springframework.stereotype.Repository;

//在对应的mapper上面继承基本的类 BaseMapper
@Repository//代表持久层
public interface UserMapper extends BaseMapper<User> {
    //所有CRUD操作都已经编写完成了
    //你不需要向以前一样配置一大堆文件了!
}

