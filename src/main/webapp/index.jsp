<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<center>
    <div style="background-color: #45B549; padding: 50px; margin: 20px">
        <a href="view/teacher/loginC.jsp">教师登录</a>
    </div>

    <div style="background-color: #45B549; padding: 50px; margin: 20px">
        <a href="view/student/loginB.jsp">学生登录</a>
    </div>
    <div style="background-color: #45B549; padding: 50px; margin: 20px">
        <a href="view/administrator/loginA.jsp">管理员登录</a>
    </div>
</center>
<%--<p>test ly</p>    --%>

<%--excel上传form表单格式--%>
<%--<form action="/admin/addCourseByExcel" method="post" enctype="multipart/form-data">--%>
<%--<input type="file" name="excel" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">--%>
<%--<input type="submit" name="submit" value="submit">--%>
<%--</form>--%>

<%--测试输出100100的评价--%>
<%--<a href="/teacher/exportEvaluate/100100">下载</a>--%>

<%--<a href="view/studentLogin.jsp">学生登录</a>--%>
<%--<a href="view/teacherLogin.jsp">教师登录</a>--%>
<%--<a href="view/administrator.jsp">管理员登录</a>--%>
<%--<a href="view/student.jsp">学生页面</a>--%>
<%--<a href="view/teacher.jsp">教师页面</a>--%>
<%--<a href="view/administrator/administrator.jsp">管理员页面</a>--%>
<%--<a href="view/ClassRequestInsert.jsp">插入听课申请</a>--%>
<%--<a href="/admin/getEvaluateProblems">设置评价问题</a>--%>

<%--&lt;%&ndash;查看自己的评价需要获得teacherId，可在路径后加teacherId测试&ndash;%&gt;--%>
<%--<a href="/teacher/courseform/100100">教师查看自己的评价</a>--%>
<%--<a href="/teacher/teacherform">查看所有教师评价</a>--%>


<%--<div>--%>
<%--<form action="${pageContext.request.contextPath}/student/studentLogin.action">--%>
<%--<c:if test="${loginState==false}">--%>
<%--密码错误--%>
<%--</c:if>--%>
<%--<table style="margin:0 auto;border:1px solid;">--%>
<%--<tr>--%>
<%--<td>学生账号</td>--%>
<%--<td><input type="text" name="studentId"></td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>学生密码</td>--%>
<%--<td><input type="password" name="password"></td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td colspan="2"><input type="submit" value="提交"></td>--%>
<%--</tr>--%>
<%--</table>--%>
<%--</form>--%>
<%--</div>--%>
</body>
</html>