<%--
  Created by IntelliJ IDEA.
  User: yaque
  Date: 2018/12/25
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<head>
    <title>消息提示</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script type="text/javascript">
        var time = 4;
        function returnUrlByTime() {
            window.setTimeout('returnUrlByTime()', 1000);
            time = time - 1;
            document.getElementById("layer").innerHTML = time;
        }
    </script>
</head>

<body  onload="returnUrlByTime()">
<center>
    <h1>消息提示</h1>

    <h3><span id="layer">3</span>秒后将自动跳转。</h3>
    <h3>${message}</h3>
</center>

<%
    //转向语句

    response.setHeader("Refresh", "3;URL=" + request.getAttribute("url"));
%>
</body>
</html>

