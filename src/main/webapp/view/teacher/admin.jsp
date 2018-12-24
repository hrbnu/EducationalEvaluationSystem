<%@ page import="edu.cs.hrbnu.model.Teacher" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %><!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link href="/css/public.css" type="text/css" rel="stylesheet">
        <link href="/css/houtai.css" type="text/css" rel="stylesheet">
        <link href="/css/smartMenu.css" type="text/css" rel="stylesheet">
        <title>哈师大教评系统</title>
    </head>
    <body>
    	<div id="admin">
    		<div class="ad-menu" id="ad-menu    ">
                <div class="ad-logo">
                <div class="ad-welcom">
                                <div class="ad-wel-img"><img src="/view/image/logo.png" style="height:100px;width:100px;" ></div>
                                <div class="ad-wel-text">
                                    <div class="font-wel">欢迎您！<strong>${sessionScope.TeacherInfo.teacherName}</strong></div>
                                    <div class="font-wel"><a href="javascript:;"><strong>
                                        <%
                                            Teacher teacher = (Teacher)request.getSession().getAttribute("TeacherInfo");
                                            if(teacher.isMonitorType()){
                                                out.print("督导");
                                            }else{
                                                if(teacher.isLeaderType()){
                                                    out.print("领导");
                                                }else{
                                                    out.print(teacher.getTitle());
                                                }
                                            }
                                        %>
                                    </strong></a></div>
                                </div>
                            </div>
                </div>
                <div class="ad-list">
                    <ul>
                        <li>
                            <div class="li-item"><em class="scm li-ico ic1"></em>我的评价<span class="scm arrow"></span></div>
                            <dl>
                                <dd>
                                    <a href="#" class="dd-item">当前学期课程评价详情<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="/teacher/courseform/${sessionScope.teacherId}" data-index="1">当前学期课程评价详情</li>
                                    </ul>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">历史学期评价结果<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="index_v2.html" data-index="2">历史学期评价结果</li>
                                    </ul>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">我的投诉<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="index_v3.html" data-index="3">我的投诉</li>
                                    </ul>
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <div class="li-item"><em class="scm li-ico ic2"></em>自我评价<span class="scm arrow"></span></div>
                            <dl>
                                <dd>
                                    <a href="#" class="dd-item">当前学期可评价课程<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="index_v4.html" data-index="4">当前学期可评价课程</li>
                                    </ul>
                                </dd>
                                <dd>	
                                    <a href="#" class="dd-item">历史评价<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="index_v5.html" data-index="5">历史评价</li>
                                    </ul>
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <div class="li-item"><em class="scm li-ico ic3"></em>同行评价<span class="scm arrow"></span></div>
                            <dl>
                                <dd>
                                    <a href="#" class="dd-item">当前学期可评价课程<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="<%=appPath%>/teacher/getNeedToEvaluateCourseByTeacher" data-index="6">当前学期可评价课程</li>
                                    </ul>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">提交听课申请<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="<%=appPath%>/teacher/applicatinListen" data-index="7">提交听课申请</li>
                                    </ul>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">审核听课申请<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="<%=appPath%>/teacher/confirm" data-index="8">审核听课申请</li>
                                    </ul>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">历史评价<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="index_v9.html" data-index="9">历史评价</li>
                                    </ul>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">导出评价表<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="/view/teacher/exportEvaluate.jsp" data-index="9">历史评价</li>
                                    </ul>
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <div class="li-item"><em class="scm li-ico ic5"></em>我的标签 <span class="scm arrow"></span></div>
                            <dl>
                                <dd>
                                    <a href="#" class="dd-item">当前所属标签<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="index_v10.html" data-index="10">当前所属标签</li>
                                    </ul>
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <div class="li-item"><em class="scm li-ico ic4"></em>个人信息<span class="scm arrow"></span></div>
                            <dl>
                                <dd>
                                    <a href="#" class="dd-item">更改密码<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="index_v11.html" data-index="11">更改密码</li>
                                    </ul>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">重置密码<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="index_v12.html" data-index="12">重置密码</li>
                                    </ul>
                                </dd>
                            </dl>
                        </li>

                        <c:if test="${sessionScope.TeacherInfo.leaderType == true}">
                            <li>
                                <div class="li-item"><em class="scm li-ico ic2"></em>查看评价<span class="scm arrow"></span></div>
                                <dl>
                                    <dd>
                                        <a href="#" class="dd-item">查看所有教师评价<span class="scm dd-ar"></span></a>
                                        <ul class="ad-item-list">
                                            <li class="J_menuItem" href="/teacher/teacherform" data-index="4">查看所有教师评价</li>
                                        </ul>
                                    </dd>
                                    <dd>
                                        <a href="#" class="dd-item">查看所有教师投诉<span class="scm dd-ar"></span></a>
                                        <ul class="ad-item-list">
                                            <li class="J_menuItem" href="/teacher/teacherComplaintForm" data-index="5">查看所有教师投诉</li>
                                        </ul>
                                    </dd>
                                </dl>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>
    		<div class="ad-comment-box" id="ad-comment">
                <div class="ad-top-comment">
                    <div class="ad-message">
                        <div class="ad-top-left">
                            <div class="ad-change-btn"><a id="ad-list" href="javascript:;" class="scm ad-list-btn"></a></div>
                            <div class="ad-search-box clear">
                                <div class="ad-search-sel">
                                    <select>
                                        <option>A类</option>
                                        <option>B类</option>
                                        <option>C类</option>
                                        <option>D类</option>
                                    </select>
                                </div>
                                <div class="ad-search-cha">
                                    <input type="text" class="ad-search-input" placeholder="请输入你要查找的内容">
                                    <input type="submit" class="scm ad-search-btn" value=""> 
                                </div>
                            </div>
                        </div>
                        <div class="ad-top-right">
                            <div class="ad-notice">
                                <ul>
                                    <li>
                                        <a href="javascript:;" class="scm nt1"><span class="scm nt-count dot">12</span></a>
                                    </li>
                                    <li>
                                        <a href="javascript:;" class="scm nt2"><span class="scm nt-count dot">12</span></a>
                                    </li>
                                    <li>
                                        <a href="javascript:;" class="scm nt3"><span class="scm nt-count dot">12</span></a>
                                    </li>
                                </ul>
                            </div>
                            <div class="ad-welcom">
                                <div class="ad-wel-text">
                                    <div class="font-wel"><a href="javascript:;"><strong>【退出】</strong></a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="ad-main-nav-box">
                        <ul id="breadcrumbs-three">
                            <li title="首页"><a href="javascript:;" class="dot">首页</a></li>
                        </ul>
                        <a href="javascript:;" class="scm jian-a J_mainLeft main-sel pre"></a>
                        <div class="ad-main-wraper .J_menuItems">
                            <ul class="ad-main-list" id="ad-main">
                            </ul>
                        </div>
                        <a href="javascript:;" class="scm jian-a J_mainRight next"></a>
                    </div>
                    <div class="ad-sub-nav-box content-tabs">
                        <a href="javascript:;" class="scm jian-a sub-sel pre j_tabBg J_tabLeft"></a>
                        <div class="ad-sub-wraper page-tabs J_menuTabs">
                            <ul class="ad-sub-list page-tabs-content">
                                <li class="active J_menuTab" data-id="index_v1.html">当前学期课评价课程</li>
                            </ul>
                        </div>
                        <a href="javascript:;" class="scm jian-a next j_tabBg J_tabRight"></a>
                    </div>
                </div>
                <div class="ad-main-comment J_mainContent" id="ad-iframe">
                    <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="<%=appPath%>/teacher/getNeedToEvaluateCourseByTeacher" frameborder="1" data-id="index_v1.html" seamless></iframe>
                </div>
    		</div>
    	</div>
        <p>${sessionScope.TeacherInfo.leaderType}</p>
        <%--&lt;%&ndash;测试评价&ndash;%&gt;--%>
        <%--<a href="/teacher/courseform/${sessionScope.teacherId}">ceshi </a>--%>
        <%--&lt;%&ndash;测试投诉&ndash;%&gt;--%>
        <%--<a href="/teacher/courseFormComplaint/${sessionScope.teacherId}">投诉</a>--%>
        <script type="text/javascript" src="/js/jquery.min.js"></script>
        <script type="text/javascript" src="/js/contabs.js"></script>
        <script type="text/javascript" src="/js/maintabs.js"></script>
        <script type="text/javascript" src="/js/jquery-smartMenu-min.js"></script>
        <script type="text/javascript" src="/js/jquery.nicescroll.min.js"></script>
        <script type="text/javascript">
            /*$(function(){
            	$(".dd-item").click(function() {
                    $(".dd-item").removeClass("dd-item-active");
                    $(this).addClass("dd-item");
                    var itmeObj = $(".dd-item").find("img");
                    itmeObj.each(function() {
                        var items = $(this).attr("src");
                        items = items.replace("_grey.png", ".png");
                        items = items.replace(".png", "_grey.png")
                        $(this).attr("src", items);
                    });
                    var attrObj = $(this).find("img").attr("src");
                    ;
                    attrObj = attrObj.replace("_grey.png", ".png");
                    $(this).find("img").attr("src", attrObj);
                });*/
                $(".ad-menu").niceScroll({cursorborder:"0 none",cursorcolor:"#1a1a19",cursoropacitymin:"0",boxzoom:false});
            // })
            	/*$('.tree > ul > li: first').show();*/
        </script>

    </body>
</html>