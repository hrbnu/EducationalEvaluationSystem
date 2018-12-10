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
    您喜欢的水果？<br /><br />
    <label><input name="Fruit" type="checkbox" value="" />苹果 </label>
    <label><input name="Fruit" type="checkbox" value="" />桃子 </label>
    <label><input name="Fruit" type="checkbox" value="" />香蕉 </label>
    <label><input name="Fruit" type="checkbox" value="" />梨 </label>
</form>

<div>
    <c:forEach var="evaluateProblem" items="${requestScope.get('listEvaluateProblem')}" varStatus="status">
        <div>
            <p>${evaluateProblem.id}</p>
            <p>${evaluateProblem.evaluateProblemContent}</p>
            <p>${evaluateProblem.forWho}</p>
            <p>${evaluateProblem.score}</p>
        </div>
    </c:forEach>
</div>
</body>
</html>
