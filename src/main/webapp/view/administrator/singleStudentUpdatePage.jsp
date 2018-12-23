<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>修改学生信息</title>
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
    <form action="${pageContext.request.contextPath}/admin/updateSingleStudent" method="post">
        年级： <input type="text" name="grade" name="grade" value="${studentInfo.grade}">
        <P>专业： <input type="text" name="department" name="grade" value="${studentInfo.department}"></P>
        <P>班级： <input type="text" name="classId" name="grade" value="${studentInfo.classId}"></P>
        <P>学号： <input type="text" name="studentId" name="grade" value="${studentInfo.studentId}"></P>
        <P>姓名： <input type="text" name="name" name="grade" value="${studentInfo.name}"></P>
        <P>身份证号： <input type="text" name="idCard" name="grade" value="${studentInfo.idCard}"></P>
        <P>密码： <input type="text" name="password" name="grade" value="${studentInfo.password}"></P>
        <p>状态： <input type="text" name="graduation" name="grade" value="${studentInfo.graduation}"></p>
        <p><input type="hidden" name="state" value="confirm"></p>
        <p><input type="hidden" name="oldStudentId" value="${studentInfo.studentId}"></p>
        <p><input type="submit" value="确认更改" id="submit"/>
    </form>
</div>
</body>

</html>