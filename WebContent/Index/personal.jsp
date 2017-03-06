<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
<style type="text/css">

.big{
	width: 300px;
	height: 310px;
	position: absolute;
	left: 260px;
	top:180px;
	background:#bdfefd;
}

.div1{
	position: absolute;
	left: 25px;
	top: 100px;
	font-family: 幼圆;
}

.div2{
	position: absolute;
	left: 25px;
	top: 170px;
	font-family: 幼圆;
}

}
.int{
	width:200px;
	height:40px;
	border-radius:4px;
}

.btn{
	width:180px; 
	height:35px;
	border:solid 0px;
	border-radius:10px;
	background:#27ff5f;
	position: absolute;
	top:65px;
	left: 40px;
}
</style>
</head>
<body background="img/img5.jpg">
<div style="background-color: #D3D3D3; width: 100%; height: 35px;">
		<a href="#" style="margin-left: 200px;">
			<font size="5px" color="blacpx;" style="margin-top: 20px;">XX购买图书网站->后台管理</font>
		</a>
		<a href="${pageContext.request.contextPath }/Index/welcomepage.jsp" style="margin-left: 200px;">
			<font size="3px" color="blue" style="margin-top: 20px;">首页</font>
		</a>
		<a href="${pageContext.request.contextPath }/Orderserlvet?method=showorder" style="margin-left: 200px;">
			<font size="3px" color="blue" style="margin-top: 20px;">订单管理</font>
		</a>
		
</div>


<form action="${pageContext.request.contextPath }/UserServlet?opt=yanzheng" method="post">
<div class="big">
	<div class="div1">
	账号：<input type="text" name="adminname"  class="int"/><br><br>
	</div>
	<div class="div2">
	密码：<input type="password" name="adminpwd" class="int" /><br><br>
	<input type="submit" value="登录"  class="btn">
	</div>
</div>
</form>
</body>
</html>