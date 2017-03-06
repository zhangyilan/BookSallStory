<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	background-image: url("img/01.jpg");
	background-size: 80%;
	height: 80%;
	width: 80%;
	margin-top: 10%;
	margin-left: 10%;
}
</style>
</head>
<body>
<%String s=request.getParameter("username"); %>
	<h1>
		<font color="red"><center>欢迎来到图书网！<%=s %></center></font>
	</h1>
</body>
</html> 