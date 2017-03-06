<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="cn.edu.svtcc.mybookshop.userdao.*"%>
<jsp:useBean id="dao" class="cn.edu.svtcc.mybookshop.userdao.Userdao" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
	<%
		//二者选其中一个方法即
		//Userdao daoa=new Userdao();
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("username");
		String pwd = request.getParameter("userpwd");
		if (name.equals("")) {
	%>
	<script type="text/javascript">
		alert("请输入账号！");
		response.sendRedirect("login.jsp");
	</script>
	<%
		} else if (pwd.equals("")) {
	%>
	<script type="text/javascript">
		alert("请输入密码！");
	</script>
	<%
		} else if (name.equals("") && pwd.equals("")) {
	%>
	<script type="text/javascript">
		alert("请输入账号和密码！");
	</script>
	<%
		} else if (dao.login(name, pwd))
			response.sendRedirect("welcome.jsp");
		else
			response.sendRedirect("login.jsp");
	%>

</body>
</html>