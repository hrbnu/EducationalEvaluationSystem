<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'historyCourse.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <table  style="margin:0 auto;border:1px solid;">
	  <tr>
		  <th>课程名</th>
		  <th>授课老师</th>
		  <th>上课时间</th>
		  <th>已评价次数</th>
		  <th>评价课程</th>
	  </tr>
	  <c:forEach items="${historyCourse}" var="course">
		  <tr>
			  <td>${course.course.courseName}</td>
			  <td>${course.teacher.teacherName}</td>
			  <td>${course.course.score}</td>
			  <td>${course.studentCourse.courseTime}</td>
			  <td>
				  <c:if test="${course.studentCourse.courseTime+1<=(course.course.learnTime/10+1)}">
					  <a href="<%=basePath%>/student/evalu?studentId=${sessionScope.get("studentId")}&courseId=${course.course.courseId}">评价</a>

				  </c:if>
				  <c:if test="${course.studentCourse.courseTime+1>(course.course.learnTime/10+1)}">
					  <span>当前课程评价次数已满</span>
				  </c:if>
			  </td>

		  </tr>
	  </c:forEach>
  </table>
  </body>
</html>

