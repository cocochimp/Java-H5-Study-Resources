<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>文件上传</title>
  </head>
  <body>

  <form action="${pageContext.request.contextPath}/upload02" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="upload">
  </form>

  <a href="${pageContext.request.contextPath}/download">点击下载</a>

  </body>
</html>
