<%--
  Created by IntelliJ IDEA.
  User: yaque
  Date: 2018/12/12
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/student/submitComplaint" method="get">
        <input type="hidden" name="studentId" value="${studentId}">
        <input type="hidden" name="courseId" value="${courseId}">
        <input type="text" name="complaintContent" />
        <input type="submit" name="submit" value="提交" />
    </form>
</body>
</html>
