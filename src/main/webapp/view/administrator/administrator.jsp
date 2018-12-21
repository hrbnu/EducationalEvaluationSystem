<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%-- 学生 --%>
        <form action="${pageContext.request.contextPath }/admin/searchStudentByCondition" method="post">
            <input type="submit" value="查看学生信息" name="submit">
        </form>
        <form action="${pageContext.request.contextPath }/admin/deleteSingleStudent" method="post">
            <input type="submit" value="删除学生信息" name="submit">
        </form>
        <form action="${pageContext.request.contextPath }/admin/updateSingleStudent" method="post">
            <input type="submit" value="修改学生信息" name="submit">
        </form>
        <form action="${pageContext.request.contextPath }/admin/insertSingleStudent" method="post">
            <input type="submit" value="插入学生信息" name="submit">
        </form>
        <%-- 教师 --%>
        <form action="${pageContext.request.contextPath }/admin/searchTeacherByCondition" method="post">
            <input type="submit" value="查看教师信息" name="submit">
        </form>
        <form action="${pageContext.request.contextPath }/admin/deleteSingleTeacher" method="post">
            <input type="submit" value="删除教师信息" name="submit">
        </form>
        <form action="${pageContext.request.contextPath }/admin/updateSingleTeacher" method="post">
            <input type="submit" value="修改教师信息" name="submit">
        </form>
        <form action="${pageContext.request.contextPath }/admin/insertSingleTeacher" method="post">
            <input type="submit" value="插入教师信息" name="submit">
        </form>
        <%-- 课程--%>
        <form action="${pageContext.request.contextPath }/admin/insertSingleCourse" method="post">
            <input type="submit" value="插入课程信息" name="submit">
        </form>

        <%-- excel导入 --%>
        <%-- excel导入教师表 --%>
        <form action="/admin/addTeacherByExcel" method="post" enctype="multipart/form-data">
            <input type="file" name="excel" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
            <input type="submit" name="submit" value="导入教师表">
        </form>
        <%-- excel导入学生表 --%>
        <form action="/admin/addStudentByExcel" method="post" enctype="multipart/form-data">
            <input type="file" name="excel" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
            <input type="submit" name="submit" value="导入学生表">
        </form>
        <%--excel导入课程表--%>
        <form action="/admin/addCourseByExcel" method="post" enctype="multipart/form-data">
            <input type="file" name="excel" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
            <input type="submit" name="submit" value="导入课程表">
        </form>
</body>
</html>
