<%--
  Created by IntelliJ IDEA.
  User: smallBottle
  Date: 2018/12/21
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--360浏览器优先以webkit内核解析-->
    <meta name="renderer" content="webkit">

    <title>当前学期可评价课程</title>
    <style>
        .tablebody {

            margin: 20px 30px;
            text-align: left;

        }
        .tableHeader {

            height: 35px;
            line-height: 35px;
            font-size: 12px;
            font-weight: bold;
            color: #646987;
            background-color: #e3e8ee;
            padding: 0 30px;
            text-align: left;

        }
        .tablebody .row {

            margin-top: 10px;
            background-color: #fff;
            height: 70px;
            line-height: 70px;

        }
        .row {

            margin-right: -15px;
            margin-left: -15px;
        }
        .col-xs-1{
            width: 33.3%;
            float: left;
        }
        .col-xs-2 {

            width: 16.66666667%;
            float: left;
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
    </style>
</head>

<body style="background-color:#eff3f6;">
<div class="data-div">
    <div class="row tableHeader">

        <div class="col-xs-2 ">
            学年学期
        </div>
        <div class="col-xs-2">
            课程ID
        </div>
        <div class="col-xs-1">
            课程名称
        </div>
        <!--                      <div class="col-xs-2">
                                  评价状态
                              </div> -->
        <div class="col-xs-2">
            操作
        </div>
    </div>
    <div class="tablebody">
        <table>
        <c:forEach items="${courseform}" var="vars">
            <div class="row">
                <div class="col-xs-2 ">
                        ${vars.semester}
                </div>
                <div class="col-xs-2">
                        ${vars.courseId}
                </div>
                <div class="col-xs-1">
                        ${vars.courseName}
                </div>
                <div class="col-xs-2">
                    <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser"onclick=javascrtpt:jump(${vars.courseId})>察看</button>
                </div>
            </div>
        </c:forEach>
        </table>
    </div>

</div>
<script type="text/javascript">
    function jump(id){
        let url = "/teacher/evaluateform/"+id;

        window.location.href=url;
    }
</script>

</html>