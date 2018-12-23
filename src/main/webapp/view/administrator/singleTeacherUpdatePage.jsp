<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>修改教师信息</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <style type="text/css">
        #mima{
            padding-top: 50px;
            margin-top: 100px;
            height: 250px;
            width: 52%;
            margin-left: 36%;
            font-size: 14px
        }

        #submit{
            background-color: red;
            border-radius: 3px;
            border: none;
            padding: 6px 35px;
            color: #FFFFFF;
            margin-left: 8%;
        }
    </style>
</head>

<body>
<div id="mima">
    <form action="${pageContext.request.contextPath}/admin/updateSingleTeacher" method="post">
        姓名：<input type="text" name="teacherName" value="${teacherInfo.teacherName}">
        <P>工号：<input type="text" name="teacherId" value="${teacherInfo.teacherId}"></P>
        <P>密码：<input type="text" name="password"  value="${teacherInfo.password}"></P>
        <P>身份证号：<input type="text" name="idCard" value="${teacherInfo.idCard}"></P>
        <P>荣誉头衔：<input type="text" name="title"  value="${teacherInfo.title}"></P>
        <P>帮助教师姓名：<input type="text" name="helpTeacherName"  value="${teacherInfo.helpTeacherName}"></P>
        <P>帮助教师工号：<input type="text" name="helpTeacherId"  value="${teacherInfo.helpTeacherId}"></P>
        <p>受助教师姓名：<input type="text" name="accepterTeacherName"  value="${teacherInfo.accepterTeacherName}"></p>
        <P>受助教师工号：<input type="text" name="accepterTeacherId" value="${teacherInfo.accepterTeacherId}"></P>
        <P>教师身份:
            <input type="checkbox" name="teacherType"
                   <c:if test="${teacherInfo.teacherType == 'true'}">checked="checked"</c:if>>教师
            <input type="checkbox" name="leaderType"
                   <c:if test="${teacherInfo.leaderType == 'true'}">checked="checked"</c:if>>领导
            <input type="checkbox" name="monitorType"
                   <c:if test="${teacherInfo.monitorType == 'true'}">checked="checked"</c:if>>督导
            <input type="hidden" name="state" value="confirm"></P>
        <p><input type="hidden" name="state" value="confirm"></p>
        <p><input type="hidden" name="oldTeacherId" value="${teacherInfo.teacherId}"></p>
        <p><input type="submit" value="确认更改" id="submit"/>
    </form>
</div>
</body>

</html>