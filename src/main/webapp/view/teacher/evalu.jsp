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
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生投诉留言板</title>
    <style type="text/css">
        h1{
            margin-left: 5%;
            font-size: larger;
        }
        h4{
            margin-left: 5%;
            margin-bottom: 0px;
        }
        hr{
            width: 90%;
        }
        .ex{
            float: right;
            margin-right: 10%;
        }
        .r{
            margin-left: 5%;
        }
        .MessageBoard{
            width: 100%;
            height: 500px;
            margin-top: 50px;
        }
        .Message{
            width: 95%;
            height: 19px;
        }
        .c1{
            float: left;
        }
        .c2 {
            margin-left:5px ;
            float: left;
        }
        .data-div{
            width: 90%;
            margin-left: 5%;
        }
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
            width: 50%;
            float: left;
        }
        .col-xs-2 {

            width: 16.666%;
            float: left;
        }
        .x1{
            width: 80%;
            float: left;
        }
        .x2 {

            width: 10%;
            float: left;
        }
    </style>
</head>
<body>
<c:set var="course" value="${requestScope.get('course')}"></c:set>
    <div class="MessageBoard">
        <div class="ex">
            <button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">导出</button>
        </div>
        <h1>课堂教学评价表</h1>
        <hr>
        <div class="d">
            <div class="r">
                <div class="c1 ">
                    教职工工号 :
                </div>
                <div class="c2">
                    ${teacherId}
                </div>
                <div class="c1">
                    |课程名称 :
                </div>
                <div class="c2">
                    ${course.courseName}
                </div>
                <div class="c1">
                    |课程ID :
                </div>
                <div class="c2">
                    ${courseId}
                </div>
                <div class="c1">
                    |教授学期 :
                </div>
                <div class="c2">
                    ${course.semester}
                </div>
            </div>
        </div>
        <br>
        <p></p>
        <h4>同行评价</h4>
        <div class="data-div">
            <div class="row tableHeader">
                <div class="col-xs-2 ">
                    序号
                </div>
                <div class="col-xs-1">
                    评价
                </div>
                <div class="col-xs-2">
                    分数值
                </div>
                <div class="col-xs-2">
                    平均评价值
                </div>
            </div>

            <div class="tablebody">
                <form action="${path}/teacher/evaluScoreCaculate" method="get">
                    <input type="hidden" name="teacherId" value="${teacherId}" />
                    <input type="hidden" name="courseId" value="${courseId}" />
                    <input type="hidden" name="flag" value="${flag}" />
                    <c:forEach var="evaluateProblem" items="${requestScope.get('listEvaluateProblem')}" varStatus="status">
                    <div class="row">
                        <div class="col-xs-2">${evaluateProblem.id}</div>
                        <div class="col-xs-1">${evaluateProblem.evaluateProblemContent}</div>
                        <div class="col-xs-2">${evaluateProblem.score}</div>
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
                    </div>
                    </c:forEach>
                    <div class="row">
                        <div class="x2">
                            其他
                        </div>
                        <div class="x1">
                            <textarea name="otherContent" class="Message" placeholder="文字性评价内容"></textarea>
                        </div>
                        <div class="x2">
                            <input name="提交" type="submit"/>
                        </div>
                    </div>

                </form>
            </div>
        </div>
        <br>
        <p></p>
        <hr>
    </div>
</body>
</html>
