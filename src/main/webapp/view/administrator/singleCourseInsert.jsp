<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/admin/insertSingleCourse" method="post">
    课程名：<input type="text" name="courseName"><br>
    课程号：<input type="text" name="courseId"><br>
    学分：<input type="text" name="score"><br>
    课程属性：<input type="text" name="classification"><br>
    教师工号：<input type="text" name="teacherId"><br>
    当前课程所属学期：<input type="text" name="semester"><br>
    课程所属班级：<input type="text" name="courseClass"><br>
    课程开始时间：<input type="text" name="startTime"><br>
    课程结束时间：<input type="text" name="endTime"><br>
    总课时数：<input type="text" name="learnTime"><br>
    <input type="hidden" name="state" value="confirm">
    <input type="submit" name="submit" value="确定添加">
</form>
</body>
</html>
