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
    <form action="${pageContext.request.contextPath }/admin/insertSingleStudent" onsubmit="return validate()" method="post">
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
        <div class="input_div">

                <p>
                    <label for="name" >姓名：</label>
                    <input type="text" id="name" name="name" align="left">
                </p>
                <P>
                    <label for="studentId" >学号：</label>
                    <input type="text" id="studentId" name="studentId" align="left">
                </P>
                <P>
                    <label for="idCard" >身份证号：</label>
                    <input type="text" id="idCard" name="idCard" align="left">
                </P>
                <P>
                    <label for="department" >专业：</label>
                    <input type="text" id="department" name="department" align="left">
                </P>
                <P>
                    <label for="grade" >年级：</label>
                    <input id="grade" type="text" name="grade" align="left">
                </P>
                <P>
                    <label for="classId" >班级：</label>
                    <input id="classId" type="text" name="classId" align="left">
                </P>
                <p>
                    <input type="hidden" name="state" value="confirm" align="left">
                </p>
                <p>
                    <input type="submit" value="确认添加" id="submit" align="left">
                </p>

        </div>
        </fieldset>
        </c:if>
    </form>
</div>
<script type="text/javascript">
    //下面就是判断是否== 的代码，无需解释
    function validate(){
        var grade = document.getElementById('grade').value.toUpperCase();
        var classId = document.getElementById('classId').value.toUpperCase();
        if(grade ==0){
            alert('请输入年级');
            return false;
        }else if(classId == 0){
            alert('请输入班级');
            return false;
        }else{
            return true;
        }
    }
</script>
</body>

</html>
