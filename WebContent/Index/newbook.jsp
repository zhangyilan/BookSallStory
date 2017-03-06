<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="cn.edu.svtcc.mybookshop.userdao.*"%>
<jsp:useBean id="dao" class="cn.edu.svtcc.mybookshop.userdao.Userdao" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
  <head> 
     <title>目录</title>
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

<style type="text/css">

</style>

  </head>
  <body text=""  background="">
	<center>
   <font color="red" size="5px">更新图书</font><br>
		
		<form action="${pageContext.request.contextPath }/Adminservlet?opt=updateBook" method="post">
	
		<table>
			<tr><td><font color="red">(红色**为必填项)</font></td><td></td></tr><tr><td>&nbsp;</td></tr>
			
			<tr ><td><font color="red">**</font>请输入需要更新图书的isbn：</td><td><input type="text" size="30" name="oldisbn"/></td></tr><tr><td>&nbsp;</td></tr>
			<tr><td>重命名书名：</td><td><input type="text" size="30" name="newtitle"/></td></tr><tr><td>&nbsp;</td></tr>
			
			<tr><td>重命名作者：</td><td><input type="text" size="30" name="newauthod"/></td></tr><tr><td>&nbsp;</td></tr>
			<tr><td>重命名单价：</td><td><input type="text" size="30" name="newunitprice" /></td></tr><tr><td>&nbsp;</td></tr>
			<tr><td>重命名TOC：</td><td><input type="text" size="30" name="newTOC" /></td></tr><tr><td>&nbsp;</td></tr>
			<tr><td>重命名图书封面：</td><td><input type="text" size="30" name="newimgURL" /></td></tr><tr><td>&nbsp;</td></tr>
			<tr><td>请输入作者简介：</td><td><textarea name="newauthordescription" cols="26"></textarea></td></tr><tr><td>&nbsp;</td></tr>
			<tr><td>请输入图书详情：</td><td><input type="text" size="30" name="newcontextdescription" /></td></tr><tr><td>&nbsp;</td></tr>
			<tr><td>请输入图书目录描述（Description）：</td><td><textarea name="neweditorComment" cols="26"></textarea></td></tr><tr><td>&nbsp;</td></tr>
			<tr><td><input type="submit" size="30" value="确认新增" id='addcate'/></td><td></td></tr><tr><td>&nbsp;</td></tr>
			
		</table>
		
		</form>
	</center>
	
	
<script type="text/javascript" src="../js/jquery-3.0.0.js"></script>
	
<script>

		$.ajax({
			url : '../Adminservlet?opt=showCatePubliUser',
			type : 'post',
			data : {},
			async : true,
			success : function(data, statusText) {
				//判断这个额输入框是否为空
				if ($.trim($('#info').text()) == "") {
					window.location.reload();
				}
			}
		});
</script>
	
	
 </body>
</html>

