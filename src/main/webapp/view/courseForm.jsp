<%--
  Created by IntelliJ IDEA.
  User: smallBottle
  Date: 2018/12/12
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>选择课程</title>
</head>
<body>
    <table>
        <caption>当前所授课程</caption>
        <thead>
        <tr>
            <th>课程Id</th>
            <th>课程名</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${courseform}" var="vars">
            <tr>
                <td>${vars.courseId}</td>
                <td><a href="/teacher/courseform/${vars.courseId}">${vars.courseName}</a> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
