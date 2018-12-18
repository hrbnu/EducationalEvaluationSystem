<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>教师信息表</h3>
<form action="${pageContext.request.contextPath}/admin/updateSingleTeacher" method="post">
    姓名：<input type="text" name="teacherName" value="${teacherInfo.teacherName}"><br>
    工号：<input type="text" name="teacherId" value="${teacherInfo.teacherId}"><br>
    身份证号：<input type="text" name="idCard" value="${teacherInfo.idCard}"><br>
    密码：<input type="text" name="password"  value="${teacherInfo.password}"><br>
    荣誉头衔：<input type="text" name="title"  value="${teacherInfo.title}"><br>
    帮助教师姓名：<input type="text" name="helpTeacherName"  value="${teacherInfo.helpTeacherName}"><br>
    帮助教师工号：<input type="text" name="helpTeacherId"  value="${teacherInfo.helpTeacherId}"><br>
    受助教师姓名：<input type="text" name="accepterTeacherName"  value="${teacherInfo.accepterTeacherName}"><br>
    受助教师工号：<input type="text" name="accepterTeacherId" value="${teacherInfo.accepterTeacherId}"><br>
    教师身份:
    <input type="checkbox" name="teacherType"
    <c:if test="${teacherInfo.teacherType == 'true'}">checked="checked"</c:if>>教师
    <input type="checkbox" name="leaderType"
           <c:if test="${teacherInfo.leaderType == 'true'}">checked="checked"</c:if>>领导
    <input type="checkbox" name="monitorType"
           <c:if test="${teacherInfo.monitorType == 'true'}">checked="checked"</c:if>>督导
    <input type="hidden" name="state" value="confirm">
    <input type="hidden" name="oldTeacherId" value="${teacherInfo.teacherId}">
    <input type="submit" name="submit" value="确定修改">
</form>
</body>
</html>
