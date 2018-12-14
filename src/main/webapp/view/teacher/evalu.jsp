<%--
  Created by IntelliJ IDEA.
  User: yaque
  Date: 2018/12/14
  Time: 13:48
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

<div>
    <form action="${path}/teacher/evaluScoreCaculate" method="get">
        <input type="hidden" name="teacherId" value="${teacherId}" />
        <input type="hidden" name="courseId" value="${courseId}" />
        <input type="hidden" name="flag" value="${flag}" />
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

