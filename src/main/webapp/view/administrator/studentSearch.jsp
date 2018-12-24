<!DOCTYPE html>
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

    <title>学生信息</title>
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
<form action="${pageContext.request.contextPath}/admin/searchStudentByCondition" method="post">
    <div class="area"><span><i>*</i>精确查找：</span>
        <ul class="clearfix">
            <div id="parent">
                <select name="grade">
                    <option value="0">请选择学生年级</option>
                    <option <c:if test="${student.grade == '1' && update == null}"> selected="selected" </c:if>
                            value="1">大一</option>
                    <option <c:if test="${student.grade == '2' && update == null}"> selected="selected" </c:if>
                            value="2">大二</option>
                    <option <c:if test="${student.grade == '3' && update == null}"> selected="selected" </c:if>
                            value="3">大三</option>
                    <option <c:if test="${student.grade == '4' && update == null}"> selected="selected" </c:if>
                            value="4">大四</option>
                    <option <c:if test="${student.grade == '5' && update == null}"> selected="selected" </c:if>
                            value="5">已毕业</option>
                </select>
            </div>
            <div id="parent">
                <select name="department">
                    <option value="">请选择学生专业</option>
                    <option <c:if test="${student.department == '计算机科学与技术' && update == null}"> selected="selected" </c:if>
                            value="计算机科学与技术">计算机科学与技术</option>
                    <option <c:if test="${student.department == '数字媒体技术' && update == null}"> selected="selected" </c:if>
                            value="数字媒体技术">数字媒体技术</option>
                    <option <c:if test="${student.department == '软件工程' && update == null}"> selected="selected" </c:if>
                            value="软件工程">软件工程</option>
                    <option <c:if test="${student.department == '物联网工程' && update == null}"> selected="selected" </c:if>
                            value="物联网工程">物联网工程</option>
                </select>
            </div>
            <div  id="parent">
                <select name="classId">
                    <option value="0">请选择学生班级</option>
                    <option <c:if test="${student.classId == '1' && update == null}"> selected="selected" </c:if>
                            value="1">1</option>
                    <option <c:if test="${student.classId == '2' && update == null}"> selected="selected" </c:if>
                            value="2">2</option>
                    <option <c:if test="${student.classId == '3' && update == null}"> selected="selected" </c:if>
                            value="3">3</option>
                    <option <c:if test="${student.classId == '4' && update == null}"> selected="selected" </c:if>
                            value="4">4</option>
                    <option <c:if test="${student.classId == '5' && update == null}"> selected="selected" </c:if>
                            value="5">5</option>
                    <option <c:if test="${student.classId == '6' && update == null}"> selected="selected" </c:if>
                            value="6">6</option>
                    <option <c:if test="${student.classId == '7' && update == null}"> selected="selected" </c:if>
                            value="7">7</option>
                    <option <c:if test="${student.classId == '8' && update == null}"> selected="selected" </c:if>
                            value="8">8</option>
                    <option <c:if test="${student.classId == '9' && update == null}"> selected="selected" </c:if>
                            value="9">9</option>
                    <option <c:if test="${student.classId == '10' && update == null}"> selected="selected" </c:if>
                            value="10">10</option>
                    <option <c:if test="${student.classId == '11' && update == null}"> selected="selected" </c:if>
                            value="11">11</option>
                    <option <c:if test="${student.classId == '12' && update == null}"> selected="selected" </c:if>
                            value="12">12</option>
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
            <div class="col-xs-2">
                年级
            </div>
            <div class="col-xs-1">
                专业
            </div>
            <div class="col-xs-2">
                班级
            </div>
            <div class="col-xs-1">
                学号
            </div>
            <div class="col-xs-2">
                姓名
            </div>
            <div class="col-xs-1">
                密码
            </div>
            <div class="col-xs-1">
                身份证号码
            </div>
            <div class="col-xs-2">
                状态
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
        <c:forEach items="${studentPosList}" var="item" varStatus="status">
        <div class="tablebody">
            <div class="row">
                <div class="col-xs-2 ">
                        ${(page.pageNow - 1) * page.pageSize + status.index + 1}
                </div>
                <div class="col-xs-2">
                        ${item.grade}
                </div>
                <div class="col-xs-1">
                        ${item.department}
                </div>
                <div class="col-xs-2">
                        ${item.classId}
                </div>
                <div class="col-xs-1">
                        ${item.studentId}
                </div>
                <div class="col-xs-2">
                        ${item.name}
                </div>
                <div class="col-xs-1">
                        ${item.password}
                </div>
                <div class="col-xs-1">
                        ${item.idCard}
                </div>
                <div class="col-xs-2">
                    <c:if test="${item.graduation == 'true'}">
                        已毕业
                    </c:if>
                    <c:if test="${item.graduation == 'false'}">
                        在校
                    </c:if>
                </div>
                <div class="col-xs-2">
                    <s:form action="${pageContext.request.contextPath}/admin/updateSingleStudent?studentId=${item.studentId}" method="post">
                    </s:form>
                    <table>
                        <tr>
                            <s:form action="${pageContext.request.contextPath}/admin/updateSingleStudent?studentId=${item.studentId}" method="post">
                                <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">修改</button>
                            </s:form>
                        </tr>
                        <tr>
                            <s:form action="${pageContext.request.contextPath}/admin/deleteSingleStudent?studentId=${item.studentId}" method="post">
                                <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">删除</button>
                            </s:form>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        </c:forEach>

</form>

<table>
    <tr>
<font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第${page.pageNow} 页</font>
    <form action="${pageContext.request.contextPath }/admin/searchStudentByCondition?pageNow=1&grade=${student.grade}&department=${student.department}&classId=${student.classId}" method="post">
        <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">首页</button>
    </form>
<c:choose>
    <c:when test="${page.pageNow - 1 > 0}">
        <form action="${pageContext.request.contextPath }/admin/searchStudentByCondition?pageNow=${page.pageNow - 1}&grade=${student.grade}&department=${student.department}&classId=${student.classId}" method="post">
            <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">上一页</button>
        </form>
    </c:when>
    <c:when test="${page.pageNow - 1 <= 0}">
        <form action="${pageContext.request.contextPath }/admin/searchStudentByCondition?pageNow=1&grade=${student.grade}&department=${student.department}&classId=${student.classId}" method="post">
            <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">上一页</button>
        </form>
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${page.totalPageCount==0}">
        <form action="${pageContext.request.contextPath }/admin/searchStudentByCondition?pageNow=${page.pageNow}&grade=${student.grade}&department=${student.department}&classId=${student.classId}" method="post">
            <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">下一页</button>
        </form>
    </c:when>
    <c:when test="${page.pageNow + 1 < page.totalPageCount}">
        <form action="${pageContext.request.contextPath }/admin/searchStudentByCondition?pageNow=${page.pageNow+1}&grade=${student.grade}&department=${student.department}&classId=${student.classId}" method="post">
            <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">下一页</button>
        </form>
    </c:when>
    <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
        <form action="${pageContext.request.contextPath }/admin/searchStudentByCondition?pageNow=${page.totalPageCount}&grade=${student.grade}&department=${student.department}&classId=${student.classId}" method="post">
            <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">下一页</button>
        </form>
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${page.totalPageCount==0}">
        <form action="${pageContext.request.contextPath }/admin/searchStudentByCondition?pageNow=${page.pageNow}&grade=${student.grade}&department=${student.department}&classId=${student.classId}" method="post">
            <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">尾页</button>
        </form>
    </c:when>
    <c:otherwise>
        <form action="${pageContext.request.contextPath }/admin/searchStudentByCondition?pageNow=${page.totalPageCount}&grade=${student.grade}&department=${student.department}&classId=${student.classId}" method="post">
            <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">尾页</button>
        </form>
    </c:otherwise>
</c:choose>
    </tr>
</table>
</c:if>
</div>
</body>
<script src="js/jquery.min.js"></script>
<script>
    $(function(){
        function select_simulated(select_style,bomb_con_style){
            $(document).click(function(){
                $(bomb_con_style).hide();
            })
            $(select_style).live('click',function(e){
                var thisinput=$(this);
                var local=$(this).position();
                var bomb_con=$(bomb_con_style);
                $(this).parents("li").siblings().find(bomb_con_style).hide();
                $(this).parent().find(bomb_con_style).width($(this).width());//下拉框的宽度
                $(this).parent().find(bomb_con_style).show();
                e?e.stopPropagation():event.cancelBubble = true;
                bomb_con.find("dd").click(function(e){
                    var bomb_text=$(this).text();
                    $(this).addClass("selected").siblings().removeClass("selected");
                    $(this).parents(bomb_con_style).hide();
                    $(this).parents("li").find(select_style).val(bomb_text);
                    e?e.stopPropagation():event.cancelBubble = true;

                });
            });
            return false;
        }
        select_simulated(".provin_select",".provin_con");


        $(".local").focus(function(){
            $(this).addClass("local3");
        });
        $(".local").blur(function(){
            $(this).removeClass("local3");
        });
    })
</script>
</html>