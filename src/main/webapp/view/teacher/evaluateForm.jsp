<%--
  Created by IntelliJ IDEA.
  User: smallBottle
  Date: 2018/12/21
  Time: 17:16
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
    <meta charset="UTF-8">
    <title>学生投诉留言板</title>
    <style type="text/css">
        h1{
            margin-left: 5%;
            font-size: larger;
        }
        h4{
            margin-left: 5%;
            margin-bottom: 0px;
        }
        hr{
            width: 90%;
        }
        .r{
            margin-left: 5%;
        }
        .MessageBoard{
            width: 100%;
            height: 500px;
            margin-top: 50px;
        }
        .Message{
            width: 90%;
            height: 400px;
            margin-left: 5%;
        }
        .c1{
            float: left;
        }
        .c2 {
            margin-left:5px ;
            float: left;
        }
        .data-div{
            width: 90%;
            margin-left: 5%;
        }
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
    </style>
</head>
<body>
<div class="MessageBoard">
    <h1>课堂教学评价表</h1>
    <hr>
    <div class="d">
        <div class="r">
            <div class="c1 ">
                教职工工号 :
            </div>
            <div class="c2">
                1234445
            </div>
            <div class="c1">
                |课程名称 :
            </div>
            <div class="c2">
                课程1
            </div>
            <div class="c1">
                |课程ID :
            </div>
            <div class="c2">

            </div>
            <div class="c1">
                |教授学期 :
            </div>
            <div class="c2">
                2016-2017-2
            </div>
        </div>
    </div>
    <br>
    <p></p>
    <h4>同行评价</h4>
    <div class="data-div">
        <div class="row tableHeader">
            <div class="col-xs-2 ">
                评价
            </div>
            <div class="col-xs-1">
                分数
            </div>
        </div>
        <div class="tablebody">
            <%--<div class="row">--%>
            <c:forEach items="${evaluateform}" var="vars">

                    <c:if test="${vars.flag == 2}">
                        <div class="row">
                            <div class="col-xs-2">
                                ${vars.evaluateContent}
                            </div>
                            <div class="col-xs-1">
                                ${vars.evaluateScore}
                            </div>
                        </div>
                    </c:if>

            </c:forEach>

        </div>

    </div>
    <br>
    <p></p>
    <h4>领导评价</h4>
    <div class="data-div">
        <div class="row tableHeader">
            <div class="col-xs-2 ">
                评价
            </div>
            <div class="col-xs-1">
                分数
            </div>
        </div>
        <div class="tablebody">
            <c:forEach items="${evaluateform}" var="vars">

                <c:if test="${vars.flag == 3}">
                    <div class="row">
                        <div class="col-xs-2">
                                ${vars.evaluateContent}
                        </div>
                        <div class="col-xs-1">
                                ${vars.evaluateScore}
                        </div>
                    </div>
                </c:if>

            </c:forEach>

        </div>

    </div>
    <br>
    <p></p>
    <h4>学生评价</h4>
    <div class="data-div">
        <div class="row tableHeader">
            <div class="col-xs-2 ">
                评价
            </div>
            <div class="col-xs-1">
                分数
            </div>
        </div>
        <div class="tablebody">
            <c:forEach items="${evaluateform}" var="vars">

                <c:if test="${vars.flag == 1}">
                    <div class="row">
                        <div class="col-xs-2">
                                ${vars.evaluateContent}
                        </div>
                        <div class="col-xs-1">
                                ${vars.evaluateScore}
                        </div>
                    </div>
                </c:if>

            </c:forEach>

        </div>

    </div>
</body>
</html>
