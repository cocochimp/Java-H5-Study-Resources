<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<%--<div style="text-align: center">居中,html知识--%>
<div>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        爱好：
        <input type="checkbox" name="hobbies" value="girl">女孩
        <input type="checkbox" name="hobbies" value="code">代码
        <input type="checkbox" name="hobbies" value="sing">唱歌
        <input type="checkbox" name="hobbies" value="movie">电影
        <br>
        <input type="submit">
    </form>
</div>

</body>
</html>
