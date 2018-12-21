<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>学生信息表</h3>
<form action="${pageContext.request.contextPath}/admin/deleteSingleStudent" method="post">
    <select name="grade">
        <option value="0" disabled selected style='display:none;'>请选择学生年级</option>
        <option value="1">大一</option>
        <option value="2">大二</option>
        <option value="3">大三</option>
        <option value="4">大四</option>
        <option value="5">已毕业</option>
    </select>
    <select name="department">
        <option value="" disabled selected style='display:none;'>请选择学生专业</option>
        <option value="计算机科学与技术">计算机科学与技术</option>
        <option value="数字媒体技术">数字媒体技术</option>
        <option value="软件工程">软件工程</option>
        <option value="物联网工程">物联网工程</option>
    </select>
    <select name="classId">
        <option value="0" disabled selected style='display:none;'>请选择学生班级</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
    </select>
    <input type="submit" value="查询">
    <c:if test="${isEmpty == 'true'}">
         <h2>查询条件为空</h2>
    </c:if>
    <c:if test="${isEmpty == 'false'}">
    <table width="100%" border=1>
        <tr>
            <td>序号</td>
            <td>年级</td>
            <td>专业</td>
            <td>班级</td>
            <td>学号</td>
            <td>姓名</td>
            <td>身份证号</td>
            <td>密码</td>
            <td>状态</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${studentPosList}" var="item" varStatus="status">
            <tr>
                <td>${(page.pageNow - 1) * page.pageSize + status.index + 1}</td>
                <td>${item.grade}</td>
                <td>${item.department}</td>
                <td>${item.classId}</td>
                <td>${item.studentId}</td>
                <td>${item.name}</td>
                <td>${item.idCard}</td>
                <td>${item.password}</td>
                <td>
                    <c:if test="${item.graduation == 'true'}">
                        已毕业
                    </c:if>
                    <c:if test="${item.graduation == 'false'}">
                        在校
                    </c:if>
                </td>
                <td><a href="${pageContext.request.contextPath }/admin/deleteSingleStudent?studentId=${item.studentId}">删除</a></td>
            </tr>
        </c:forEach>
    </table>

    <font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第${page.pageNow} 页</font>
    <a href="${pageContext.request.contextPath }/admin/deleteSingleStudent?pageNow=1">首页</a>
    <c:choose>
        <c:when test="${page.pageNow - 1 > 0}">
            <a href="${pageContext.request.contextPath }/admin/deleteSingleStudent?pageNow=${page.pageNow - 1}">上一页</a>
        </c:when>
        <c:when test="${page.pageNow - 1 <= 0}">
            <a href="${pageContext.request.contextPath }/admin/deleteSingleStudent?pageNow=1">上一页</a>
        </c:when>
    </c:choose>

    <c:choose>
        <c:when test="${page.totalPageCount==0}">
            <a href="${pageContext.request.contextPath }/admin/deleteSingleStudent?pageNow=${page.pageNow}">下一页</a>
        </c:when>
        <c:when test="${page.pageNow + 1 < page.totalPageCount}">
            <a href="${pageContext.request.contextPath }/admin/deleteSingleStudent?pageNow=${page.pageNow+1}">下一页</a>
        </c:when>
        <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
            <a href="${pageContext.request.contextPath }/admin/deleteSingleStudent?pageNow=${page.totalPageCount}">下一页</a>
        </c:when>
    </c:choose>

    <c:choose>
        <c:when test="${page.totalPageCount==0}">
            <a href="${pageContext.request.contextPath }/admin/deleteSingleStudent?pageNow=${page.pageNow}">尾页</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath }/admin/deleteSingleStudent?pageNow=${page.totalPageCount}">尾页</a>
        </c:otherwise>
    </c:choose>
    </c:if>
</form>
</body>
</html>
