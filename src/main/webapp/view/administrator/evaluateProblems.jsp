<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://java.sun.com/jsf/html">
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
			.partD{
				margin-left: 5%;
				margin-left:11px;
			}
			.partD>tr{
					 border-bottom: 1px #ddd dashed;
				 }
			.partE{
				margin-left: 5%;
				margin-left:11px;
			}
			.partE>tr{
				border-bottom: 1px #ddd dashed;
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

            <br>
		<div class="partD">
			修改学生评价指标：<br>
			<table style="margin: 1% 11%;">
				<tr>
					<td>问题内容</td>
					<td>问题类型</td>
					<td>分数</td>
				</tr>

				<c:forEach items="${problems}" var="problem">
					<c:choose>
						<c:when test="${problem.forWho == 0}">
							<tr>
								<td style="width: 360px;" >
										<form action="/admin/alert/${problem.id}" style="height:50px;margin: 0;" >
											<input type="text" name="alertText" style="width: 360px;height:50px; border: none;" value="${problem.evaluateProblemContent}">
								</td>
								<c:choose>
									<c:when test="${problem.forWho == 0}">
										<td style="width: 80px">老师</td>
									</c:when>
									<c:otherwise>
										<td style="width: 80px">学生</td>
									</c:otherwise>
								</c:choose>
								<td style="width: 44px">
									${problem.score}
								</td>
								<td>
										<button type="submit" class="btn-look" onclick="mysubmit()">确认修改</button>
										</form>
								</td>
							</tr>
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</c:forEach>
			</table>
		</div>
		<div class="partE">
			修改教师评价指标：<br>
			<table style="margin: 1% 11%;">
				<tr>
					<td>问题内容</td>
					<td>问题类型</td>
					<td>分数</td>
				</tr>

				<c:forEach items="${problems}" var="problem">
					<c:choose>
						<c:when test="${problem.forWho == 1}">
							<tr>
								<td style="width: 360px;" >
									<form action="/admin/alert/${problem.id}" style="height:50px;margin: 0;" >
										<input type="text" name="alertText" style="width: 360px;height:50px; border: none;" value="${problem.evaluateProblemContent}">
										</td>
										<td style="width: 80px">学生</td>
										<%--<c:choose>--%>
											<%--<c:when test="${problem.forWho == 1}">--%>
												<%--<td style="width: 80px">老师</td>--%>
											<%--</c:when>--%>
											<%--<c:otherwise>--%>
												<%--<td style="width: 80px">学生</td>--%>
											<%--</c:otherwise>--%>
										<%--</c:choose>--%>
										<td style="width: 44px">
												${problem.score}
										</td>
										<td>
										<button type="submit" class="btn-look" onclick="mysubmit()">确认修改</button>
									</form>
								</td>
							</tr>
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</c:forEach>
			</table>

		</div>

	</div>

	<script>
		function mysubmit() {
				var flag=<%=request.getAttribute("flag")%>;

				if (flag == true){
				    alert("修改成功");
                }else{
				    alert("修改失败");
                }
        }
	</script>
	</body>
</html>
