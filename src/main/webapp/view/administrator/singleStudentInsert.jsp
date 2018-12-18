<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/admin/insertSingleStudent" method="post">
    姓名：<input type="text" name="name"><br>
    学号：<input type="text" name="studentId"><br>
    身份证号：<input type="text" name="idCard"><br>
    院系：<input type="text" name="department"><br>
    年级：<input type="text" name="grade"><br>
    班级：<input type="text" name="classId"><br>
    <input type="hidden" name="state" value="confirm">
    <input type="submit" name="submit" value="确定添加">
</form>
</body>
</html>
