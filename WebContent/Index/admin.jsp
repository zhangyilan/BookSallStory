<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="cn.edu.svtcc.mybookshop.userdao.*"%>
<jsp:useBean id="dao" class="cn.edu.svtcc.mybookshop.userdao.Userdao" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
  <head>
   <title>后台管理</title>
  
     <bgsound src="../YY/1.mp3">
  </head>
  <frameset cols="20% ,*" border="5">
    
      <frame noresize src="b.jsp">
      <frame noresize name="ll" src="c.jsp">

   </frameset>
</html>