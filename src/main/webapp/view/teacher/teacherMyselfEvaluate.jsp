<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--360浏览器优先以webkit内核解析-->
    <meta name="renderer" content="webkit">

    <title>当前学期可自我评价课程</title>
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
	width: 33.3%;
	float: left;
}
.col-xs-2 {

    width: 16.66666667%;
	float: left;
}
.data-div{
	margin-bottom: 500px;
}
.btn{
	border: none;
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
</style>
</head>

<body style="background-color:#eff3f6;">
        <div class="data-div">
                    <div class="row tableHeader">
                        <div class="col-xs-2 ">
                            课程名称
                        </div>
                    </div>
                    <div class="tablebody">
                        <c:forEach items="${evaluate}" var="temp">
                        <div class="row">
                            <div class="col-xs-2 ">
                                    ${temp.courseName}
                            </div>
                            <div class="col-xs-2">
                                <a href="<%=path%>/teacher/evalu?teacherId=${sessionScope.get("teacherId")}&courseId=${temp.courseId}&flag=2">开始评价</a>
                            </div>
                        </div>
                        </c:forEach>
                    </div>

                </div>
                <script type="text/javascript">


				</script>
</body>
</html>