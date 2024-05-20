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

        if(user.getUserPassword().equals(userPassword)){
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