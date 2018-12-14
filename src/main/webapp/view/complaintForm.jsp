<%--
  Created by IntelliJ IDEA.
  User: smallBottle
  Date: 2018/12/10
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>查看自己的投诉</title>
    <base href="<%=basePath%>">
</head>
<body>
<table>
    <caption>投诉信息</caption>
    <thead>
    <tr>
        <th>投诉信息</th>
        <th>投诉时间</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${complaintform}" var="vars">
        <tr>
            <td>${vars.message}</td>
            <td><fmt:formatDate value="${vars.complaintTime}" pattern="yyyy/MM/dd"/></td>
   
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
