<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
    		<div class="ad-menu" id="ad-menu">
                <div class="ad-logo">
                <div class="ad-welcom">
                                <div class="ad-wel-img"><img src="/image/min_logo.png" height="100" width="100"></div>
                                <div class="ad-wel-text">
                                    <div class="font-wel">欢迎您！<strong>李春华</strong></div>
                                    <div class="font-wel"><a href="javascript:;"><strong>管理员</strong></a></div>
                                </div>
                            </div>
                </div>
                <div class="ad-list">
                    <ul>
                        <li>
                            <div class="li-item"><em class="scm li-ico ic1"></em>编辑学生信息<span class="scm arrow"></span></div>
                            <dl>
                                <dd>
                                    <a href="#" class="dd-item">查看修改学生信息<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="index_v1.html" data-index="1">查看修改学生信息</li>
                                    </ul>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">导入学生信息<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="/view/administrator/importStudent.jsp" data-index="2">导入学生信息</li>
                                    </ul>
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <div class="li-item"><em class="scm li-ico ic2"></em>编辑教师信息<span class="scm arrow"></span></div>
                            <dl>
                                <dd>
                                    <a href="#" class="dd-item">查看修改教师信息<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="index_v3.html" data-index="3">查看修改教师信息</li>
                                    </ul>
                                </dd>
                                <dd>	
                                    <a href="#" class="dd-item">导入教师信息<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="/view/administrator/importTeacher.jsp" data-index="4">导入教师信息</li>
                                    </ul>
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <div class="li-item"><em class="scm li-ico ic3"></em>编辑课程信息<span class="scm arrow"></span></div>
                            <dl>
                                <dd>
                                    <a href="#" class="dd-item">查看修改课程信息<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="index_v5.html" data-index="5">查看修改课程信息</li>
                                    </ul>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">导入课程信息<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="/view/administrator/importCourse.jsp" data-index="6">导入课程信息</li>
                                    </ul>
                                </dd>
                            </dl>
                        </li>
                        <li>
                            <div class="li-item"><em class="scm li-ico ic5"></em>期末总评<span class="scm arrow"></span></div>
                            <dl>
                                <dd>
                                    <a href="#" class="dd-item">查看期末总评<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="index_v7.html" data-index="7">查看修改期末总评</li>
                                    </ul>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">修改评分标准<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="index_v8.html" data-index="8">修改评分标准</li>
                                    </ul>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">生成期末总评<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="index_v9.html" data-index="9">生成期末总评</li>
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
                                        <li class="J_menuItem" href="index_v10.html" data-index="10">更改密码</li>
                                    </ul>
                                </dd>
                                <dd>
                                    <a href="#" class="dd-item">重置密码<span class="scm dd-ar"></span></a>
                                    <ul class="ad-item-list">
                                        <li class="J_menuItem" href="index_v11.html" data-index="11">重置密码</li>
                                    </ul>
                                </dd>
                            </dl>
                        </li>
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
                                <li class="active J_menuTab" data-id="index_v1.html">修改学生信息</li>
                            </ul>
                        </div>
                        <a href="javascript:;" class="scm jian-a next j_tabBg J_tabRight"></a>
                    </div>
                </div>
                <div class="ad-main-comment J_mainContent" id="ad-iframe">
                    <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="index_v1.html" frameborder="1" data-id="index_v1.html" seamless></iframe>
                </div>
    		</div>
    	</div>
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