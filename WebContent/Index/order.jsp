<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单管理</title>
</head>
<style>

.box{
	width: 80%;
	margin-left: auto;
	margin-right: auto;
	margin-top: 45px;
	margin-bottom: 200px;
}
.tr_title{
	height: 25px;
}
</style>
<body>
<div style="background-color: #D3D3D3; width: 100%; height: 35px;position: fixed; margin-top: 0px;">
		<a href="#" style="margin-left: 200px;">
			<font size="5px" color="blacpx;" style="margin-top: 20px;">XX购买图书网站->订单管理</font>
		</a>
		<a href="${pageContext.request.contextPath }/Index/welcomepage.jsp" style="margin-left: 200px;">
			<font size="3px" color="blue" style="margin-top: 20px;">首页</font>
		</a>
		<a href="${pageContext.request.contextPath }/cartservlet?method=showcart" style="margin-left: 200px;">
			<font size="3px" color="blue" style="margin-top: 20px;">查看购物车</font>
		</a>
		<a href="${pageContext.request.contextPath }/cartservlet?method=showcart" style="margin-left: 200px;">
			<font size="3px" color="blue" style="margin-top: 20px;">个人中心</font>
		</a>
</div>

<div class="box">
	<input type="checkbox" name="allcheckbox1"/><label><font size="5px">全选</font></label>
	<hr/>
	<table >
		<tr  bgcolor="#DCDCDC" >
		
			<td width="20%" align="center" rowspan="2"><font size="5px" >宝贝</font></td>
			<td width="20%"></td>
			<td width="15%"align="center" rowspan="2"><font size="5px" >单价</font></td>
			<td width="15%"align="center" rowspan="2"><font size="5px" >数量</font></td>
			<td width="15%" align="center" rowspan="2"><font size="5px" >实付款</font></td>
			<td width="15%" align="center" rowspan="2"><font size="5px" >操作</font></td>
		</tr>
		<tr  bgcolor="#DCDCDC" ><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;<p>&nbsp;</p></td><td>&nbsp;</td></tr>
	
		<tr>
			<td>&nbsp;</td>
		</tr>
	<c:forEach items="${orderlist.iterator()}" var="orderlist">
		<tr bgcolor="#99FFCC" class="tr_title">
			<td height="15%">时间 :<c:out value="${orderlist.orderDate }"></c:out> </td>
			<td></td>
			<td height="15%" >订单号：<c:out value="${orderlist.id }"></c:out></td>
			<td height="15%" colspan="2">订单总价：<c:out value="${orderlist.totalPrice }"></c:out>元</td>
			<td></td>
		</tr>	

		<tr>
			<td><img alt="" src="${orderlist.imgURL }" width="125px" height="150px"/></td>
			<td><c:out value="${orderlist.title }"></c:out></td>
			<td>单价:<c:out value="${orderlist.unitPrice }"></c:out></td>
			<td>数量:<c:out value="${orderlist.quantity }"></c:out></td>
			<td>实付:<c:out value="${orderlist.unitPrice*orderlist.quantity }"></c:out></td>
			<td><a href="${pageContext.request.contextPath }/Orderserlvet?method=deleteorder&id=${orderlist.id}">删除订单</a></td>
		</tr>	
		
		
	</c:forEach>
	</table>
</div>				


</body>
</html>