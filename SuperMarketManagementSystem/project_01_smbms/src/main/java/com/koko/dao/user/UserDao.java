package com.koko.dao.user;

import com.koko.pojo.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao{
    //得到要登录的用户
    public User getLoginUser(Connection connection, String userCode) throws SQLException;

    //修改当前用户密码
    public int updatePwd(Connection connection,int id,String password) throws SQLException;

    //根据用户名或者角色查询用户总数
    public int getUserCount(Connection connection,String username ,int userRole)throws SQLException, Exception;

    //通过条件查询-userList
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize)throws Exception;

}