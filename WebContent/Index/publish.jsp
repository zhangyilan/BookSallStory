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
  <font color="red" size="5px">更新出版社</font><br>
		<form action="${pageContext.request.contextPath }/Adminservlet?opt=addpublishers" method="post">
			<table>
	
				<tr><td><font color="red">**</font>请输入要增添的出版社名称：</td><td><input type="text" size="30" name="category_name"/></td></tr><tr><td>&nbsp;</td></tr>
					
				<tr><td></td></tr><tr><td>&nbsp;</td></tr>
				<tr><td><input type="submit" size="30" value="确认新增" id='addpublish'/></td><td></td></tr><tr><td>&nbsp;</td></tr>
			</table>
		</form>
		
		
		<form action="${pageContext.request.contextPath }/Adminservlet?opt=detelePublish" method="post">
			<table>
			
				<tr><td><font color="red">**</font>请选择要删除的出版社名称：</td><td>
					<!-- 下拉列表的id值在select的name中得到 -->
					<select name="dele_publishid" id="info" >
						<c:if test="${sessionScope.admin_Publi!=null }">
							<c:forEach items="${sessionScope.admin_Publi }" var="i">
								<option value="${i.id }">${i.name }</option>
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
				//判断这个额输入框是否为空
				if ($.trim($('#info').text()) == "") {
					window.location.reload();
				}
			}
		});
</script>
		
		
 </body>
</html>

