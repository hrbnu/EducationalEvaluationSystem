<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>




<%-- 学生重置密码 --%>
<form action="${pageContext.request.contextPath }/student/reset" method="post">
    <h3>重置密码</h3>
    学号：<input type="text" name="studentId"><br>
    身份证号：<input type="text" name="idCard"><br>
    确认重置：<input type="submit" name="submit" value="submit">
    <font color="red">${resetMessage}<br></font>
</form>

<%-- 学生更改密码 --%>
<form action="${pageContext.request.contextPath }/student/updatePassword" method="post">
    <h3>更改密码</h3>
    学号：<input type="text" name="studentId"><br>
    原密码：<input type="password" name="password"><br>
    新密码：<input type="password" name="newPassword"><br>
    确认密码：<input  type="password" name="newPasswordConfirm"><br>
    确认更改：<input type="submit" name="submit" value="submit">
    <font color="red">${updateMessage}<br></font>
</form>
</body>
</html>
