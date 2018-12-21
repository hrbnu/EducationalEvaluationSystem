<%@ page import="java.util.List" %>
<%@ page import="edu.cs.hrbnu.model.Teacher" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="else" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>教师信息表</h3>
        <form action="${pageContext.request.contextPath}/admin/searchTeacherByCondition" method="post">
            请选择教师身份：
            <input type="checkbox" name="teacherType">教师
            <input type="checkbox" name="monitorType">督导
            <input type="checkbox" name="leaderType">领导
            <select name="title">
                <option value="" disabled selected style='display:none;'>请选择教师标签</option>
                <option value="教学新星">教学新星</option>
                <option value="进步最快">进步最快</option>
                <option value="末位帮扶">末位帮扶</option>
            </select>
            <input type="submit" value="查询">
        <c:if test="${isEmpty == 'true'}">
            <h2>查询条件为空</h2>
        </c:if>
        <c:if test="${isEmpty == 'false'}">
            <table width="100%" border=1>
                <tr>
                    <td>序号</td>
                    <td>教师工号</td>
                    <td>姓名</td>
                    <td>身份证号</td>
                    <td>密码</td>
                    <td>教师身份</td>
                    <td>领导身份</td>
                    <td>督导身份</td>
                    <td>上次登录时间</td>
                </tr>
                <%
                    List<Teacher> teacherList = (List<Teacher>) request.getSession().getAttribute("teacherPosList");
                    String teacherLastLoginTime = null;
                    int count = 0;
                    for (Teacher teacher:teacherList) {
                        count++;
                        if(teacher.getLastLoginTime() != null){
                            Date date = teacher.getLastLoginTime();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                            teacherLastLoginTime = simpleDateFormat.format(date);
                        } else {
                            teacherLastLoginTime = "暂无记录";
                        }
                    %>
                <%--<c:forEach items="${sessionScope.teacherPosList}" var="item" varStatus="status">--%>
                    <tr>
                        <td><%=count%></td>
                        <td><%=teacher.getTeacherId()%></td>
                        <td><%=teacher.getTeacherName()%></td>
                        <td><%=teacher.getIdCard()%></td>
                        <td><%=teacher.getPassword()%></td>
                        <%
                            if(teacher.isTeacherType()){%>
                        <td>是</td>
                            <%}else{
                                %>
                        <td>否</td>
                        <%
                            }
                        %>
                        <%
                            if(teacher.isLeaderType()){%>
                        <td>是</td>
                        <%}else{
                        %>
                        <td>否</td>
                        <%
                            }
                        %>
                        <%
                            if(teacher.isMonitorType()){%>
                        <td>是</td>
                        <%}else{
                        %>
                        <td>否</td>
                        <%
                            }
                        %>
                        <td><%=teacherLastLoginTime%></td>
                    </tr>
                    <%
                        }
                    %>
            </table>
            <font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第${page.pageNow} 页</font>
            <a href="${pageContext.request.contextPath }/admin/searchTeacherByCondition?pageNow=1">首页</a>
            <c:choose>
                <c:when test="${page.pageNow - 1 > 0}">
                    <a href="${pageContext.request.contextPath }/admin/searchTeacherByCondition?pageNow=${page.pageNow - 1}">上一页</a>
                </c:when>
                <c:when test="${page.pageNow - 1 <= 0}">
                    <a href="${pageContext.request.contextPath }/admin/searchTeacherByCondition?pageNow=1">上一页</a>
                </c:when>
            </c:choose>

            <c:choose>
                <c:when test="${page.totalPageCount==0}">
                    <a href="${pageContext.request.contextPath }/admin/searchTeacherByCondition?pageNow=${page.pageNow}">下一页</a>
                </c:when>
                <c:when test="${page.pageNow + 1 < page.totalPageCount}">
                    <a href="${pageContext.request.contextPath }/admin/searchTeacherByCondition?pageNow=${page.pageNow+1}">下一页</a>
                </c:when>
                <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
                    <a href="${pageContext.request.contextPath }/admin/searchTeacherByCondition?pageNow=${page.totalPageCount}">下一页</a>
                </c:when>
            </c:choose>

            <c:choose>
                <c:when test="${page.totalPageCount==0}">
                    <a href="${pageContext.request.contextPath }/admin/searchTeacherByCondition?pageNow=${page.pageNow}">尾页</a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath }/admin/searchTeacherByCondition?pageNow=${page.totalPageCount}">尾页</a>
                </c:otherwise>
            </c:choose>
        </c:if>
        </form>
</body>
</html>