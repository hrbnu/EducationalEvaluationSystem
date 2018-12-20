<%@ page import="edu.cs.hrbnu.model.Complaint" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.cs.hrbnu.model.Course" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: 1119692418
  Date: 2018/12/13
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>该教师信息</title>
</head>
<body>
<table width="100%" border=1>
    <tr>
        <td>id</td>
        <td>密码</td>
        <td>姓名</td>
        <td>头衔</td>
        <td>自我评价内容</td>
        <td>等等</td>
    </tr>

        <tr>
            <td>${sessionScope.TeacherInfo.teacherId}</td>
            <td>${sessionScope.TeacherInfo.password}</td>
            <td>${sessionScope.TeacherInfo.teacherName}</td>
            <td>${sessionScope.TeacherInfo.title}</td>
            <td>${sessionScope.TeacherInfo.myselfEvaluateContent}</td>
            <td>等等<td/>
            <td></td>

        </tr>

</table>
<br>
<br>
<h3>未浏览投诉</h3>
<table width="100%" border=1>
    <tr>
        <td>课程名称</td>
        <td>投诉信息</td>
        <td>投诉时间</td>
    </tr>


        <%
            List<Complaint> complaints = (List<Complaint>)request.getSession().getAttribute("complaints");
            for (Complaint complaint:complaints) {
                Course course = complaint.getCourse();
                Date date = complaint.getComplaintTime();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                String complaintTime = simpleDateFormat.format(date);
                %>
    <tr>
                <td><%out.print(course.getCourseName());%></td>
                <td><%out.print(complaint.getMessage());%></td>
                <td><%out.print(complaintTime);%></td>
    </tr>

    <%
            }
        %>


</table>

<form action="${pageContext.request.contextPath }/teacher/logout" method="post">
    <input type="submit" id="logout" value="登出">
</form>

<form action="${pageContext.request.contextPath}/teacher/confirm">
    <input type="submit" value="确认听课申请">
</form>

<form action="${pageContext.request.contextPath}/teacher/getNeedToEvaluateCourseByTeacher">
    <input type="submit" value="评价未评价课程">
</form>
</body>


</html>


