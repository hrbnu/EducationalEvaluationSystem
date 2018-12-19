<%--
  Created by IntelliJ IDEA.
  User: 1119692418
  Date: 2018/12/18
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
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

<div>
    <form action="${pageContext.request.contextPath}/student/getHistoryCourse.action" method="POST">
        <input type="submit" value="历史评价">
    </form>
    <form action="${pageContext.request.contextPath}/student/getCurrentCourse.action" method="POST">
        <input type="submit" value="当前课程评价">
    </form>
    <form action="${pageContext.request.contextPath}/student/studentOut.action" method="POST">
        <input type="submit" value="退出">
    </form>
</div>
</body>
</html>
