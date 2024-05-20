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

