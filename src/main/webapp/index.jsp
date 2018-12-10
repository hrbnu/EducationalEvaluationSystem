<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>$Title$</title>
    </head>
    <body>
        <form action="/admin/addStudentByExcel" method="post" enctype="multipart/form-data">
            <input type="file" name="excel" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
            <input type="submit" name="submit" value="submit">
        </form>
    </body>
</html>