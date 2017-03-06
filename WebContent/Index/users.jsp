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

.int {
	width: 200px;
	height: 50px;
	border-radius: 2px;
	background:#FF9999;
}

</style>

  </head>
  <body text=""  background="">
	<center>
   <font color="red" size="5px">更新用户信息</font><br>
		
		<form action="${pageContext.request.contextPath }/Adminservlet?opt=adduser" method="post">
			<table>
	
				<tr><td><font color="red">**</font>请输入要增添的用户名：</td><td><input type="text" size="30" name="user_name"/></td></tr><tr><td>&nbsp;</td></tr>
				<tr><td><font color="red">**</font>请输入用户密码：</td><td><input type="text" size="30" name="user_pwd"/></td></tr><tr><td>&nbsp;</td></tr>
				<tr><td><font color="red">&nbsp;</font>请输入用户姓名：</td><td><input type="text" size="30" name="user_xingming"/></td></tr><tr><td>&nbsp;</td></tr>
				<tr><td><font color="red">&nbsp;</font>请输入用户住址：</td><td><input type="text" size="30" name="user_address"/></td></tr><tr><td>&nbsp;</td></tr>
				<tr><td><font color="red">&nbsp;</font>请输入用户电话：</td><td><input type="text" size="30" name="user_phone"/></td></tr><tr><td>&nbsp;</td></tr>
				<tr><td><font color="red">&nbsp;</font>请输入用户邮箱：</td><td><input type="text" size="30" name="user_email"/></td></tr><tr><td>&nbsp;</td></tr>
				<tr><td><font color="red">**</font>请输入用户角色：</td><td><input type="text" size="30" name="user_role"/></td></tr><tr><td>&nbsp;</td></tr>
				<tr><td><font color="red">**</font>请输入用户状态（1为有效，2为无效）：</td><td><input type="text" size="30" name="user_static"/></td></tr><tr><td>&nbsp;</td></tr>
				
				<tr><td></td></tr><tr><td>&nbsp;</td></tr>
				<tr><td><input type="submit" size="30" value="确认新增" id='addpublish'/></td><td></td></tr><tr><td>&nbsp;</td></tr>
			</table>
		</form>
			
		<form action="${pageContext.request.contextPath }/Adminservlet?opt=deteleuser" method="post">
			<table>
			
				<tr><td><font color="red">**</font>查看用户：</td><td>
					<!-- 下拉列表的id值在select的name中得到 -->
					<select name="user_id" id="info" >
						<c:if test="${sessionScope.admin_user!=null }">
							<c:forEach items="${sessionScope.admin_user }" var="i">
								<option value="${i.id }">${i.loginid }</option>
							</c:forEach>
						</c:if>
					</select>
					
				</td></tr><tr><td>&nbsp;</td></tr>
					
				<tr><td></td></tr><tr><td>&nbsp;</td></tr>
				<tr><td><input type="submit" size="30" value="确认删除" id='delepublish'/></td><td></td></tr><tr><td>&nbsp;</td></tr>
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
				alert("111");
				//判断这个额输入框是否为空
				if ($.trim($('#info').text()) == "") {
					window.location.reload();
				}
			}
		});
</script>
	
	
	
	
 </body>
</html>
