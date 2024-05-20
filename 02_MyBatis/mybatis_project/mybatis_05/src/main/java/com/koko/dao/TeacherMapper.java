package com.koko.dao;

import com.koko.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {

    //获取指定老师下的所有学生和老师的信息
    Teacher getTeacher(@Param("tid")int id);
}
