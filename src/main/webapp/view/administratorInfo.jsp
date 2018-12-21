<%--
  Created by IntelliJ IDEA.
  User: 1119692418
  Date: 2018/12/18
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>该管理员信息</title>
</head>
<body>
<table width="100%" border=1>
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>密码</td>
    </tr>

    <tr>
        <td>${sessionScope.administratorInfo.id}</td>
        <td>${sessionScope.administratorInfo.name}</td>
        <td>${sessionScope.administratorInfo.password}</td>
    </tr>

</table>
<form action="${pageContext.request.contextPath }/admin/logout" method="post">
    <input type="submit" id="logout" value="登出">
</form>
</body>
</html>
