<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/19 0019
  Time: 下午 18:38
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
                <th>申请老师</th>
                <th>申请老师职工号</th>
                <th>申请课程名</th>
                <th>确认已经听过课</th>
            </tr>
    <c:forEach items="${confimMessage}" var="applicationMessage">
            <tr>
                <td>${applicationMessage.requestTeacherName}</td>
                <td>${applicationMessage.requestTeacherId}</td>
                <td>${applicationMessage.requestIsListenedCourseName}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/teacher/confirmRequest" method="post">
                        <input type="hidden" value="${applicationMessage.requestIsListenedCourseId}" name="courseId">
                        <input type="hidden" value="${applicationMessage.requestTeacherId}" name="evaluateTeacherId">
                        <input type="hidden" value="${applicationMessage.classRequestRecordId}" name="classRequestRecordId">
                        <input type="submit" value="确认">
                    </form>
                </td>
            </tr>
    </c:forEach>
        </table>
</body>
</html>
