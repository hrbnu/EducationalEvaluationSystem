<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>$Title$</title>
    </head>
    <body>
        <%--excel上传form表单格式--%>
        <%--<form action="/admin/addCourseByExcel" method="post" enctype="multipart/form-data">--%>
            <%--<input type="file" name="excel" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">--%>
            <%--<input type="submit" name="submit" value="submit">--%>
        <%--</form>--%>

        <%--测试输出100100的评价--%>
        <a href="/teacher/exportEvaluate/100100">下载</a>

        <a href="view/student.jsp">学生页面</a>
        <a href="view/teacher.jsp">教师页面</a>
    </body>
</html>