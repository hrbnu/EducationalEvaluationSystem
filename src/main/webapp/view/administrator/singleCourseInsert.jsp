<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>添加课程信息</title>
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
    <form action="${pageContext.request.contextPath }/admin/insertSingleCourse" onsubmit="return validate()" method="post">
        <c:if test="${message != null}">
            <font size="2" color="red">${message}</font>
        </c:if>
        <c:if test="${successMessage != null}">
            <font size="5" color="red">${successMessage}</font>
        </c:if>
        <c:if test="${successMessage == null}">
        <fieldset>
            <p>
                <label for="courseName" >课程名：</label>
                <input type="text" id="courseName" name="courseName" align="left">
            </p>
            <P>
                <label for="courseId" >课程号：</label>
                <input type="text" id="courseId" name="courseId" align="left">
            </P>
            <P>
                <label for="score" >学分：</label>
                <input id="score" type="text" name="score" align="left">
            </P>
            <P>
                <label for="classification" >课程属性：</label>
                <input type="text" id="classification" name="classification" align="left">
            </P>
            <P>
                <label for="teacherId" >教师工号：</label>
                <input type="text" id="teacherId" name="teacherId" align="left">
            </P>
            <P>
                <label for="semester" >当前课程所属学期：</label>
                <input id="semester" type="text" name="semester" align="left">
            </P>
            <P>
                <label for="courseClass" >课程所属班级：</label>
                <input type="text" id="courseClass" name="courseClass" align="left">
            </P>
            <P>
                <label for="startTime" >课程开始时间：</label>
                <input type="text" id="startTime" name="startTime" align="left">
            </P>
            <P>
                <label for="endTime" >课程结束时间：</label>
                <input type="text" id="endTime" name="endTime" align="left">
            </P>
            <P>
                <label for="learnTime" >总课时数：</label>
                <input id="learnTime" type="text" name="learnTime" align="left">
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
<script type="text/javascript">
    //下面就是判断是否== 的代码，无需解释
    function validate(){
        var score = document.getElementById('score').value.toUpperCase();
        var semester = document.getElementById('semester').value.toUpperCase();
        var learnTime = document.getElementById('learnTime').value.toUpperCase();
        if(score ==0){
            alert('请输入学分');
            return false;
        }else if(semester == 0){
            alert('请输入学期');
            return false;
        }else if(learnTime == 0){
            alert('请输入总课时数');
            return false;
        }else{
            return true;
        }
    }
</script>
</body>

</html>

