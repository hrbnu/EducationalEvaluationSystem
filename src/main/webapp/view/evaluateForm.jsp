<%--
  Created by IntelliJ IDEA.
  User: smallBottle
  Date: 2018/12/10
  Time: 17:59
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
    <title>查看自己的评价</title>
    <base href="<%=basePath%>">
</head>
<body>
    <table>
        <caption>评价信息</caption>
        <thead>
        <tr>
            <th>评价信息</th>
            <th>评价分数</th>
            <th>种类</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${evaluateform}" var="vars">
            <tr>
                <td>${vars.evaluateContent}</td>
                <td>${vars.evaluateScore}</td>
                <c:if test="${vars.flag == 1}">
                    <td>学生</td>
                </c:if>
                <c:if test="${vars.flag == 2}">
                    <td>教师</td>
                </c:if>
                <c:if test="${vars.flag == 3}">
                    <td>督导</td>
                </c:if>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
