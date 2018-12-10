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
    <title>evalu/evalu</title>
</head>
<body>
<form action="" method="get">
    您最喜欢水果？<br /><br />
    <label><input name="Fruit" type="radio" value="" />苹果 </label>
    <label><input name="Fruit" type="radio" value="" />桃子 </label>
    <label><input name="Fruit" type="radio" value="" />香蕉 </label>
    <label><input name="Fruit" type="radio" value="" />梨 </label>
    <label><input name="Fruit" type="radio" value="" />其它 </label>
</form>


<div>
    <form action="" method="get">
        <c:forEach var="evaluateProblem" items="${requestScope.get('listEvaluateProblem')}" varStatus="status">

            <%--<p>${evaluateProblem.forWho}</p>--%>
            <p>${evaluateProblem.id}、${evaluateProblem.evaluateProblemContent}, 请打分，谢谢！</p><br />
            <label>
                <input name="${evaluateProblem.id}" type="radio" value="${evaluateProblem.score * 0.6}" />${evaluateProblem.score * 0.6}分
            </label>
            <label>
                <input name="${evaluateProblem.id}" type="radio" value="${evaluateProblem.score * 0.7}" />${evaluateProblem.score * 0.7}分
            </label>
            <label>
                <input name="${evaluateProblem.id}" type="radio" value="${evaluateProblem.score * 0.8}" />${evaluateProblem.score * 0.8}分
            </label>
            <label>
                <input name="${evaluateProblem.id}" type="radio" value="${evaluateProblem.score * 0.9}" />${evaluateProblem.score * 0.9}分
            </label>
            <label>
                <input name="${evaluateProblem.id}" type="radio" value="${evaluateProblem.score * 1.0}" />${evaluateProblem.score * 1.0}分
            </label>
        </c:forEach>
        <br />
        <input name="submit" type="submit">
    </form>
</div>
</body>
</html>
