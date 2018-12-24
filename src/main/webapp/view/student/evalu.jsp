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
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--360浏览器优先以webkit内核解析-->
    <meta name="renderer" content="webkit">

    <title>当前学期可评价课程</title>
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
            width: 49.9999999%;
            float: left;
        }
        .col-xs-2 {

            width: 16.66666667%;
            float: left;
        }
        .data-div{
            margin-bottom: 500px;
        }
        .Message{
            height: 30px;
            width: 75%;
        }
    </style>
</head>

<body style="background-color:#eff3f6;">

<div class="data-div">
    <form action="${path}/student/evaluScoreCaculate" method="get">
        <input type="hidden" name="studentId" value="${studentId}" />
        <input type="hidden" name="courseId" value="${courseId}" />
        <div class="row tableHeader">
            <div class="col-xs-2 ">
                序号
            </div>
            <div class="col-xs-1">
                评价指标
            </div>
            <div class="col-xs-2">
                分数值
            </div>
            <div class="col-xs-2">
                评价值
            </div>
        </div>


        <div class="tablebody">
            <c:forEach var="evaluateProblem" items="${requestScope.get('listEvaluateProblem')}" varStatus="status">

                <div class="row">
                    <div class="col-xs-2 ">
                        ${evaluateProblem.id}
                    </div>
                    <div class="col-xs-1">
                        ${evaluateProblem.evaluateProblemContent}
                    </div>
                    <div class="col-xs-2">
                        ${evaluateProblem.score}
                    </div>
                    <div class="col-xs-2">
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
                    </div>
                    <br />
                </div>
            </c:forEach>
            <div class="row">
                <div class="col-xs-2">
                    其他
                </div>
                <div class="col-xs-0"style="width: 80%;">
                    <textarea name="otherContent" class="Message"></textarea>
                </div>
            </div>
            <br />
        </div>
        <input class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser"style="float: right;" value="提交" name="提交" type="submit"/>
    </form>
</div>
</body>
</html>
