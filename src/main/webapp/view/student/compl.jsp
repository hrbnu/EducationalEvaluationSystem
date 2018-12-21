<%--
  Created by IntelliJ IDEA.
  User: yaque
  Date: 2018/12/12
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生投诉留言板</title>
    <style type="text/css">
        h1{
            margin-left: 5%;
            font-size: larger;
        }
        hr{
            width: 90%;
        }
        .row{
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
        .btn{
            border: none;
            float: right;
            margin-right: 6%;
            margin-top: 10px;
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
        .col-xs-1{
            float: left;
        }
        .col-xs-2 {
            margin-left:5px ;
            float: left;
        }
    </style>
</head>
<body>
<div class="MessageBoard">
    <h1>学生投诉</h1>
    <hr>
    <div class="data-div">
        <div class="row">
            <div class="col-xs-1 ">
                学号 :
            </div>
            <div class="col-xs-2">
                ${studentId}
            </div>
            <div class="col-xs-1">
                |课程号 :
            </div>
            <div class="col-xs-2">
                ${courseId}
            </div>
            <%--<div class="col-xs-1">--%>
                <%--|教师姓名 :--%>
            <%--</div>--%>
            <%--<div class="col-xs-2">--%>
                <%--教师1--%>
            <%--</div>--%>
        </div>
    </div>
    <br>
    <p style="color: red;margin-left: 5%;">*只有一次投诉机会，请慎重填写</p>
    <form action="/student/submitComplaint" method="get">
        <input type="hidden" name="studentId" value="${studentId}">
        <input type="hidden" name="courseId" value="${courseId}">
        <textarea class="Message" name="complaintContent" ></textarea>
        <div class="submit">
            <input class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser" type="submit" name="submit" value="提交" />
        </div>

    </form>
</div>
</body>
</html>