<%--
  Created by IntelliJ IDEA.
  User: smallBottle
  Date: 2018/12/21
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                ${sessionScope.TeacherInfo.teacherId}
            </div>

        </div>
    </div>
    <br>
    <p></p>
    <h4>学生投诉</h4>
    <div class="data-div">
        <div class="row tableHeader">
            <div class="col-xs-2 ">
                投诉
            </div>
            <div class="col-xs-1">
                时间
            </div>
        </div>
        <div class="tablebody">
            <%--<div class="row">--%>
            <c:forEach items="${complaintform}" var="vars">

                <div class="row">
                    <div class="col-xs-2">
                            ${vars.message}
                    </div>
                    <div class="col-xs-1">
                        <fmt:formatDate value="${vars.complaintTime}" pattern="yyyy/MM/dd"/>
                    </div>
                </div>


            </c:forEach>

        </div>

    </div>

</body>
</html>
