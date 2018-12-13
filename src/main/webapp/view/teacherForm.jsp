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
    <title>查看所有老师评价</title>
</head>
<body>
<table>
    <caption>所有老师</caption>
    <thead>
    <tr>

        <th>老师名字</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${teacherform}" var="vars">
        <tr>
            <td><a href="/teacher/courseform/${vars.teacherId}">${vars.teacherName}</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
