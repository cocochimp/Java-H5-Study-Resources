package com.koko.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {

    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    //静态代码块，类加载的时候就初始化了
    static{
        Properties properties = new Properties();
        //通过类加载器读取对应的资源
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");

        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    //获取数据库的连接
    public static Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName(driver);
            connection=DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    //编写查询公共类
    public static ResultSet execute(Connection con,ResultSet res, PreparedStatement prs, String sql, Object[] params) throws SQLException {
        //预编译的sql，在后面直接执行就可以了
        prs=con.prepareStatement(sql);

        for(int i=0;i< params.length;i++){
            //setObject,占位符从1开始，数组从0开始
            prs.setObject(i+1,params[i]);
        }

        res=prs.executeQuery();
        return res;
    }

    //编写增删改公共类
    public static int execute(Connection con, PreparedStatement pstm,String sql, Object[] params) throws SQLException {
        int updateRows=0;
        pstm=con.prepareStatement(sql);

        for(int i=0;i< params.length;i++){
            //setObject,占位符从1开始，数组从0开始
            pstm.setObject(i+1,params[i]);
        }

        updateRows = pstm.executeUpdate();
        return updateRows;
    }

    //释放资源
    public static boolean closeResource(Connection con,PreparedStatement prs,ResultSet res){
        boolean flag=true;

        if(res!=null){
            try {
                res.close();
                res=null;//GC回收
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag=false;
            }
        }

        if(con!=null){
            try {
                con.close();
                con=null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag=false;
            }
        }

        if(prs!=null){
            try {
                prs.close();
                prs=null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag=false;
            }
        }
        return flag;
    }

}
