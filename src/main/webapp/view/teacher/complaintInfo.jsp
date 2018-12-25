<%@ page import="edu.cs.hrbnu.model.Course" %>
<%@ page import="edu.cs.hrbnu.model.Complaint" %><%--
  Created by IntelliJ IDEA.
  User: 1119692418
  Date: 2018/12/25
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        h4{
            margin-left: 5%;
            margin-bottom: 0px;
        }
        hr{
            width: 90%;
        }
        .ex{
            float: right;
            margin-right: 10%;
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
    <div class="ex">
        <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">导出</button>
    </div>
    <h1>投诉详情</h1>
    <hr>
    <%
    Complaint complaint = (Complaint) request.getAttribute("complaint");
    System.out.println(complaint.getCourse().getCourseId());
    Course course = complaint.getCourse();
    %>
    <div class="d">
        <div class="r">
            <div class="c1 ">
                教职工工号 :
            </div>
            <div class="c2">
                <%out.print(course.getTeacherId());%>
            </div>
            <div class="c1">
                |课程名称 :
            </div>
            <div class="c2">
                <%out.print(course.getCourseName());%>
            </div>
            <div class="c1">
                |课程ID :
            </div>
            <div class="c2">
                12324234
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
            <div class="col-xs-1">
                评价
            </div>
        </div>
        <div class="tablebody">

            <div class="row">
                <div class="col-xs-2">
                    其他
                </div>
                <div class="col-xs-1">
                    自定义内容
                </div>
            </div>

        </div>

    </div>
    <br>
    <p></p>
</body>
</html>
