<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--360浏览器优先以webkit内核解析-->
    <meta name="renderer" content="webkit">

    <title>上传课程Excel表</title>
    <style>
        .tablebody .row {

            margin-top: 10px;
            background-color: #fff;
            height: 70px;
            line-height: 70px;

        }
        .data-div{
            margin-bottom: 500px;
        }
        .btn{
            border: none;
        }
        .btn-look {

            color: #fff;
            background-color: #d9534f;
        }
        .btn-xs, .btn {
            padding: 6px 9px;
            font-size: 12px;
            line-height: 1.083;
            border-radius: 3px;
        }
        .btn-look:focus{
            color: #fff;
            background-color:#5C5956;
            border-color:#d43f3a
        }

        p{
            width: 400px;
            margin: 0px auto;
            text-align: center;
            margin-top: 122px;
            margin-bottom: 20px;
        }
        .href-a{
            margin: 0px auto;
            display: block;
            width: 33px;
            text-align: center;
        }
    </style>
</head>

<body style="background-color:#eff3f6;">
<div class="data-div">
    <p>如果没有自动下载，请点击此处下载</p>
    <a href="/teacher/exportEvaluate/${sessionScope.teacherId}" class="btn btn-look btn-xs href-a" data-toggle="modal" data-target="#reviseUser">下载</a>
</div>
</body>
<script type="text/javascript">
    function jump(){
        window.location.href="index_v14.html";
    }
</script>

</html>