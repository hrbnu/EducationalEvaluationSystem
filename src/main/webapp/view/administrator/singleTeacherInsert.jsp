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
            padding-top: 10px;
            margin-top: 50px;
            height: 250px;
            width: 52%;
            margin-left: 25%;
            font-size: 14px
        }

        #submit{
            background-color: red;
            border-radius: 3px;
            border: none;
            padding: 6px 35px;
            color: #FFFFFF;
            margin-left: 30%;
        }
        fieldset{

            border: none;
            border-radius: 2px;
            margin-bottom: 12px;
            overflow: hidden;
            padding: 0 .625em;
        }

        label{
            cursor: pointer;
            display: inline-block;
            padding: 3px 6px;
            text-align: right;
            width: 150px;
            vertical-align: top;
        }

        input{
            font-size: inherit;
        }
    </style>
</head>

<body>
<div id="mima">
    <form action="${pageContext.request.contextPath }/admin/insertSingleTeacher" method="post">
        <fieldset>
        <c:if test="${message != null}">
            <label>
                <font size="3" color="red">${message}</font>
            </label>
        </c:if>
        <c:if test="${successMessage != null}">
            <font size="5" color="red">${successMessage}</font>
        </c:if>
        <c:if test="${successMessage == null}">
            <p>
                <label for="teacherName" >姓名：</label>
                <input type="text" id="teacherName" name="teacherName" align="left">
            </p>
            <P>
                <label for="teacherId" >工号：</label>
                <input type="text" id="teacherId" name="teacherId" align="left">
            </P>
            <P>
                <label for="idCard" >身份证号：</label>
                <input type="text" id="idCard" name="idCard" align="left">
            </P>
            <P>
                <label for="teacherType" >教师身份：</label>
                <input type="checkbox" id="teacherType" name="teacherType" align="left">教师
                <input type="checkbox" id="monitorType" name="monitorType" align="left">督导
                <input type="checkbox" id="leaderType" name="leaderType" align="left">领导
            </P>
            <p>
                <input type="hidden" name="state" value="confirm" align="left">
            </p>
            <p>
                <input type="submit" value="确认添加" id="submit" align="left">
            </p>
        </fieldset>
        </c:if>
    </form>
</div>
</body>

</html>
