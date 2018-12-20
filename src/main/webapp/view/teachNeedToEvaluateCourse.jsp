<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/19 0019
  Time: 下午 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>课程名</th>
            <th>授课老师</th>
            <th>是否开始评价</th>
        </tr>
        <c:forEach items="${tempMessage}" var="temp">
            <tr>
                <td>${temp.course.courseName}</td>
                <td>${temp.teacher.teacherName}</td>
                <td>
                    <form action="" method="post">
                    <input type="submit" value="开始评价">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
