<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书详情</title>
<script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<style type="text/css">
.big{
	
	width: 80%;
	margin-left: auto;
	margin-right: auto;
	margin-top: 45px;
}
</style>
<script>
$(function(){
	$("#btn_in").click(function(){
		var changeValue=$("#values").val();
		changeValue++;
		$("#values").val(changeValue);
		
	});
	$("#btn_de").click(function(){
		var changeValue=$("#values").val();
		if(changeValue==0){
			
	         $(this).dequeue(); 
		}
			changeValue--;
		$("#values").val(changeValue);
	});
});
</script>
</head>
<body>
<div style="background-color: #D3D3D3; width: 100%; height: 35px;">
		<a href="#" style="margin-left: 200px;">
			<font size="5px" color="blacpx;" style="margin-top: 20px;">XX购买图书网站->图书详情</font>
		</a>
		<a href="${pageContext.request.contextPath }/Index/welcomepage.jsp" style="margin-left: 200px;">
			<font size="3px" color="blue" style="margin-top: 20px;">首页</font>
		</a>
		<a href="${pageContext.request.contextPath }/Orderserlvet?method=showorder" style="margin-left: 200px;">
			<font size="3px" color="blue" style="margin-top: 20px;">订单管理</font>
		</a>
		<a href="${pageContext.request.contextPath }/cartservlet?method=showcart" style="margin-left: 200px;">
			<font size="3px" color="blue" style="margin-top: 20px;">个人中心</font>
		</a>
</div>

<div class="big">
<form action="${pageContext.request.contextPath }/cartservlet?method=buy" method="post">
	
	
	<table >
		<tr><td></td><td width= "25% ">书名</td><td width= "15% ">数量</td><td>操作</td></tr>
		<tr><td><img src="${sessionScope.book.imgURL }"width="200px" height="250px"></td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
		<tr>
			<td></td>
			<td>${sessionScope.book.title }</td>
			<td align="center">
				<input type="button" value="+" id="btn_in"name="btn_innum" style="text-align:center; width: 25px;height: 25px"/>
				<input type="text" value="1" id="values" name="nuitnum" style="text-align:center; width: 25px;height: 25px"/>
				<input type="button" value="-" id="btn_de" name="btn_denum" style="text-align:center; width: 25px;height: 25px"/>
				
			</td>
			<td><input type="submit" value=" " style="background-image: url('img/btn.png'); width: 200px; height: 45px;"></td>
		</tr>
		<tr><td>&nbsp;&nbsp;</td></tr><tr><td>&nbsp;&nbsp;</td></tr><tr><td>&nbsp;&nbsp;</td></tr>
		<tr>
			<td colspan="4"><font size="6px" color="blue">图书详情</font> </td>			
		</tr>
		<tr>
			<td>图书isbn</td>	
			<td>出版时间</td>
			<td>单价</td>
			<td>图书描述</td>		
		</tr>
		<tr>
			<td>${sessionScope.book.isbn }</td>	
			<td>${sessionScope.book.publishdata }</td>
			<td><font size="5px" color="red">${sessionScope.book.unitprice }</font></td>
			<td><font size="3px;" face="黑体" style="padding: 6dp;">${sessionScope.book.contentdescription }</font></td>		
		</tr>
	</table>
	<table>
		
	</table>
</form>
</div>
</body>
</html>