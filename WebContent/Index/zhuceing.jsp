<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="cn.edu.svtcc.mybookshop.userdao.*" import="cn.edu.svtcc.mybookshop.user.*"%>
<jsp:useBean id="register" class=cn.edu.svtcc.mybookshop.userdao.Userdao srope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	String usename=request.getParameter("usename");
	String usepwd=request.getParameter("usepwd");
	String use_name=request.getParameter("use_name");
	String use_phone=request.getParameter("use_phone");
	String use_Email=request.getParameter("use_Email");
	String use_address=request.getParameter("use_address");

	Users user=new Users(usename,usepwd,use_name,use_phone,use_Email,use_address);
	if(register.doregister(user)){
		response.sendRedirect("welcome.jsp");
	}
	else{
		response.sendRedirect("zhuce.jsp");
	}
%>
</body>
</html>