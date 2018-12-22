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

        form{
            min-width: 400px;
            height: auto;
            margin: 0px auto;
            margin-top: 200px;
        }
        form input{
            display: block;
            margin: 0px auto;
            min-width: 400px;
            cursor: pointer;
            height: 50px;
        }
        .input-file{
            width: 400px;
            text-align: center;
            margin: 0px auto;
            color: #fff;
            cursor: pointer;
            position: relative;
            height: 50px;
            border: 1px solid #d1d1d1;
            background: #fff;
            line-height: 50px;
            margin-bottom: 22px;
        }
        .input-file>p{
            position: absolute;
            top: -15px;
            color: #000;
            left: 165px;
        }
        .input-submit{
            font-size: 21px;
        }
        .status-text{
            width: 200px;
            margin: 0px auto;
            margin-top: 161px;
            font-size: 34px;
        }
    </style>
</head>

<body style="background-color:#eff3f6;">
<div class="data-div">
    <c:choose>
        <c:when test="${retStatus == 1}">
            <p class="status-text">导入失败</p>
        </c:when>
        <c:when test="${retStatus == 2}">
            <p class="status-text">导入成功</p>
        </c:when>
        <c:otherwise>
            <form action="/admin/addCourseByExcel" method="post" enctype="multipart/form-data">
                <div class="input-file">
                    <p>选择文件</p>
                    <input style="opacity: 0" type="file" name="excel" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
                </div>
                <input class="btn btn-look btn-xs input-submit" data-toggle="modal" data-target="#reviseUser" type="submit" name="submit" value="上传">
            </form>
        </c:otherwise>
    </c:choose>
</div>
</body>
<script type="text/javascript">
    function jump(){
        window.location.href="index_v14.html";
    }
</script>

</html>