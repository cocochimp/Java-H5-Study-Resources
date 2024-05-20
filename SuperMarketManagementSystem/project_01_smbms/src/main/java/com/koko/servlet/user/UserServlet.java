package com.koko.servlet.user;

import com.alibaba.fastjson.JSONArray;
import com.koko.pojo.Role;
import com.koko.pojo.User;
import com.koko.service.role.RoleServiceImpl;
import com.koko.service.user.UserService;
import com.koko.service.user.UserServiceImpl;
import com.koko.util.Constants;
import com.koko.util.PageSupport;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO 自动生成的方法存根
        String method = req.getParameter("method");
        //实现复用~~~~~~
        if (method.equals("savepwd")) {
            this.updatePwd(req, resp);
        }else if(method.equals("pwdmodify")){
            this.pwdModify(req,resp);
        }else if(method.equals("query")){
            this.query(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO 自动生成的方法存根
        doGet(req, resp);
    }

    //修改新密码
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

}
