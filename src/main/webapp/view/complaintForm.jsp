<%--
  Created by IntelliJ IDEA.
  User: smallBottle
  Date: 2018/12/12
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>投诉</title>
</head>
<body>
<table>
    <caption>查看课程投诉</caption>
    <thead>
    <tr>

        <th>投诉信息</th>
        <th>投诉时间</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${complatintform}" var="vars">
        <tr>

            <td>${vars.message}</td>
            <td><fmt:formatDate value="${vars.complaintTime}" pattern="yyyy/MM/dd"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
