<%--
  Created by IntelliJ IDEA.
  User: yaque
  Date: 2018/12/10
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<head>
    <title>当前课程评价</title>
</head>
<body>
<%--<form action="" method="get">--%>
    <%--您最喜欢水果？<br /><br />--%>
    <%--<label><input name="Fruit" type="radio" value="" />苹果 </label>--%>
    <%--<label><input name="Fruit" type="radio" value="" />桃子 </label>--%>
    <%--<label><input name="Fruit" type="radio" value="" />香蕉 </label>--%>
    <%--<label><input name="Fruit" type="radio" value="" />梨 </label>--%>
    <%--<label><input name="Fruit" type="radio" value="" />其它 </label>--%>
<%--</form>--%>
<%--<label>1、普通下拉列表菜单</label>--%>
<%--<select name="">--%>
    <%--<option value="0">DIVCSS5</option>--%>
    <%--<option value="1">DIVCSS5</option>--%>
<%--</select>--%>

<div>
    <form action="${path}/student/evaluScoreCaculate" method="get">
        <input type="hidden" name="studentId" value="${studentId}" />
        <input type="hidden" name="courseId" value="${courseId}" />
        <c:forEach var="evaluateProblem" items="${requestScope.get('listEvaluateProblem')}" varStatus="status">
            <label>${evaluateProblem.id}、${evaluateProblem.evaluateProblemContent}, 请打分，谢谢！</label>
            <label>${evaluateProblem.score}</label>
            <select name="${evaluateProblem.id}">
                <option value="${evaluateProblem.score * 0.1}">${evaluateProblem.score * 0.1}分</option>
                <option value="${evaluateProblem.score * 0.2}">${evaluateProblem.score * 0.2}分</option>
                <option value="${evaluateProblem.score * 0.3}">${evaluateProblem.score * 0.3}分</option>
                <option value="${evaluateProblem.score * 0.4}">${evaluateProblem.score * 0.4}分</option>
                <option value="${evaluateProblem.score * 0.5}">${evaluateProblem.score * 0.5}分</option>
                <option value="${evaluateProblem.score * 0.6}">${evaluateProblem.score * 0.6}分</option>
                <option value="${evaluateProblem.score * 0.7}">${evaluateProblem.score * 0.7}分</option>
                <option value="${evaluateProblem.score * 0.8}">${evaluateProblem.score * 0.8}分</option>
                <option value="${evaluateProblem.score * 0.9}">${evaluateProblem.score * 0.9}分</option>
                <option value="${evaluateProblem.score * 1.0}">${evaluateProblem.score * 1.0}分</option>
            </select>
            <br />
        </c:forEach>
        <label>其他</label>
        <input type="text" name="otherContent"/>
        <br />
        <input name="提交" type="submit"/>
    </form>
</div>

<%--<div>--%>
    <%--<form action="" method="get">--%>
        <%--<c:forEach var="evaluateProblem" items="${requestScope.get('listEvaluateProblem')}" varStatus="status">--%>

            <%--&lt;%&ndash;<p>${evaluateProblem.forWho}</p>&ndash;%&gt;--%>
            <%--<p>${evaluateProblem.id}、${evaluateProblem.evaluateProblemContent}, 请打分，谢谢！</p><br />--%>
            <%--<label>--%>
                <%--<input name="${evaluateProblem.id}" type="radio" value="${evaluateProblem.score * 0.6}" />${evaluateProblem.score * 0.6}分--%>
            <%--</label>--%>
            <%--<label>--%>
                <%--<input name="${evaluateProblem.id}" type="radio" value="${evaluateProblem.score * 0.7}" />${evaluateProblem.score * 0.7}分--%>
            <%--</label>--%>
            <%--<label>--%>
                <%--<input name="${evaluateProblem.id}" type="radio" value="${evaluateProblem.score * 0.8}" />${evaluateProblem.score * 0.8}分--%>
            <%--</label>--%>
            <%--<label>--%>
                <%--<input name="${evaluateProblem.id}" type="radio" value="${evaluateProblem.score * 0.9}" />${evaluateProblem.score * 0.9}分--%>
            <%--</label>--%>
            <%--<label>--%>
                <%--<input name="${evaluateProblem.id}" type="radio" value="${evaluateProblem.score * 1.0}" />${evaluateProblem.score * 1.0}分--%>
            <%--</label>--%>
        <%--</c:forEach>--%>
        <%--<br />--%>
        <%--<input name="submit" type="submit">--%>
    <%--</form>--%>
<%--</div>--%>
</body>
</html>
