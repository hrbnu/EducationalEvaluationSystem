<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>导入</title>
    <style type="text/css">
        h1{
            margin-left: 5%;
            font-size: larger;
        }
        hr{
            width: 90%;
        }
        li {
            list-style-type:none;
            float: left;
            padding-left: 38px;
            color: red;
        }
        .row{
            margin-left: 5%;
        }
        .MessageBoard{
            width: 100%;
            height: 500px;
            margin-top: 50px;
        }
        .partA{
            margin-left: 5%;
        }
        .partB{
            margin-left: 5%;
        }
        .partC{
            margin-left: 10%;
            height: 8px
        }
        .btn{
            border: none;
            float: right;
            margin-right: 15%;
            margin-top: 10px;
        }
        .btn-look {

            color: #fff;
            background-color: #d9534f;
        }
        .btn-xs, .btn {
            padding: 10px 15px;
            font-size: 12px;
            line-height: 1.083;
            border-radius: 3px;
        }
        .btn-look:focus{
            color: #fff;
            background-color:#5C5956;
            border-color:#d43f3a
        }
    </style>
</head>
<body>
<div class="MessageBoard">
    <h1>修改评分标准</h1>
    <hr>
    <br>
    <div class="partC">
        <ul>
            <li> 学生评分 </li>
            <li> 同行评分 </li>
            <li> 教师评分 </li>
            <li> 领导评分 </li>
        </ul>
    </div>
    <br>
    <form action="/modify/update">
        <div class="partA">
            必修课评分标准：
            <input type="text" name="studentWeight">%+
            <input type="text" name="teacherWeight">%+
            <input type="text" name="leaderWeight">%+
            <input type="text" name="myselfWeight">%
        </div>
        <br>
        <div class="partB">
            选修课评分标准：
            <input type="text" name="ElectivestudentWeight" >%+
            <input type="text" name="ElectiveteacherWeight" >%+
            <input type="text" name="ElectiveleaderWeight" >%+
            <input type="text" name="ElectivemyselfWeight" >%
        </div>
        <div class="submit">
            <input class="btn btn-look btn-xs" type="submit" value="确认">
            <!--<button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">确认修改</button>-->
        </div>
        <c:choose>
            <c:when test="${flag==true}">
                <p style="color: red; text-align: center">成功</p>
            </c:when>
            <c:otherwise><p style="color: red; text-align: center">请输入完整的信息</p></c:otherwise>
        </c:choose>
    </form>
</div>
</body>
</html>