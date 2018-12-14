<%--
  Created by IntelliJ IDEA.
  User: smallBottle
  Date: 2018/12/14
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/modify/update">
        <input type="text" name="studentWeight" placeholder="请输入学生评价的权值">
        <input type="text" name="teacherWeight" placeholder="请输入同行评价的权值">
        <input type="text" name="leaderWeight" placeholder="请输入督导评价的权值">
        <input type="text" name="myselfWeight" placeholder="请输入老师自评的权值">
        <input type="submit" value="确认">
        <input type="reset" value="重置">
    </form>
</body>
</html>
