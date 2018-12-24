<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="edu.cs.hrbnu.model.Teacher" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="else" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--360浏览器优先以webkit内核解析-->
    <meta name="renderer" content="webkit">

    <title>教师信息</title>
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
            width: 16%;
            float: left;
        }
        .col-xs-2 {

            width: 6%;
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
            float: inherit;
            margin-top: 5px;
        }
        .btn-look:focus{
            color: #fff;
            background-color:#5C5956;
            border-color:#d43f3a
        }
        .ex{
            float: right;
            margin-right: 0px;
        }
        #parent {
            width: 250px;
            height: 40px;
            border-radius: 5px;
            box-shadow: 0 0 5px #ccc;
            position: relative;
            float: left;
            margin-left: 10px;
        }
        #parent1 {
            width: 250px;
            height: 5px;
            border-radius: 5px;
            position: relative;
            float: left;
            margin-left: 10px;
        }
        #parent select {
            border:1px solid #B8CBCB;
            outline: none;
            width: 100%;
            height: 40px;
            line-height: 40px;
            appearance: none;
            -webkit-appearance: none;
            -moz-appearance: none;
            padding-left: 10px;
            background: url("../image/select.png") no-repeat scroll right 0.5rem transparent;
            background-size: 10% 60%;
            padding-right: 0.14rem;
        }
        #mima{
            padding-top: 50px;
            margin-top: 100px;
            height: 250px;
            width: 52%;
            margin-left: 36%;
            font-size: 14px
        }
        *{ margin:0; padding:0;}
        .none{ display:none;}
        .area{ margin-top:15px;}
        .area span{ display:inline-block; width:100px; text-align:right; font-size:14px; color:#666; line-height:30px;}
        .area span i{ color:#f3478c;}
        .area em{ font-size:14px; color:#d80000;}
        .area ul{ display:inline-block; margin-left:-4px;}
        .area ul li{ margin-right:10px; display:inline-block;}
    </style>
</head>

<body style="background-color:#eff3f6;">
<div class="ex">
    <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">导出</button>
</div>
<form action="${pageContext.request.contextPath}/admin/searchTeacherByCondition" method="get">
    <div class="area"><span><i>*</i>精确查找：</span>
        <ul class="clearfix">
            <div id="parent1">
                教师身份：
                <input type="checkbox" <c:if test="${teacher.teacherType && update == null}"> checked="checked" </c:if>
                       name="teacherType">教师
                <input type="checkbox" <c:if test="${teacher.monitorType && update == null}"> checked="checked" </c:if>
                       name="monitorType">督导
                <input type="checkbox" <c:if test="${teacher.leaderType && update == null}"> checked="checked"  </c:if>
                       name="leaderType">领导
            </div>
            <div  id="parent">
                <select name="title" >
                    <option value="" >请选择教师标签</option>
                    <option <c:if test="${teacher.title == 'teachingStar' && update == null}"> selected="selected"</c:if>
                            value="teachingStar">教学新星</option>
                    <option <c:if test="${teacher.title == 'fastestProgress' && update == null}"> selected="selected"</c:if>
                            value="fastestProgress">进步最快</option>
                    <option <c:if test="${teacher.title == 'lastHelp' && update == null}"> selected="selected"</c:if>
                            value="lastHelp">末位帮扶</option>
                </select>
            </div>
            <button class="btn btn-look btn-xs" data-toggle="modal">查询</button>
        </ul>
    </div>

    <div class="data-div">
        <div class="row tableHeader">
            <div class="col-xs-2 ">
                序号
            </div>
            <div class="col-xs-1">
                教师工号
            </div>
            <div class="col-xs-2">
                姓名
            </div>
            <div class="col-xs-1">
                密码
            </div>
            <div class="col-xs-1">
                身份证号
            </div>
            <div class="col-xs-2">
                教师身份
            </div>
            <div class="col-xs-2">
                领导身份
            </div>
            <div class="col-xs-2">
                督导身份
            </div>
            <div class="col-xs-1">
                上次登录时间
            </div>
            <div class="col-xs-2">
                操作
            </div>
        </div>
        <c:if test="${isEmpty == 'true'}">
        <div id="mima">
            <font size="5">查询条件为空</font>
        </div>
        </c:if>
        <c:if test="${isEmpty == 'false'}">
                <%
                    List<Teacher> teacherList = (List<Teacher>) request.getSession().getAttribute("teacherPosList");
                    String teacherLastLoginTime = null;
                    int count = 0;
                    for (Teacher teach:teacherList) {
                        count++;
                        if(teach.getLastLoginTime() != null){
                            Date date = teach.getLastLoginTime();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                            teacherLastLoginTime = simpleDateFormat.format(date);
                        } else {
                            teacherLastLoginTime = "暂无记录";
                        }
                    %>
        <div class="tablebody">
            <div class="row">
                <div class="col-xs-2 ">
                    <%=count%>
                </div>
                <div class="col-xs-1">
                    <%=teach.getTeacherId()%>
                    <% String teachId = teach.getTeacherId(); %>
                </div>
                <div class="col-xs-2">
                    <%=teach.getTeacherName()%>
                </div>
                <div class="col-xs-1">
                    <%=teach.getPassword()%>
                </div>
                <div class="col-xs-1">
                    <%=teach.getIdCard()%>
                </div>
                <div class="col-xs-2">
                    <%
                        if(teach.isTeacherType()){%>
                    是
                    <%}else{
                    %>
                    否
                    <%
                        }
                    %>
                </div>
                <div class="col-xs-2">
                    <%
                        if(teach.isLeaderType()){%>
                    是
                    <%}else{
                    %>
                    否
                    <%
                        }
                    %>
                </div>
                <div class="col-xs-2">
                    <%
                        if(teach.isMonitorType()){%>
                    是
                    <%}else{
                    %>
                    否
                    <%
                        }
                    %>
                </div>
                <div class="col-xs-1">
                    <%=teacherLastLoginTime%>
                </div>
                <div class="col-xs-2">
                    <form action="${pageContext.request.contextPath}/admin/updateSingleTeacher?teacherId=<%=teachId%>" method="post">
                    </form>
                    <table>
                        <tr>
                            <form action="${pageContext.request.contextPath}/admin/updateSingleTeacher?teacherId=<%=teachId%>" method="post">
                                <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">修改</button>
                            </form>
                        </tr>
                        <tr>
                            <form action="${pageContext.request.contextPath}/admin/deleteSingleTeacher?teacherId=<%=teachId%>" method="post">
                                <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">删除</button>
                            </form>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
                <%
    }
%>
</form>

<table>
    <tr>
<font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第${page.pageNow} 页</font>
<form action="${pageContext.request.contextPath }/admin/searchTeacherByCondition?pageNow=1&teacherType=${teacher.teacherType}&monitorType=${teacher.monitorType}&leaderType=${teacher.leaderType}&title=${teacher.title}" method="post">
    <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">首页</button>
</form>
<c:choose>
    <c:when test="${page.pageNow - 1 > 0}">
        <form action="${pageContext.request.contextPath }/admin/searchTeacherByCondition?pageNow=${page.pageNow - 1}&teacherType=${teacher.teacherType}&monitorType=${teacher.monitorType}&leaderType=${teacher.leaderType}&title=${teacher.title}" method="post">
            <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">上一页</button>
        </form>
    </c:when>
    <c:when test="${page.pageNow - 1 <= 0}">
        <form action="${pageContext.request.contextPath }/admin/searchTeacherByCondition?pageNow=1&teacherType=${teacher.teacherType}&monitorType=${teacher.monitorType}&leaderType=${teacher.leaderType}&title=${teacher.title}" method="post">
            <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">上一页</button>
        </form>
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${page.totalPageCount==0}">
        <form action="${pageContext.request.contextPath }/admin/searchTeacherByCondition?pageNow=${page.pageNow}&teacherType=${teacher.teacherType}&monitorType=${teacher.monitorType}&leaderType=${teacher.leaderType}&title=${teacher.title}" method="post">
            <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">下一页</button>
        </form>
    </c:when>
    <c:when test="${page.pageNow + 1 < page.totalPageCount}">
        <form action="${pageContext.request.contextPath }/admin/searchTeacherByCondition?pageNow=${page.pageNow+1}&teacherType=${teacher.teacherType}&monitorType=${teacher.monitorType}&leaderType=${teacher.leaderType}&title=${teacher.title}" method="post">
            <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">下一页</button>
        </form>
    </c:when>
    <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
        <form action="${pageContext.request.contextPath }/admin/searchTeacherByCondition?pageNow=${page.totalPageCount}&teacherType=${teacher.teacherType}&monitorType=${teacher.monitorType}&leaderType=${teacher.leaderType}&title=${teacher.title}" method="post">
            <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">下一页</button>
        </form>
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${page.totalPageCount==0}">
        <form action="${pageContext.request.contextPath }/admin/searchTeacherByCondition?pageNow=${page.pageNow}&teacherType=${teacher.teacherType}&monitorType=${teacher.monitorType}&leaderType=${teacher.leaderType}&title=${teacher.title}" method="post">
            <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">尾页</button>
        </form>
    </c:when>
    <c:otherwise>
        <form action="${pageContext.request.contextPath }/admin/searchTeacherByCondition?pageNow=${page.totalPageCount}&teacherType=${teacher.teacherType}&monitorType=${teacher.monitorType}&leaderType=${teacher.leaderType}&title=${teacher.title}" method="post">
            <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">尾页</button>
        </form>
    </c:otherwise>
</c:choose>
    </tr>
</table>
</c:if>

</div>
</body>
</html>