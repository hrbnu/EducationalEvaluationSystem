<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>重置密码</title>
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

<body style="background-color:#FFF;">
<div id="mima">
    <form action="${pageContext.request.contextPath }/student/reset" method="post">

        <P>学号 / 工号： <input type="text" name="studentId" /></P>
        <P>身 份 证 号 ： <input type="text" name="idCard" /></P>
        <p style="color: red;">*密码将重置为您的初始密码</p>
        <p><input type="submit" value="重置密码" id="submit"/>
        <font color="red">${resetMessage}<br></font>
    </form>
</div>


</body>

</html>
