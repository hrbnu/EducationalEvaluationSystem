<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/19 0019
  Time: 下午 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/teacher/insertListenClass.action" method="POST">
    <table>
        <tr>
            <th>听课老师</th>
            <th>被听课老师</th>
            <th>课程名</th>
            <th>是否提交</th>
        </tr>
        <tr>
            <td><input type="text" name="teacherId"></td>
            <td><input type="text" name="isListeneredTeacherId"></td>
            <td><input type="text" name="courseName"></td>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
    </form>

</body>
</html>
