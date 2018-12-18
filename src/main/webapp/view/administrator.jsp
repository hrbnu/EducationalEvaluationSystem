<%--
  Created by IntelliJ IDEA.
  User: 1119692418
  Date: 2018/12/18
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
      <title>欢迎！</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/admin/login" method="post">
    <h3>管理员登录</h3>
    账号：<input type="text" name="id"><br>
    密码：<input type="password" name="password"><br>
    登录：<input type="submit" name="submit" value="submit">
    <font color="red">${message}<br></font>
</form>
</body>
</html>
