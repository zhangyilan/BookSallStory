<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登陆</title>

<script type="text/javascript" >
	function f1() {
		location.href = "zhuce.jsp";
	}
</script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js">
	function logn(){
			$.ajax({
			async : true,
			timeout : 1000,
			type : "POST",
			url : "../Loginservlet",
			data : {
				username : $("#name").val()
			},
			error : function() {
				alert("加载超时!");
			},
			success : function(data) {
				var result = eval('(' + data + ')');
				alert("cdscd");
				if (result.status == "OK") {
					alert("用户存在");
					$("#user_id").find("span").html("用户存在").show();
					//doucument.getElementById(user_id）.innerHTML="用户存在";
				} else if (result.status == "ERROR") {
					alert("yonghu");
					$("#user_id").find("span").html(result.msg).show();
				}
			}
		})
	}
</script>
<style type="text/css">
.div1 {
	width: 300px;
	height: 300px;
	position: absolute;
	left: 260px;
	top: 180px;
	background: #bdfefd;
}

.div2 {
	position: absolute;
	left: 25px;
	top: 100px;
	font-family: 幼圆;
}

.div3 {
	position: absolute;
	left: 25px;
	top: 170px;
	font-family: 幼圆;
}

.div4 {
	position: absolute;
	left: 60px;
	top: 230px;
	font-family: 幼圆;
}

.div5 {
	position: absolute;
	left: 20px;
	top: 280px;
	font-family: 幼圆;
	font-size: 2px;
}

.div6 {
	position: absolute;
	left: 190px;
	top: 280px;
	font-family: 幼圆;
	font-size: 2px;
}

.int {
	width: 200px;
	height: 30px;
	border-radius: 4px;
}

.btn {
	width: 180px;
	height: 35px;
	border: solid 0px;
	border-radius: 10px;
	background: #27ff5f;
}

a {
	TEXT-DECORATION: none;
}

a:link {
	color: gray;
}

a:visited {
	color: gray;
}
</style>
</head>

<body background="img/img5.jpg">
	<div class="div1">
		<form method="post" action="${pageContext.request.contextPath }/UserServlet?opt=login">
			<center>
				<br /> <font color="#00CD66"><h2>&nbsp;用&nbsp;户&nbsp;登&nbsp;录</h2></font>
			</center>
			<div class="div2">
				账号: <input name="username" class="int" type="text" id="name"
					size="7" placeholder="邮箱/手机号/用户名" onblur="logn()" /> <span
					id="user_id"></span>

			</div>
			<div class="div3">
				密码: <input name="userpwd" class="int" id="pass" type="password"
					size="7" placeholder="密码" />
			</div>
			<div class="div4">
				<input type="submit" class="btn" value="登陆" id="auto" />
			</div>

			<div class="div5">
				<a href="lost.jsp" title="点击找回密码">忘记密码</a>
			</div>
			<div class="div6">
				<a href="zhuce.jsp" title="点击进入注册页面">没有账号？去注册</a>
			</div>
		</form>
	</div>
</body>
</html>