<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="cn.edu.svtcc.mybookshop.userdao.*"%>
<jsp:useBean id="dao" class="cn.edu.svtcc.mybookshop.userdao.Userdao" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
  <head> 
     <title>目录</title>

<style type="text/css">

.int {
	width: 200px;
	height: 50px;
	border-radius: 2px;
	background:#FF9999;
}

</style>

  </head>
  <body text=""  background="">
   <ul type="disc">
	<br/><br/><br/><br/><br/><br/>
       <li><a href="addbook.jsp" target="ll"><button class="int">增加图书</button></a></li></p><br/>  
     
       <li><a href="publish.jsp"  target="ll"><button class="int">更新出版社</button></a></li></p><br/>

       <li><a href="cate.jsp"  target="ll"><button class="int">更新图书类别</button></li></p><br/>

       <li><a href="newbook.jsp"  target="ll"><button class="int">更新图书</button></a></li></p><br/>

       <li><a href="users.jsp"  target="ll"><button class="int">用户管理</button></a></li></p>
   </ul>
 </body>
</html>
