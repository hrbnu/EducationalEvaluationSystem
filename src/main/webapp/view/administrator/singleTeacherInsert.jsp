<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>添加教师信息</title>
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
    <form action="${pageContext.request.contextPath }/admin/insertSingleTeacher" method="post">
        <c:if test="${message != null}">
            <font size="2" color="red">${message}</font>
        </c:if>
        <c:if test="${successMessage != null}">
            <font size="5" color="red">${successMessage}</font>
        </c:if>
        <c:if test="${successMessage == null}">
            <p>姓名：<input type="text" name="teacherName"></p>
            <P>工号：<input type="text" name="teacherId"></P>
            <P>身份证号：<input type="text" name="idCard"></P>
            <P>教师身份：
                <input type="checkbox" name="teacherType">教师
                <input type="checkbox" name="monitorType">督导
                <input type="checkbox" name="leaderType">领导</P>
            <p><input type="hidden" name="state" value="confirm"></p>
            <p><input type="submit" value="确认添加" id="submit"/>
        </c:if>
    </form>
</div>
</body>

</html>
