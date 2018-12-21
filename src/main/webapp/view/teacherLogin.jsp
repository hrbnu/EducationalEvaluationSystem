<%--
  Created by IntelliJ IDEA.
  User: 1119692418
  Date: 2018/12/18
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师登录</title>
</head>
<body>

<%-- 教师登录 --%>
<form action="${pageContext.request.contextPath }/teacher/login" method="post">
    <h3>教师登录</h3>
    工号：<input type="text" name="teacherId"><br>
    密码：<input type="password" name="password"><br>
    登录：<input type="submit" name="submit" value="submit">
    <font color="red">${loginMessage}<br></font>
</form>
</body>
</html>
