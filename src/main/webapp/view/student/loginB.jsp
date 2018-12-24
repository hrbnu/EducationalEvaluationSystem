<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title></title>
	<link rel="stylesheet" href="/css/reset.css" />
	<link rel="stylesheet" href="/css/login.css" />
        <script type="text/javascript" src="/js/jquery.min.js"></script>
        <script type="text/javascript" src="/js/login.js"></script>
    <style type="text/css">
		 #code{  
                font-family:Arial;  
                font-style:italic;  
                font-weight:bold;  
                border:0;  
                letter-spacing:2px;  
                color:blue;  
                margin-top: 10px;
				margin-left: 39px;
				padding: 12px 27px;
            }
	</style>
</head>
<body>
<div class="page">
	<div class="loginwarrp">
		<div class="logo">学生登陆</div>
        <div class="login_form">
			<form id="Login" name="Login" action="${pageContext.request.contextPath}/student/login" method="post">
				<li class="login-item">
					<span>用户名：</span>
						<input type="text" id="studentId" name="studentId" class="login_input" >
                                        <span id="count-msg" class="error"></span>
				</li>
				<li class="login-item">
					<span>密　码：</span>
					<input type="password" id="password" name="password" class="login_input" >
                                        <span id="password-msg" class="error"></span>
				</li>
				<li class="login-item verify">
					<span>验证码：</span>
					<input type="text" name="CheckCode" class="login_input verify_input">
				</li>
					<input type = "button" id="code" onclick="createCode()"/>
				<div class="clearfix"></div> 
				<li class="login-sub">
					<input type="submit" name="Submit" value="登录" />
                    <input type="button" name="Reset" onclick="window.location.href='reset.jsp'" value="重置" />
				</li>
				<font color="red">${loginMessage}<br></font>
           </form>
		</div>
	</div>
</div>
<script type="text/javascript">
		window.onload = function() {
			var config = {
				vx : 4,
				vy : 4,
				height : 2,
				width : 2,
				count : 100,
				color : "121, 162, 185",
				stroke : "100, 200, 180",
				dist : 6000,
				e_dist : 20000,
				max_conn : 10
			}
			CanvasParticle(config);
		}
	</script>
	<script type="text/javascript">
    	//设置一个全局的变量，便于保存验证码
	    var code;
	    function createCode(){
	        //首先默认code为空字符串
	        code = '';
	        //设置长度，这里看需求，我这里设置了4
	        var codeLength = 4;
	        var codeV = document.getElementById('code');
	        //设置随机字符
	        var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R', 'S','T','U','V','W','X','Y','Z');
	        //循环codeLength 我设置的4就是循环4次
	        for(var i = 0; i < codeLength; i++){
	            //设置随机数范围,这设置为0 ~ 36
	             var index = Math.floor(Math.random()*36);
	             //字符串拼接 将每次随机的字符 进行拼接
	             code += random[index]; 
	        }
	        //将拼接好的字符串赋值给展示的Value
	        codeV.value = code;
	    }

	    //下面就是判断是否== 的代码，无需解释
	    function validate(){
	        var oValue = document.getElementById('input').value.toUpperCase();
	        if(oValue ==0){
	            alert('请输入验证码');
	            return false;
	        }else if(oValue != code){
	            alert('验证码不正确，请重新输入');
	            oValue = ' ';
	            createCode();
	            return false;
	        }else{
	            return true;
	        }
	    }

	    //设置此处的原因是每次进入界面展示一个随机的验证码，不设置则为空
	    window.onload = function (){
	        createCode();
	    }
    </script>
	<script type="text/javascript" src="js/canvas-particle.js"></script>
</body>
</html>