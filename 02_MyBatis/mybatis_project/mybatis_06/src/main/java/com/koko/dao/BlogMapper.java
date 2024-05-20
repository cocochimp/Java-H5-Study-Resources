package com.koko.dao;

import com.koko.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据
    int addBlog(Blog blog);

    //查询博客if
    List<Blog> queryBlogIF(Map map);

    //查询博客choose
    List<Blog> queryBlogChoose(Map map);

    //修改博客trim
    int updateBlog(Map map);

    //查询1,2,3号记录的博客
    List<Blog> queryBlogForeach(Map map);
}
