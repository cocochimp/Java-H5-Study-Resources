# SuperMarketManagementSystem
* 基于JavaWeb的超市订单管理系统（狂神说）

> 展示最后效果（部分）

1. 首页

![首页](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202022-04-05%20221542.png)

2. 用户管理页

![屏幕截图 2022-04-05 221509](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202022-04-05%20221509.png)

3. 修改密码页

![屏幕截图 2022-04-05 221532](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202022-04-05%20221532.png)



## 1. 项目准备工作

> 1、项目设计流程图

![image-20220118092450453](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220118092450453.png)



### 1.1 数据库信息

> 1、数据库中所有的表

![image-20220120144456804](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120144456804.png)

> 2、所有表中的字段数据

![image-20220205155728656](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220205155728656.png)



### 1.2 搭建项目准备工作

> 1、步骤

1. 搭建一个maven web 项目

![image-20220120142622951](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120142622951.png)

2. web.xml

~~~properties
<?xml version="1.0" encoding="UTF-8"?>

<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

</web-app>
~~~

3. 导入Maven依赖

```xml
<!--jdk发行版本-->
    <properties>
            <java.version>16</java.version>
            <maven.compiler.source>${java.version}</maven.compiler.source>
            <maven.compiler.target>${java.version}</maven.compiler.target>
        </properties>

<dependencies>
    <!--1、连接数据库依赖-->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.16</version>
    </dependency>

    <!--2、Servlet依赖-->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>servlet-api</artifactId>
      <version>2.5</version>
    </dependency>

    <!--3、Junit单元测试-->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
    </dependency>

    <!--4、JSP依赖-->
    <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>javax.servlet.jsp-api</artifactId>
      <version>2.3.3</version>
    </dependency>

    <!--5、JSTL表达式依赖-->
    <dependency>
      <groupId>javax.servlet.jsp.jstl</groupId>
      <artifactId>jstl-api</artifactId>
      <version>1.2</version>
    </dependency>

    <!--6、standard标签库依赖-->
    <dependency>
      <groupId>taglibs</groupId>
      <artifactId>standard</artifactId>
      <version>1.1.2</version>
    </dependency>
</dependencies>
```

> 2、配置Tomcat

![image-20220205155826918](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220205155826918.png)

* 测试项目是否能够跑起来

> 3、构建项目包结构

![image-20220118094504671](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220118094504671.png)

> 4、步骤

![image-20220120143624743](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120143624743.png)

1. 编写全局字符过滤器的类：CharacterEncodingFilter

~~~java
package com.koko.filter;

import javax.servlet.*;
import  java.io.IOException;

public class CharacterEncodingFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
~~~

2. web.xml编写字符编码过滤器

```xml
<!--1、字符编码过滤器-->
<filter>
    <filter-name>CharacterEncodingFilter</filter-name>
    <filter-class>com.koko.filter.CharacterEncodingFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>CharacterEncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

> 5、导入静态资源

![image-20220118095941181](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220118095941181.png)



### 1.3 数据库的预处理

> 1、步骤

1. 数据库配置文件

* mysql5.xx和8.xx的编写有差异

![image-20220119212141379](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220119212141379.png)

~~~properties
driver=com.mysql.cj.jdbc.Driver
#在和mysql传递数据的过程中，使用unicode编码格式，并且字符集设置为utf-8，设置时区
url=jdbc:mysql://localhost:3306/smbms?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC
username=root
password=123456
~~~

2. 编写数据库的公共类

![image-20220119212201676](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220119212201676.png)

~~~java
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
    public static int execute(Connection con, PreparedStatement prs,String sql, Object[] params) throws SQLException {
        prs=con.prepareStatement(sql);

        for(int i=0;i< params.length;i++){
            //setObject,占位符从1开始，数组从0开始
            prs.setObject(i+1,params[i]);
        }

        int updateRows = prs.executeUpdate();
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
~~~



### 1.4 编写数据库中的User实体类

> 1、步骤

![image-20220120144640492](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120144640492.png)

1. User实体类编写

~~~java
package com.koko.pojo;

import java.util.Date;

public class User {
    private Integer id; //id
    private String userCode; //用户编码
    private String userName; //用户名称
    private String userPassword; //用户密码
    private Integer gender;  //性别
    private Date birthday;  //出生日期
    private String phone;   //电话
    private String address; //地址
    private Integer userRole;    //用户角色
    private Integer createdBy;   //创建者
    private Date creationDate; //创建时间
    private Integer modifyBy;     //更新者
    private Date modifyDate;   //更新时间

    @SuppressWarnings("unused")
    private Integer age;//年龄

    private String userRoleName;    //用户角色名称


    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public Integer getAge() {
		/*long time = System.currentTimeMillis()-birthday.getTime();
		Integer age = Long.valueOf(time/365/24/60/60/1000).IntegerValue();*/
        Date date = new Date();
        @SuppressWarnings("deprecation")
        Integer age = date.getYear() - birthday.getYear();
        return age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
~~~





## 2. 登录功能实现

> 1、功能开发流程图

![image-20220118102114338](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220118102114338.png)



### 2.1 设置欢迎页面

> 1、步骤

1. 导入login.jsp

![image-20220119123744525](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220119123744525.png)

~~~xml
<!--2、设置欢迎页面-->
    <welcome-file-list>
        <welcome-file>login.jsp</welcome-file>
    </welcome-file-list>
~~~

2. 导入其他前端文件

![image-20220120144901712](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120144901712.png)



### 2.2 Dao层的处理

> 1、步骤

1. 编写dao层登录用户登录的接口

![image-20220120145125407](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120145125407.png)

~~~java
package com.koko.dao.user;

import com.koko.pojo.User;
import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao{
    //得到要登录的用户
    public User getLoginUser(Connection connection, String userCode) throws SQLException;
}
~~~

2. 编写dao层接口的实现类

![image-20220120145136767](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120145136767.png)

~~~java
package com.koko.dao.user;

import com.koko.dao.BaseDao;
import com.koko.pojo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{
    @Override
    //得到要登录的用户
    public User getLoginUser(Connection connection, String userCode) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;

        if (connection != null) {
            String sql = "select * from smbms_user where userCode=?";
            Object[] params = {userCode};
            rs = BaseDao.execute(connection, rs, pstm, sql, params);

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return user;
    }
}
~~~



### 2.3 Service层的处理

>1、步骤

1. 业务层接口

![image-20220120145614064](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120145614064.png)

~~~java
package com.koko.service;

import com.koko.pojo.User;

public interface UserService {
    //用户登录
    public User login(String userCode, String password);
}
~~~

2. 业务层实现类

![image-20220120145631020](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120145631020.png)

~~~java
package com.koko.service.user;
import java.sql.Connection;

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

    @Test
    public void test() {
        UserServiceImpl userService = new UserServiceImpl();
        String userCode = "admin";
        String userPassword = "111111";
        User admin = userService.login(userCode, userPassword);
        System.out.println(admin.getUserPassword());
    }

}
~~~



### 2.4 Servlet层的处理

>1、步骤

1. 事先编写好常量类(好习惯)

![image-20220120152941875](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120152941875.png)

~~~java
package com.koko.util;

public class Constants {
    public final static String USER_SESSION="userSession";
}
~~~

2. 编写Servlet

![image-20220119201508843](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220119201508843.png)

~~~java
package com.koko.servlet.user;

import com.koko.pojo.User;
import com.koko.service.user.UserService;
import com.koko.service.user.UserServiceImpl;
import com.koko.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    //Servlet:控制层，调用业务层代码

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet--start....");

        //获取用户名和密码
        String userCode=req.getParameter("userCode");
        String userPassword=req.getParameter("userPassword");

        //和数据库中的密码进行对比，调用业务层
        UserService userService=new UserServiceImpl();
        User user=userService.login(userCode,userPassword);//查出登录的人

        if(user.getUserPassword().equals(userPassword){
            //将用户的信息放在Session中
            req.getSession().setAttribute(Constants.USER_SESSION,user);
            //跳转到页面
            resp.sendRedirect("jsp/frame.jsp");
        }else{//查无此人
            //转发回登录页面，顺带提示它，用户名或者密码错误
            req.setAttribute("error","用户名或者密码不正确");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
~~~

3. 注册web.xml

![image-20220119201535387](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220119201535387.png)

~~~xml
<!--3、进入主页-->
    <servlet>
        <servlet-name>LoginServlet</servlet-name>
        <servlet-class>com.koko.servlet.user.LoginServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>LoginServlet</servlet-name>
        <url-pattern>/login.do</url-pattern>
    </servlet-mapping>
~~~



## 3. 登录功能优化

### 3.1 注销功能

>1、步骤

1. 思路：移除Session，返回登录页面

![image-20220120111450752](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120111450752.png)

~~~java
package com.koko.servlet.user;

import com.koko.util.Constants;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //移除用户的Session
        req.getSession().removeAttribute(Constants.USER_SESSION);
        resp.sendRedirect(req.getContextPath()+"/login.jsp");//返回登录页面
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
~~~

2. 注册web.xml

~~~xml
<!--4、返回登录页面-->
    <servlet>
        <servlet-name>LogoutServlet</servlet-name>
        <servlet-class>com.koko.servlet.user.LogoutServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>LogoutServlet</servlet-name>
        <url-pattern>/jsp/logout.do</url-pattern>
    </servlet-mapping>
~~~



### 3.2 登录拦截

>1、步骤

1. 编写一个过滤器，并注册

![image-20220120111518524](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120111518524.png)

~~~java
package com.koko.filter;

import com.koko.pojo.User;
import com.koko.util.Constants;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SysFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException{

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        // TODO 自动生成的方法存根
        HttpServletRequest request =  (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        //过滤器，从session中获取用户
        User user = (User)request.getSession().getAttribute(Constants.USER_SESSION);
        if(user == null){//已经被移除或者注销了，或者未登录
            response.sendRedirect("/smbms/error.jsp");
        }else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
        // TODO 自动生成的方法存根

    }
}
~~~

注：error.jsp页面

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120112735827.png" alt="image-20220120112735827" style="zoom:75%;" />

2. 注册xml

~~~xml
<!--5、用户登录过滤器 -->
    <filter>
        <filter-name>SysFilter</filter-name>
        <filter-class>com.koko.filter.SysFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>SysFilter</filter-name>
        <url-pattern>/jsp/*</url-pattern>
    </filter-mapping>
~~~

> 2、测试

![image-20220122121148222](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122121148222.png)



## 4. 密码修改实现

### 4.1 功能开发流程图

>1、原理图

1. 企业级开发时，应该遵循“自底向上”的实现方法

![image-20220120173913230](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120173913230.png)

* 三层架构：Dao—>Service—>Servlet

> 2、导入前端资源

![image-20220120173850375](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120173850375.png)



### 4.2 Dao层的处理

>1、步骤

1. UserDao接口

![image-20220120175630731](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120175630731.png)

~~~java
    //修改当前用户密码
    public int updatePwd(Connection connection,int id,String password) throws SQLException;
~~~

2. UserDao接口实现类

![image-20220120175726399](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120175726399.png)

~~~java
@Override
//修改当前用户密码
    public int updatePwd(Connection connection, int id, String password) throws SQLException {
        // TODO 自动生成的方法存根
        PreparedStatement pstm = null;
        int execute =0;
        if(connection!=null) {
            String sql = "update smbms_user set userPassword = ? where id = ?";
            Object[] params = {password,id};
            execute = BaseDao.execute(connection, pstm, sql, params);
            BaseDao.closeResource(null, pstm, null);
        }
        return execute;
    }
~~~



### 4.3 Service层的处理

>1、步骤

1. UserService接口

~~~java
    //根据用户ID修改密码
    public boolean updatePwd(int id,String password);
~~~

2. UserService接口实现类

~~~java
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
~~~



### 4.4 Servlet层的处理

>1、步骤

1. 处理前端数据

* 导入前端资源

![image-20220120215310619](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120215310619.png)

* 在js包下对pwdmodify.js进行处理

![image-20220120215359808](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120215359808.png)

* 将旧密码一筐先注释（后面再验证）

![image-20220120215433320](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120215433320.png)

> 2、测试

![image-20220120215553215](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220120215553215.png)

> 3、步骤

1. UserServlet

~~~java
package com.koko.servlet.user;

import com.koko.pojo.User;
import com.koko.service.user.UserService;
import com.koko.service.user.UserServiceImpl;
import com.koko.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO 自动生成的方法存根
        String method = req.getParameter("method");
        //实现复用~~~~~~
        if (method.equals("savepwd")) {
            this.updatePwd(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO 自动生成的方法存根
        doGet(req, resp);
    }

    //封装
    public void updatePwd(HttpServletRequest req, HttpServletResponse resp) {
        // 通过session获得用户id
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        String newpassword = req.getParameter("newpassword");
        boolean flag = false;

        if (o != null && newpassword != null) {
            UserService userService = new UserServiceImpl();
            flag = userService.updatePwd(((User) o).getId(), newpassword);

            if (flag) {
                req.setAttribute("message", "密码修改成功，请退出，使用新密码登录");
                // 密码修改成功,移除session(移除后不能再次修改密码,建议不移除)
                req.getSession().removeAttribute(Constants.USER_SESSION);
            } else {
                // 密码修改失败
                req.setAttribute("message", "密码修改失败");
            }
        } else {
            // 密码修改有问题
            req.setAttribute("message", "新密码有问题");
        }
        try {
            req.getRequestDispatcher("pwdmodify.jsp").forward(req, resp);
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
}
~~~

2. 注册web.xml

~~~xml
<!--6、更改密码-->
    <servlet>
        <servlet-name>UserServlet</servlet-name>
        <servlet-class>com.koko.servlet.user.UserServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>UserServlet</servlet-name>
        <url-pattern>/jsp/user.do</url-pattern>
    </servlet-mapping>
~~~

> 4、运行

![image-20220122121058349](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122121058349.png)



##  5. 优化密码修改

**注：使用Ajax**

### 5.1 前期准备

>1、步骤

1. maven配置

~~~xml
<!--7、阿里巴巴的fastjson-->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>fastjson</artifactId>
        <version>1.2.68</version>
    </dependency>
~~~

2. 更改前端代码

![image-20220121104229478](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220121104229478.png)

3. 注册xml

~~~xml
<!--7、默认Session过期时间-->
    <session-config>
        <session-timeout>30</session-timeout>
    </session-config>
~~~



### 5.2 Servlet层的处理

>1、步骤

1. UserServlet层的处理

* **添加多一个判断条件**

![image-20220121163249823](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220121163249823.png)

* **添加一个新方法**

~~~java
 //验证旧密码
    public void pwdModify(HttpServletRequest req,HttpServletResponse resp){
        // 通过session获得用户id
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        String oldpassword = req.getParameter("oldpassword");

        //万能的Map，结果集
        Map<String, String> resultMap = new HashMap<>();

        if(o==null) {//session失效，session过期了
            resultMap.put("result","sessionerror");
        }else if(StringUtils.isNullOrEmpty(oldpassword)){//输入密码为空
            resultMap.put("result","error");
        }else {
            String userPassword = ((User)o).getUserPassword();//seesion中的用户密码
            if(oldpassword.equals(userPassword)) {
                resultMap.put("result","true");
            }else {
                resultMap.put("result","false");
            }
        }

        try {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            /*
             resultMap = ["result","sessionerror","result",error]
             json格式={key,value}
            */
            writer.write(JSONArray.toJSONString(resultMap));
//            writer.write(JsonArray.class.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
~~~

> 2、测试

![image-20220122121012192](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122121012192.png)



### 5.3 遇到的问题

> 1、前端传来的URL不能被接收（error：500）

![image-20220121162933616](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220121162933616.png)

**500问题太棘手，暂时不进行处理，后续再处理（无伤大雅）**



## 6. 用户管理实现

### 6.1 功能开发流程图

> 1、开发流程图

![image-20220121164551176](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220121164551176.png)

> 2、步骤

1. 前端资源导入

![image-20220121170323610](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220121170323610.png)

2. 工具类导入

![image-20220121170415524](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220121170415524.png)

~~~java
package com.koko.util;

public class PageSupport {
    //当前页码-来自于用户输入
    private int currentPageNo = 1;

    //总数量（表）
    private int totalCount = 0;

    //页面容量
    private int pageSize = 0;

    //总页数-totalCount/pageSize（+1）
    private int totalPageCount = 1;

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        if (currentPageNo > 0) {
            this.currentPageNo = currentPageNo;
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount > 0) {
            this.totalCount = totalCount;
            //设置总页数
            this.setTotalPageCountByRs();
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize > 0) {
            this.pageSize = pageSize;
        }
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public void setTotalPageCountByRs() {
        if (this.totalCount % this.pageSize == 0) {
            this.totalPageCount = this.totalCount / this.pageSize;
        } else if (this.totalCount % this.pageSize > 0) {
            this.totalPageCount = this.totalCount / this.pageSize + 1;
        } else {
            this.totalPageCount = 0;
        }
    }

}
~~~



### 6.2 获取用户数量

> 1、功能开发流程图

![image-20220122000426267](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122000426267.png)



#### 6.2.1 Dao层实现

>1、步骤

1. UserDao接口

~~~java
//根据用户名或者角色查询用户总数
public int getUserCount(Connection connection,String username ,int userRole)throws SQLException, Exception;
~~~

2. UserDaoImpl接口实现类

~~~java
@Override
//根据用户名或者角色查询用户总数
public int getUserCount(Connection connection, String username, int userRole) throws SQLException, Exception {
    PreparedStatement pstm = null;
    ResultSet rs = null;
    int count = 0;

    if(connection != null){
        StringBuffer sql = new StringBuffer();
        sql.append("select count(1) as count from smbms_user u,smbms_role r where u.userRole = r.id");
        List<Object> list = new ArrayList<>();

        if(!StringUtils.isNullOrEmpty(username)){
            sql.append(" and u.userName like ?");
            list.add("%"+username+"%"); //index:0
        }

        if(userRole > 0){
            sql.append(" and u.userRole = ?");
            list.add(userRole); //index:0
        }

        //将List转换成数组
        Object[] params = list.toArray();

        //输出完整的sql
        System.out.println("sql ----> " + sql.toString());

        rs = BaseDao.execute(connection, rs,pstm, sql.toString(), params);

        if(rs.next()){
            count = rs.getInt("count");//从结果集中获取最终的数量
        }
        BaseDao.closeResource(null, pstm, rs);
    }
    return count;
}
~~~



#### 6.2.2 Service层实现

>1、步骤

1. UserService接口

~~~java
//查询记录数
public int getUserCount(String username, int userRole);
~~~

2. UserServiceImpl接口实现类

~~~java
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
~~~



### 6.3 获取用户列表

> 1、功能开发流程图

![image-20220122102154364](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122102154364.png)



#### 6.3.1 Dao层实现

>1、步骤

1. UserDao接口

~~~java
//通过条件查询-userList
public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize)throws Exception;
~~~

2. UserDaoImpl接口实现类

~~~java
@Override
//通过条件查询-userList
public List<User> getUserList(Connection connection, String userName,int userRole,int currentPageNo, int pageSize) throws Exception {
    // TODO Auto-generated method stub
    PreparedStatement pstm = null;
    ResultSet rs = null;
    List<User> userList = new ArrayList<>();

    if(connection != null){
        StringBuffer sql = new StringBuffer();
        sql.append("select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id");
        List<Object> list = new ArrayList<Object>();

        if(!StringUtils.isNullOrEmpty(userName)){
            sql.append(" and u.userName like ?");
            list.add("%"+userName+"%");
        }
        if(userRole > 0){
            sql.append(" and u.userRole = ?");
            list.add(userRole);
        }

        //在数据库中，分页显示 limit startIndex，pageSize；总数
        //当前页  (当前页-1)*页面大小
        //0,5	1,0	 01234
        //5,5	5,0	 56789
        //10,5	10,0 10~

        sql.append(" order by creationDate DESC limit ?,?");
        currentPageNo = (currentPageNo-1)*pageSize;
        list.add(currentPageNo);
        list.add(pageSize);

        Object[] params = list.toArray();
        System.out.println("sql ----> " + sql.toString());

        rs = BaseDao.execute(connection, rs, pstm, sql.toString(), params);
        while(rs.next()){
            User _user = new User();
            _user.setId(rs.getInt("id"));
            _user.setUserCode(rs.getString("userCode"));
            _user.setUserName(rs.getString("userName"));
            _user.setGender(rs.getInt("gender"));
            _user.setBirthday(rs.getDate("birthday"));
            _user.setPhone(rs.getString("phone"));
            _user.setUserRole(rs.getInt("userRole"));
            _user.setUserRoleName(rs.getString("userRoleName"));
            userList.add(_user);
        }
        BaseDao.closeResource(null, pstm, rs);
    }
    return userList;
}
~~~



#### 6.3.2 Service层实现

>1、步骤

1. UserService接口

~~~java
//根据条件查询用户列表
public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize);
~~~

2. UserServiceImpl接口实现类

~~~java
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
~~~



### 6.4 获取角色操作

> 1、功能开发流程图

![image-20220122102257155](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122102257155.png)

> 2、前期准备

![image-20220122102405789](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122102405789.png)

**导入Role角色类**



#### 6.4.1 Dao层实现

>1、步骤

1. RoleDao接口

![image-20220122102511070](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122102511070.png)

~~~java
package com.koko.dao.role;

import com.koko.pojo.Role;
import java.sql.Connection;
import java.util.List;

public interface RoleDao {
    //获取角色列表
    public List<Role> getRoleList(Connection connection)throws Exception;
}
~~~

2. RoleDao接口实现类

![image-20220122102550797](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122102550797.png)

~~~java
package com.koko.dao.role;

import com.koko.dao.BaseDao;
import com.koko.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {

    @Override
    //获取角色列表
    public List<Role> getRoleList(Connection connection) throws Exception {

        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Role> roleList = new ArrayList<Role>();

        if (connection != null) {
            String sql = "select * from smbms_role";
            Object[] params = {};
            rs = BaseDao.execute(connection,  rs, pstm,sql, params);

            while (rs.next()) {
                Role _role=new Role();
                _role.setId(rs.getInt("id"));
                _role.setRoleCode(rs.getString("roleCode"));
                _role.setRoleName(rs.getString("roleName"));
                roleList.add(_role);
            }
            BaseDao.closeResource(null, pstm, rs);
        }

        return roleList;
    }

}
~~~



#### 6.4.2 Service层实现

>1、步骤

1. RoleService接口

![image-20220122102725823](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122102725823.png)

~~~java
package com.koko.service.role;

import com.koko.pojo.Role;
import java.util.List;

public interface RoleService {
    //角色列表查询
    public List<Role> getRoleList();
}
~~~

2. RoleServiceImpl接口实现类

![image-20220122102822768](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122102822768.png)

~~~java
package com.koko.service.role;

import com.koko.dao.BaseDao;
import com.koko.dao.role.RoleDao;
import com.koko.dao.role.RoleDaoImpl;
import com.koko.pojo.Role;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class RoleServiceImpl implements RoleService{

    //引入Dao
    private RoleDao roleDao;
    public RoleServiceImpl(){
        roleDao = new RoleDaoImpl();
    }

    @Override
    //角色列表查询
    public List<Role> getRoleList() {
        Connection connection = null;
        List<Role> roleList = null;

        try {
            connection = BaseDao.getConnection();
            roleList = roleDao.getRoleList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return roleList;
    }

}
~~~

3. 对Dao层传来的数据进行测试

~~~java
@Test
public void test(){
    RoleServiceImpl rs=new RoleServiceImpl();
    List<Role> rl=rs.getRoleList();
    for(Role role:rl){
        System.out.println(role.getRoleName());
    }
}
~~~

>2、测试

![image-20220122102938298](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122102938298.png)



### 6.5 Servlet层的处理

> 1、前端思路

1. 获取用户前端的数据（查询）
2. 判断请求是否需要执行，看参数的值判断
3. 为了实现分页，需要计算出当前页面和总页面，页面大小…
4. 用户列表展示
5. 返回前端

> 2、测试

1. Servlet层处理

![image-20220122120620849](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122120620849.png)

~~~java
//重点、难点
private void query(HttpServletRequest req, HttpServletResponse resp) {
    // TODO 自动生成的方法存根
    //1、查询用户列表
    //从前端获取数据
    //查询用户列表
    String queryUserName = req.getParameter("queryname");
    String temp = req.getParameter("queryUserRole");
    String pageIndex = req.getParameter("pageIndex");
    int queryUserRole = 0;

    //2、获取用户列表
    UserServiceImpl userService = new UserServiceImpl();
    List<User> userList = null;

    //第一此请求肯定是走第一页，页面大小固定的
    //设置页面容量
    int pageSize = 5;//把它设置在配置文件里,后面方便修改
    //当前页码
    int currentPageNo = 1;

    if(queryUserName == null){
        queryUserName = "";
    }
    if(temp != null && !temp.equals("")){
        queryUserRole = Integer.parseInt(temp);
    }
    if(pageIndex != null) {
        currentPageNo = Integer.parseInt(pageIndex);
    }

    //3、获取用户总数（分页	上一页：下一页的情况）
    //总数量（表）
    int totalCount	= userService.getUserCount(queryUserName,queryUserRole);

    //总页数支持
    PageSupport pageSupport = new PageSupport();
    pageSupport.setCurrentPageNo(currentPageNo);
    pageSupport.setPageSize(pageSize);
    pageSupport.setTotalCount(totalCount);

    int totalPageCount =pageSupport.getTotalPageCount();//总共有几页

    //控制首页和尾页
    //如果页面小于 1 就显示第一页的东西
    if(currentPageNo < 1) {
        currentPageNo = 1;
    }else if(currentPageNo > totalPageCount) {//如果页面大于了最后一页就显示最后一页
        currentPageNo =totalPageCount;
    }

    //4、用户列表展示
    userList = userService.getUserList(queryUserName, queryUserRole, currentPageNo, pageSize);
    req.setAttribute("userList", userList);

    RoleServiceImpl roleService = new RoleServiceImpl();
    List<Role> roleList = roleService.getRoleList();
    req.setAttribute("roleList", roleList);
    req.setAttribute("totalCount", totalCount);
    req.setAttribute("currentPageNo", currentPageNo);
    req.setAttribute("totalPageCount", totalPageCount);
    req.setAttribute("queryUserName", queryUserName);
    req.setAttribute("queryUserRole", queryUserRole);

    //5、返回前端
    try {
        req.getRequestDispatcher("userlist.jsp").forward(req, resp);
    } catch (ServletException e) {
        // TODO 自动生成的 catch 块
        e.printStackTrace();
    } catch (IOException e) {
        // TODO 自动生成的 catch 块
        e.printStackTrace();
    }
}
~~~

> 3、测试结果

1. 进入用户管理页面

![image-20220122120919849](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122120919849.png)

2. 前端添加页面

![image-20220122145319740](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122145319740.png)

3. 点击添加用户——>跳转到新页面

![image-20220122145212782](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122145212782.png)

<img src="https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/06_JavaWeb_smbms/image-20220122145239475.png" alt="image-20220122145239475" style="zoom:50%;" />



## 7. 项目总结

### 7.1 项目构造流程

> 1、原理图

![image-20220205154115258](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220205154115258.png)

![image-20220122154831434](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122154831434.png)



### 7.2 项目测试&发布（复习）

> 1、步骤

1. 在测试项目时，可以重新开启一个tomcat，进行对比测试

![image-20220122165655175](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122165655175.png)

2. 测试时更换端口

![image-20220122165842756](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122165842756.png)

3. 导入项目

![image-20220122165919223](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122165919223.png)

4. 开启&关闭tomcat微服务器，进行测试

![image-20220122165752820](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220122165752820.png)



### 7.3 项目心得

> 1、概述

在完成一个项目时，要牢记使用三层架构（表示层Servlet、业务层Service、持久层Dao）来完善项目，因为在企业开发大型项目时，防止每个程序员的开发风格不同导致开发效率和维护上的问题，其次，用这种架构能够更加规范代码，做到“各善其职”，最后，三层架构可以实现“高聚合，低耦合”的效果。

> **表现层（Presentation layer）**

表现层可以说是距离用户最近的层，主要是用于接收用户输入的数据和显示处理后用户需要的数据。一般表现为界面，用户通过界面输入查询数据和得到需要的数据。

> **业务层（Business Logic Layer）**

业务逻辑层是处于表现层和数据访问层之间，主要是从数据库中得到数据然后对数据进行逻辑处理。

> **持久层（Data access layer）**

数据访问层是直接和数据库打交道的，对数据进行“增、删、改、查”等基本的操作。



## 8. 项目拓展——文件上传

### 8.1 准备工作

> 1、开发原理

![image-20220123100103825](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220123100103825.png)

**注：本次开发使用空项目搭建**

> 2、开发前准备

1、对于文件上传，浏览器在上传的过程中是将文件以流的形式提交到服务器端的。

2、一般选择采用apache的开源工具common-fileupload这个文件上传组件。

3、common-fileupload是依赖于common-lo这个包的，所以还需要下载这个包。

~~~properties
//文件下载地址：
https://mvnrepository.com/artifact/commons-io/commons-io
https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload
~~~

【下载jar包】

![image-20220123232136993](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220123232136993.png)

> 3、搭建项目

1. 创建Module

![image-20220123234653434](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220123234653434.png)

* 注释：（如果没有JavaEE选项的话，执行下面操作）

![image-20220123234814466](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220123234814466.png)

* [全局搜索Registry]

![image-20220123230633401](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220123230633401.png)

[找到**javaee.legacy.project.wizard,打上√,然后close**]

2. 导入jar包

![image-20220123232323405](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220123232323405.png)

* [模块中新建lib目录，把两个包复制过去，右键add as Library即可~]

![image-20220123231734840](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220123231734840.png)

* [注意:使用IDEA导包需要注意修复路径，将lib添加到项目输出目录]



### 8.2 项目开发前须知

> 1、实用类介绍及面试问题（*）

1. 优化文件上传的四个方法：

![image-20220123100857726](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220123100857726.png)

2. 四个类的详解

![image-20220123100947244](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220123100947244.png)

> 2、Fileltem类

在HTML页面input必须有name`<input type="file" name="filename">`
		**表单如果包含一个文件上传输入项的话，这个表单的enctype属性就必须设置为multipart/form-data**

~~~jsp
<%--  通过表单上传文件
    get:上传文件大小有限制
        post:上传文件大小没有限制
            --%>
<form action="" enctype="multipart/form-data" method="post">
    上传用户: <input type="text" name="username"><br/>
    <p><input type="file" name="file1"></p>
    <p><input type="file" name="file2"></p>
    <p><input type="submit"> | <input type="reset"></p>
</form>
~~~

浏览器表单的类型如果为multipart/form-data ,在服务器端想获取数据就要通过流。

> 3、ServletFileUpload类

ServletFileUpload负责处理上传的文件数据,并将表单中每个输入项封装成一个Fileltem对象中。使用其parseRequest(HttpServletRequest)方法可以将通过表单中每一个HTML标签提交的数据封装成一个Fileltem对象，然后以L ist列表的形式返回。使用该方法处理上传文件简单易用。



### 8.3 开发项目

> 1、步骤

1. info.jsp

~~~jsp
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>

<%=request.getAttribute("msg")%>

</body>
</html>
~~~

2. index.jsp

~~~jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<%--  通过表单上传文件
      get:上传文件大小有限制
      post:上传文件大小没有限制
      --%>
<%--${pageContext.request.contextPath}获取服务器路径--%>
<form action="${pageContext.request.contextPath}/upload.do" enctype="multipart/form-data" method="post">
    上传用户: <input type="text" name="username"><br/>
    <p><input type="file" name="file1"></p>
    <p><input type="file" name="file2"></p>
    <p><input type="submit"> | <input type="reset"></p>
</form>

</body>
</html>
~~~

3. web.xml注册

~~~xml
<!--web.xml-->
<!--注册文件上传的servlet-->
<servlet>
    <servlet-name>FileServlet</servlet-name>
    <servlet-class>com.koko.servlet.FileServlet</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>FileServlet</servlet-name>
    <url-pattern>/upload.do</url-pattern>
</servlet-mapping>
~~~

4. FileServlet类

![image-20220124000323520](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220124000323520.png)

~~~java
package com.koko.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class FileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // response.getWriter().append("Served at: ").append(request.getContextPath());

        // 判断上传的文件普通表单还是带文件的表单
        if (!ServletFileUpload.isMultipartContent(request)) {
            return;//终止方法运行,说明这是一个普通的表单,直接返回
        }
        //创建上传文件的保存路径,建议在WEB-INF路径下,安全,用户无法直接访间上传的文件;
        String uploadPath =this.getServletContext().getRealPath("/WEB-INF/upload");
        File uploadFile = new File(uploadPath);
        if (!uploadFile.exists()){
            uploadFile.mkdir(); //创建这个月录
        }

        // 创建上传文件的保存路径，建议在WEB-INF路径下，安全，用户无法直接访问上传的文件
        String tmpPath = this.getServletContext().getRealPath("/WEB-INF/tmp");
        File file = new File(tmpPath);
        if (!file.exists()) {
            file.mkdir();//创建临时目录
        }

        // 处理上传的文件,一般都需要通过流来获取,我们可以使用 request, getInputstream(),原生态的文件上传流获取,十分麻烦
        // 但是我们都建议使用 Apache的文件上传组件来实现, common-fileupload,它需要旅 commons-io组件;
        try {
            // 1、创建DiskFileItemFactory对象，处理文件路径或者大小限制
            DiskFileItemFactory factory = getDiskFileItemFactory(file);
            /*
             * //通过这个工厂设置一个缓冲区,当上传的文件大于这个缓冲区的时候,将他放到临时文件 factory.setSizeThreshold(1024 *
             * 1024); //缓存区大小为1M factory.setRepository (file);//临时目录的保存目录,需要一个File
             */

            // 2、获取ServletFileUpload
            ServletFileUpload upload = getServletFileUpload(factory);

            // 3、处理上传文件
            // 把前端请求解析，封装成FileItem对象，需要从ServletFileUpload对象中获取
            String msg = uploadParseRequest(upload, request, uploadPath);

            // Servlet请求转发消息
            System.out.println(msg);
            if(msg == "文件上传成功!") {
                // Servlet请求转发消息
                request.setAttribute("msg",msg);
                request.getRequestDispatcher("info.jsp").forward(request, response);
            }else {
                msg ="请上传文件";
                request.setAttribute("msg",msg);
                request.getRequestDispatcher("info.jsp").forward(request, response);
            }

        } catch (FileUploadException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    public static DiskFileItemFactory getDiskFileItemFactory(File file) {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 通过这个工厂设置一个缓冲区,当上传的文件大于这个缓冲区的时候,将他放到临时文件中;
        factory.setSizeThreshold(1024 * 1024);// 缓冲区大小为1M
        factory.setRepository(file);// 临时目录的保存目录,需要一个file
        return factory;
    }

    public static ServletFileUpload getServletFileUpload(DiskFileItemFactory factory) {
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 监听长传进度
        upload.setProgressListener(new ProgressListener() {

            // pBYtesRead:已读取到的文件大小
            // pContextLength:文件大小
            public void update(long pBytesRead, long pContentLength, int pItems) {
                System.out.println("总大小：" + pContentLength + "已上传：" + pBytesRead);
            }
        });

        // 处理乱码问题
        upload.setHeaderEncoding("UTF-8");
        // 设置单个文件的最大值
        upload.setFileSizeMax(1024 * 1024 * 10);
        // 设置总共能够上传文件的大小
        // 1024 = 1kb * 1024 = 1M * 10 = 10м

        return upload;
    }

    public static String uploadParseRequest(ServletFileUpload upload, HttpServletRequest request, String uploadPath) throws FileUploadException, IOException {

        String msg = "";

        // 把前端请求解析，封装成FileItem对象
        List<FileItem> fileItems = upload.parseRequest(request);
        for (FileItem fileItem : fileItems) {
            if (fileItem.isFormField()) {// 判断上传的文件是普通的表单还是带文件的表单
                // getFieldName指的是前端表单控件的name;
                String name = fileItem.getFieldName();
                String value = fileItem.getString("UTF-8"); // 处理乱码
                System.out.println(name + ": " + value);
            } else {// 判断它是上传的文件

                // ============处理文件==============

                // 拿到文件名
                String uploadFileName = fileItem.getName();
                System.out.println("上传的文件名: " + uploadFileName);
                if (uploadFileName.trim().equals("")) {
                    continue;
                }

                // 获得上传的文件名/images/girl/paojie.png
                String fileName = uploadFileName.substring(uploadFileName.lastIndexOf("/") + 1);
                // 获得文件的后缀名
                String fileExtName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);

                /*
                 * 如果文件后缀名fileExtName不是我们所需要的 就直按return.不处理,告诉用户文件类型不对。
                 */

                System.out.println("文件信息[件名: " + fileName + " ---文件类型" + fileExtName + "]");
                // 可以使用UID（唯一识别的通用码),保证文件名唯
                // 0UID. randomUUID(),随机生一个唯一识别的通用码;
                String uuidPath = UUID.randomUUID().toString();

                // ================处理文件完毕==============

                // 存到哪? uploadPath
                // 文件真实存在的路径realPath
                String realPath = uploadPath + "/" + uuidPath;
                // 给每个文件创建一个对应的文件夹
                File realPathFile = new File(realPath);
                if (!realPathFile.exists()) {
                    realPathFile.mkdir();
                }
                // ==============存放地址完毕==============


                // 获得文件上传的流
                InputStream inputStream = fileItem.getInputStream();
                // 创建一个文件输出流
                // realPath =真实的文件夹;
                // 差了一个文件;加上翰出文件的名产"/"+uuidFileName
                FileOutputStream fos = new FileOutputStream(realPath + "/" + fileName);

                // 创建一个缓冲区
                byte[] buffer = new byte[1024 * 1024];
                // 判断是否读取完毕
                int len = 0;
                // 如果大于0说明还存在数据;
                while ((len = inputStream.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                // 关闭流
                fos.close();
                inputStream.close();

                msg = "文件上传成功!";
                fileItem.delete(); // 上传成功,清除临时文件
                //=============文件传输完成=============
            }
        }
        return msg;

    }
}
~~~



### 8.4 项目结果

> 1、测试

1. 网页提示

![image-20220124001430508](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220124001430508.png)

2. 下载文件成功

![image-20220124001303779](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220124001303779.png)

3. 文件上传后的地址在此目录下

![image-20220124000541328](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220124000541328.png)



## 9. 项目拓展——邮件发送

### 9.1 邮件发送原理图

> 1、开发原理

![20200708003842143](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/20200708003842143.png)



### 9.2 简单文件发送

> 1、简易文本邮件发送的实现

![image-20220124111718411](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220124111718411.png)

> 2、步骤

1. 创建一个maven项目，导入依赖

~~~xml
<!-- https://mvnrepository.com/artifact/com.sun.mail/javax.mail -->
<dependency>
      <groupId>com.sun.mail</groupId>
      <artifactId>javax.mail</artifactId>
      <version>1.6.2</version>
</dependency>

<!-- https://mvnrepository.com/artifact/javax.activation/activation -->
<dependency>
    <groupId>javax.activation</groupId>
    <artifactId>activation</artifactId>
    <version>1.1.1</version>
</dependency>
~~~

2. MailDemo01类

![image-20220124154232988](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220124154232988.png)

~~~java
package com.koko;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailDemo01 {
    public static void main(String[] args) throws Exception {
        Properties prop=new Properties();
        prop.setProperty("mail.host","smtp.qq.com");///设置QQ邮件服务器
        prop.setProperty("mail.transport.protocol","smtp");///邮件发送协议
        prop.setProperty("mail.smtp.auth","true");//需要验证用户密码

        //        //QQ邮箱需要设置SSL加密
        //        MailSSLSocketFactory sf=new MailSSLSocketFactory();
        //        sf.setTrustAllHosts(true);
        //        prop.put("mail.smtp.ssl.enable","true");
        //        prop.put("mail.smtp.ssl.socketFactory",sf);

        //使用javaMail发送邮件的5个步骤
        //1.创建定义整个应用程序所需要的环境信息的session对象
        Session session=Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("2427886409@qq.com","zqysrkcyicazdhhb");
            }
        });
        //开启session的debug模式，这样可以查看到程序发送Email的运行状态
        session.setDebug(true);
        
        //2.通过session得到transport对象
        Transport ts=session.getTransport();
        
        //3.使用邮箱的用户名和授权码连上邮件服务器
        ts.connect("smtp.qq.com","2427886409@qq.com","zqysrkcyicazdhhb");
        
        //4.创建邮件：写文件
        //注意需要传递session
        MimeMessage message=new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress("2427886409@qq.com"));
        //指明邮件的收件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("2427886409@qq.com"));
        //邮件标题
        message.setSubject("标题");
        //邮件的文本内容
        message.setContent("helloworld","text/html;charset=UTF-8");
        
        //5.发送邮件
        ts.sendMessage(message,message.getAllRecipients());

        //6.关闭连接
        ts.close();

    }
}
~~~

> 3、测试

![image-20220124154816878](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220124154816878.png)

![image-20220124154843725](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220124154843725.png)



### 9.3 复杂文件发送

> 1、文件构成解析

![image-20220124155515059](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220124155515059.png)

每一个文本、图片、附件可以分为一个MimeBodyPart，由MimeMultipart完成组装

> 2、代码实现

~~~java
//*：将上述“邮件的文本内容更改即可”
//邮件的文本内容
//=================================准备图片数据=======================================
MimeBodyPart image=new MimeBodyPart();

//图片需要经过数据化的处理
DataHandler dh=new DataHandler(new FileDataSource("E:\\媒体资料\\图片存储\\人物图像\\蜡笔小新\\timg (6).jfif"));

//在part中放入这个处理过图片的数据
image.setDataHandler(dh);

//给这个part设置一个ID名字
image.setContentID("bz.jpg");

//准备正文的数据
MimeBodyPart text=new MimeBodyPart();
text.setContent("这是一张正文<img src='cid:bz.jpg'>","text/html;charset=UTF-8");

//描述数据关系
MimeMultipart mm=new MimeMultipart();
mm.addBodyPart(text);
mm.addBodyPart(image);
mm.setSubType("related");

//设置到消息中，保存修改
message.setContent(mm);
message.saveChanges();
~~~

> 3、测试

![image-20220124161141226](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220124161141226.png)



### 9.4 带附件的文件发送

> 1、解释：

* 不过多演示，与上述同理

~~~java
import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class MailDemo03 {
    public static void main(String[] args) throws Exception {
        Properties prop=new Properties();
        prop.setProperty("mail.host","smtp.qq.com");///设置QQ邮件服务器
        prop.setProperty("mail.transport.protocol","smtp");///邮件发送协议
        prop.setProperty("mail.smtp.auth","true");//需要验证用户密码
        //QQ邮箱需要设置SSL加密
        MailSSLSocketFactory sf=new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable","true");
        prop.put("mail.smtp.ssl.socketFactory",sf);

        //使用javaMail发送邮件的5个步骤
        //1.创建定义整个应用程序所需要的环境信息的session对象
        Session session=Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1192XXXX@qq.com","授权码");
            }
        });
        //开启session的debug模式，这样可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2.通过session得到transport对象
        Transport ts=session.getTransport();
        //3.使用邮箱的用户名和授权码连上邮件服务器
        ts.connect("smtp.qq.com","1192XXXX@qq.com","授权码");
        //4.创建邮件：写文件
        //注意需要传递session
        MimeMessage message=new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress("1192XXXX@qq.com"));
        //指明邮件的收件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("1192XXXX@qq.com"));
        //邮件标题
        message.setSubject("java发出");

        //邮件的文本内容
        //=================================准备图片数据
        MimeBodyPart image=new MimeBodyPart();
        //图片需要经过数据化的处理
        DataHandler dh=new DataHandler(new FileDataSource("D:\\Bert\\1594126632(1).jpg"));
        //在part中放入这个处理过图片的数据
        image.setDataHandler(dh);
        //给这个part设置一个ID名字
        image.setContentID("bz.jpg");

        //=================================准备正文数据
        MimeBodyPart text=new MimeBodyPart();
        text.setContent("这是一张正文<img src='cid:bz.jpg'>","text/html;charset=UTF-8");

        //=================================准备附件数据
        MimeBodyPart body1= new MimeBodyPart();
        body1.setDataHandler(new DataHandler(new FileDataSource("D:\\Bert\\cmd.txt")));
        body1.setFileName("1.txt");

        //描述数据关系
        MimeMultipart mm=new MimeMultipart();
        mm.addBodyPart(body1);
        mm.addBodyPart(text);
        mm.addBodyPart(image);
        mm.setSubType("mixed");

        //设置到消息中，保存修改
        message.setContent(mm);
        message.saveChanges();
        //5.发送邮件
        ts.sendMessage(message,message.getAllRecipients());

        //6.关闭连接
        ts.close();

    }
}
~~~



### 9.5 实战：注册通知邮件

> 1、步骤

1. 看tomcat中是否导入相应jar包

![image-20220124171509977](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220124171509977.png)

2. 外部资源

![image-20220124172655189](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220124172655189.png)

3. index.jsp

~~~jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>

<form action="${pageContext.request.contextPath}/RegisterServlet.do" method="post">
    用户名：<input type="text" name="username">
    密码：<input type="text" name="pwd">
    邮箱：<input type="text" name="email">
    <input type="submit" value="注册">
</form>

</body>
</html>
~~~

4. info.jsp

~~~jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<h1>xxx网站温馨提示</h1>
${message}
</body>
</html>
~~~

5. web.xml

~~~xml
<servlet>
    <servlet-name>RegisterServlet</servlet-name>
    <servlet-class>com.koko.servlet.RegisterServlet</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>RegisterServlet</servlet-name>
    <url-pattern>/RegisterServlet.do</url-pattern>
</servlet-mapping>
~~~

6. 实体类&Servlet&核心工具类

![image-20220124172948176](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220124172948176.png)

7. User类（实体类）

~~~java
package com.koko.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private String email;

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
~~~

8. RegisterServlet类（Servlet类）

~~~java
package com.koko.servlet;

import com.koko.pojo.User;
import com.koko.utils.Sendmail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("pwd");
        String email=req.getParameter("email");

        User user=new User(username,password,email);

        Sendmail send=new Sendmail(user);
        send.start();//启动线程

        //注册用户
        req.setAttribute("message","注册成功，请稍等一会");
        req.getRequestDispatcher("info.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
~~~

9. Sendmail类(发送邮件核心类)

~~~java
package com.koko.utils;

import com.koko.pojo.User;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

//多线程实现用户体验——>异步处理
public class Sendmail extends Thread{
    //用于给用户发送邮箱的邮箱
    private String from="2427886409@qq.com";

    //邮箱的密码
    private String password="ihuomepoxwbceaja";

    //发送邮件的服务器地址
    private String host="smtp.qq.com";

    private User user;
    public Sendmail(User user){
        this.user=user;
    }

    //重写run方法的实现，在run方法中发送邮件给指定用户
    @Override
    public void run() {
        try {
            Properties prop=new Properties();
            prop.setProperty("mail.host",host);///设置QQ邮件服务器
            prop.setProperty("mail.transport.protocol","smtp");///邮件发送协议
            prop.setProperty("mail.smtp.auth","true");//需要验证用户密码

//            //QQ邮箱需要设置SSL加密
//            MailSSLSocketFactory sf=new MailSSLSocketFactory();
//            sf.setTrustAllHosts(true);
//            prop.put("mail.smtp.ssl.enable","true");
//            prop.put("mail.smtp.ssl.socketFactory",sf);

            //使用javaMail发送邮件的5个步骤
            //1.创建定义整个应用程序所需要的环境信息的session对象
            Session session=Session.getDefaultInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from,password);
                }
            });

            //开启session的debug模式，这样可以查看到程序发送Email的运行状态
            session.setDebug(true);

            //2.通过session得到transport对象
            Transport ts=session.getTransport();

            //3.使用邮箱的用户名和授权码连上邮件服务器
            ts.connect(host,from,password);

            //4.创建邮件：写文件
            //注意需要传递session
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(from));//发件人
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(user.getEmail()));//收件人
            message.setSubject("注册通知");//邮件标题

            //邮件的文本内容
            message.setContent("恭喜你("+user.getUsername()+")成功注册！"+"密码："+user.getPassword()
                    ,"text/html;charset=UTF-8");
            message.saveChanges();

            //5.发送邮件
            ts.sendMessage(message,message.getAllRecipients());

            //6.关闭连接
            ts.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
~~~



### 9.6 项目结果

> 1、测试

1. 页面提示

![image-20220124173412378](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220124173412378.png)

2. 注册后

![image-20220124173444532](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220124173444532.png)

3. 邮箱接收

![image-20220124173523854](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/16_Mybatis-plus/image-20220124173523854.png)



> 心得

往后的项目不用javaweb来进行开发，都可以通过ssm框架来进行开发，但是javaweb作为ssm框架的底层逻辑，在后续的学习和开发中都有很重要的作用，否则后续学习会非常痛苦！
