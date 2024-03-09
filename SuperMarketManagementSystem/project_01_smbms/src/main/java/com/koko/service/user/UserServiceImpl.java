package com.koko.service.user;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.koko.dao.BaseDao;
import com.koko.dao.user.UserDao;
import com.koko.dao.user.UserDaoImpl;
import com.koko.pojo.User;
import org.junit.Test;

public class UserServiceImpl implements UserService{

    //业务层都会调用dao层，所以我们要引入Dao层
    private UserDao userDao;
    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }

    @Override
    //用户登录
    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;

        try {
            connection = BaseDao.getConnection();
            //通过业务层调用对应的具体数据库操作
            user = userDao.getLoginUser(connection, userCode);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        BaseDao.closeResource(connection, null, null);
        return user;
    }

    @Override
    //根据用户ID修改密码
    public boolean updatePwd(int id, String password) {
        // TODO 自动生成的方法存根
        Connection connection = null;
        boolean flag = false;
        //修改密码
        try {
            connection = BaseDao.getConnection();
            if(userDao.updatePwd(connection, id, password)>0) {
                flag = true;
            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);

        }
        return flag;
    }

    @Override
    //查询记录数
    public int getUserCount(String username, int userRole) {
        // TODO Auto-generated method stub
        Connection connection = null;
        int count = 0;

        System.out.println("queryUserName ---- > " + username);
        System.out.println("queryUserRole ---- > " + userRole);

        try {
            connection = BaseDao.getConnection();
            count = userDao.getUserCount(connection, username,userRole);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }

        return count;
    }

    @Override
    //根据条件查询用户列表
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<User> userList = null;

        System.out.println("queryUserName ---- > " + queryUserName);
        System.out.println("queryUserRole ---- > " + queryUserRole);
        System.out.println("currentPageNo ---- > " + currentPageNo);
        System.out.println("pageSize ---- > " + pageSize);

        try {
            connection = BaseDao.getConnection();
            userList = userDao.getUserList(connection, queryUserName,queryUserRole,currentPageNo,pageSize);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return userList;
    }


}