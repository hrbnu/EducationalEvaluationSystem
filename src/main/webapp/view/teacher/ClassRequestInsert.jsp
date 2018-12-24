<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/teacher/insertListenClass.action" method="POST">
        <c:if test="${msg==false}">
          申请失败，请检查是否正确。
        </c:if>
    <table>
        <tr>
            <th>被听课老师</th>
            <th>课程名</th>
            <th>是否提交</th>
        </tr>
        <tr>
            <td>
                <select name="isListeneredTeacherId" id="myOption" onchange="getCourse()">
                    <c:if test="${selectTeacher!=null}">
                        <option value="${selectTeacher.teacherId}">${selectTeacher.teacherName}(${selectTeacher.teacherId})</option>
                    </c:if>
                    <c:forEach items="${teachers}" var="teacher">
                        <option value="${teacher.teacherId}">${teacher.teacherName}(${teacher.teacherId})</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <c:if test="${courses==null}">
                    <select>
                        <option>请先选老师</option>
                    </select>
                </c:if>
                <c:if test="${courses!=null&&courses.size()==0}">
                    <select>
                        <option>无可选听课</option>
                    </select>
                </c:if>
                <c:if test="${courses!=null&&courses.size()!=0}">
                <select name="courseName">
                    <c:forEach items="${courses}" var="course">
                        <option value="${course.courseName}">${course.courseName}</option>
                    </c:forEach>
                </select>
                </c:if>
            </td>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
    </form>

</body>
<script type="text/javascript">

        window.onload = function () {
            // function getCourse(){
            //     var form = document.getElementById("temp");
            //     if(form == null) alert("Test");
            //     form.submit();//form表单提交
            // }

        }

        function getCourse(){
            var temp = document.getElementById("myOption");
            self.location.href="${pageContext.request.contextPath}/teacher/getCourse?isListeneredTeacherId="+temp.value;
        }


    </script>
</html>
