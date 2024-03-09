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
