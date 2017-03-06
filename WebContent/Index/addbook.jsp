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
   <form action="${pageContext.request.contextPath }/Adminservlet?opt=addBook" method="post">
	
		<hr>
		<font color="red" size="5px">增加图书</font><br>
		<table>
			<tr><td>请输入新增图书书名：</td><td><input type="text" size="30" name="title" id="title"/></td></tr><tr><td>&nbsp;</td></tr>
			<tr><td>请输入作者：</td><td><input type="text" size="30" name="author" id="author"/></td></tr><tr><td>&nbsp;</td></tr>
			<tr><td>请选择出版社：</td><td>
				<select name="publishid" id="info" >
					<c:if test="${sessionScope.admin_Publi!=null }">
						<c:forEach items="${sessionScope.admin_Publi }" var="i">
							<option value="${i.id }">${i.name }</option>
						</c:forEach>
					</c:if>
				</select>
			
			</td></tr><tr><td>&nbsp;</td></tr>
			<tr><td>请选择图书分类：</td><td>
				<select id="info" name="categoryid">
					<c:if test="${sessionScope.admin_cate!=null }">
						<c:forEach items="${sessionScope.admin_cate }" var="i">
							<option value="${i.id }">${i.name }</option>
						</c:forEach>
					</c:if>
				</select> 
			</td></tr><tr><td>&nbsp;</td></tr>
			<tr><td>请输入isbn：</td><td><input type="text" size="30" name="isbn" /></td></tr><tr><td>&nbsp;</td></tr>
			<tr><td>请输入单价：</td><td><input type="text" size="30" name="unitprice" /></td></tr><tr><td>&nbsp;</td></tr>
			<tr><td>请输入TOC：</td><td><textarea name="TOC" cols="26"></textarea></td></tr><tr><td>&nbsp;</td></tr>
			<tr><td>请输入图书出版时间：</td><td><input type="text" size="30" name="time" /></td></tr><tr><td>&nbsp;</td></tr>
			<tr><td>请输入作者简介：</td><td><textarea name="authordescription" cols="26"></textarea></td></tr><tr><td>&nbsp;</td></tr>
			<tr><td>请输入图书详情：</td><td><input type="text" size="30" name="contextdescription" /></td></tr><tr><td>&nbsp;</td></tr>
			<tr><td>请输入图书目录描述（Description）：</td><td><textarea name="editorComment" cols="26"></textarea></td></tr><tr><td>&nbsp;</td></tr>
			<tr><td>请输入图书封面：</td><td>
				<input type="file" id="inputfile" name="imgURL">
			</td></tr><tr><td>&nbsp;</td></tr>
			
		</table>
		<input type="submit" value="添加图书" id="tijiao"/>
		<hr>
	
	
	</form>
	
	
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
</center>
 </body>
</html>

