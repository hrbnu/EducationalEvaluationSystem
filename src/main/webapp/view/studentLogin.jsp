<%--
  Created by IntelliJ IDEA.
  User: 1119692418
  Date: 2018/12/18
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生登录</title>
</head>
<body>

<!--  学生登录  -->
<form action="${pageContext.request.contextPath}/student/login" method="post">
    <h2>学生登录</h2>
    学号：<input type="text" name="studentId"><br>
    密码：<input type="password" name="password"><br>
    登录：<input type="submit" name="submit" value="submit">
    <font color="red">${loginMessage}<br></font>
</form>

</body>
</html>
