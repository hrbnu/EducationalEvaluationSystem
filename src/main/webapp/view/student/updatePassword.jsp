<%--
  Created by IntelliJ IDEA.
  User: 1119692418
  Date: 2018/12/24
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>更改密码</title>
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
    <form action="${pageContext.request.contextPath }/student/updatePassword" method="post">
        输入学工号： <input type="text" name="studentId"/>
        <P>输入原密码： <input type="password" name="password" />	您更改的密码</P>
        <P>输入新密码： <input type="password" name="newPassword" id="pw1"/>	字母数字组合可以包含下划线，6-20个字符</P>
        <p>确认新密码： <input type="password" name="newPasswordConfirm" id="pw2" onkeyup="validate()"/><span id="tishi"></span></p>
        <p><input type="submit" value="确认更改" id="submit"/>
            <font color="red">${updateMessage}<br></font>
    </form>
</div>

<script>
    function validate() {
        var pw1 = document.getElementById("pw1").value;
        var pw2 = document.getElementById("pw2").value;
        if(pw1 == pw2) {
            document.getElementById("tishi").innerHTML="<font color='green'>两次密码相同</font>";
            document.getElementById("submit").disabled = false;
        }
        else {
            document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
            document.getElementById("submit").disabled = true;
        }
    }
</script>
</body>

</html>
