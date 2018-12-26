<%@ page import="edu.cs.hrbnu.model.Complaint" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.cs.hrbnu.model.Course" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: 1119692418
  Date: 2018/12/25
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--360浏览器优先以webkit内核解析-->
    <meta name="renderer" content="webkit">

    <title>未浏览投诉</title>
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
            margin-bottom: 400px;
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
        .btna{
            float: right;
            margin-bottom: 100px;
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
        <div class="col-xs-2">
            投诉日期
        </div>
        <div class="col-xs-2">
            投诉内容
        </div>
    </div>
    <%
        List<Complaint> complaints = (List<Complaint>)request.getSession().getAttribute("complaints");
        for (Complaint complaint : complaints){
    %>
             <div class="tablebody">
                 <div class="row">
                 <%
            Course course = complaint.getCourse();
            %>
            <div class="col-xs-2 ">
                             <%out.print(course.getSemester());%>
                             </div>
                     <div class="col-xs-2">
                         <%out.print(course.getCourseId());%>
                     </div>
                     <div class="col-xs-1">
                         <%out.print(course.getCourseName());%>
                     </div>
                     <div class="col-xs-2">
                         <%
                             Date date = complaint.getComplaintTime();
                             SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                             String dates = simpleDateFormat.format(date);
                             out.print(dates);
                         %>
                     </div>
                     <div class="col-xs-2">
                         <%--<form action="${pageContext.request.contextPath}/view/teacher/complaintInfo.jsp" method="post">--%>
                         <%--&lt;%&ndash;<button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser"onclick=javascrtpt:jump()>察看</button>&ndash;%&gt;--%>
                             <%--<% request.setAttribute("complaint",complaint);%>--%>
                             <%--<input type="submit" class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser" value="查看"/>--%>
                         <%--</form>--%>
                             <textarea rows="4" cols="25">
                                    <%out.print(complaint.getMessage());%>
                             </textarea>
                     </div>
                 </div>
             </div>
                     <%
        }
    %>












</div>
<a href="/view/teacher/admin.jsp"><button class="btn btn-look btn-xs btna" data-toggle="modal" data-target="#reviseUser">返回首页</button></a>
<script type="text/javascript">
    function jump(){
        window.location.href="complaintInfo.jsp";
    }
</script>

</html>
