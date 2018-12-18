<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/admin/insertSingleTeacher" method="post">
    姓名：<input type="text" name="teacherName"><br>
    工号：<input type="text" name="teacherId"><br>
    身份证号：<input type="text" name="idCard"><br>
    教师身份：
    <input type="checkbox" name="teacherType">教师
    <input type="checkbox" name="monitorType">督导
    <input type="checkbox" name="leaderType">领导
    <input type="hidden" name="state" value="confirm">
    <input type="submit" name="submit" value="确定添加">
</form>
</body>
</html>
