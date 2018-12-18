<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>学生信息表</h3>
<form action="${pageContext.request.contextPath}/admin/updateSingleStudent" method="post">
    年级：<input type="text" name="grade" name="grade" value="${studentInfo.grade}"><br>
    专业：<input type="text" name="department" name="grade" value="${studentInfo.department}"><br>
    班级：<input type="text" name="classId" name="grade" value="${studentInfo.classId}"><br>
    学号：<input type="text" name="studentId" name="grade" value="${studentInfo.studentId}"><br>
    姓名：<input type="text" name="name" name="grade" value="${studentInfo.name}"><br>
    身份证号：<input type="text" name="idCard" name="grade" value="${studentInfo.idCard}"><br>
    密码：<input type="text" name="password" name="grade" value="${studentInfo.password}"><br>
    状态：<input type="text" name="graduation" name="grade" value="${studentInfo.graduation}"><br>
    <input type="hidden" name="state" value="confirm">
    <input type="hidden" name="oldStudentId" value="${studentInfo.studentId}">
    <input type="submit" name="submit" value="确定修改">
</form>
</body>
</html>
