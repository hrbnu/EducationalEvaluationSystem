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
        .MessageBoard{
            width: 100%;
            height: 500px;
            margin-top: 50px;
        }
        .btn{
            border: none;
            margin-right: 6%;
            margin-top: 10px;
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
        }
        .btn-look:focus{
            color: #fff;
            background-color:#5C5956;
            border-color:#d43f3a
        }
        .submit{
            text-align: center;
        }
    </style>
</head>
<body>
<div class="MessageBoard">
    <h1>导入学生信息</h1>
    <hr>
    <br>
    <c:choose>
        <c:when test="${flag == true}">
            <p style="color: red;text-align: center;">成功</p>
        </c:when>
        <c:otherwise>
            <p style="color: red;text-align: center;">*一键生成全部教师期末总评（需全体教师完成所有评价后才可生成）<p>
            <div class="submit">
                <form action="/general/comment" method="post">
                    <!--<input class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser" type="submit" value="确认生成">-->
                    <input class="btn btn-look btn-xs"  type="submit" value="确认生成">
                </form>
                <!--<button class="btn btn-look btn-xs" data-toggle="modal" data-target="#reviseUser">确认生成</button>-->
            </div>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>