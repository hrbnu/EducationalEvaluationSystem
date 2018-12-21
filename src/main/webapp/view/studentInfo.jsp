<%--
  Created by IntelliJ IDEA.
  User: 1119692418
  Date: 2018/12/13
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>该学生信息</title>
</head>
<body>
<table width="100%" border=1>
    <tr>
        <td>id</td>
        <td>密码</td>
        <td>班级id</td>
        <td>身份证号</td>
        <td>姓名</td>
        <td>等等</td>
    </tr>

    <tr>
        <td>${sessionScope.StudentInfo.studentId}</td>
        <td>${sessionScope.StudentInfo.password}</td>
        <td>${sessionScope.StudentInfo.classId}</td>
        <td>${sessionScope.StudentInfo.idCard}</td>
        <td>${sessionScope.StudentInfo.name}</td>
        <td>等等<td/>
        <td></td>

    </tr>

</table>

<form action="${pageContext.request.contextPath }/teacher/logout" method="post">
    <input type="submit" id="logout" value="登出">
</form>
</body>
</html>
