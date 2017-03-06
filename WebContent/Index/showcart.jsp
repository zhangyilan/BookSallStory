<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="xml/jquery.min.js"></script>

<title>购物车</title>
<style type="text/css">
.bottom{
	width: 100%;
	background-color: #D3D3D3;
	position:fixed;bottom:0px;
}
.box{
	width: 80%;
	margin-left: auto;
	margin-right: auto;
	margin-top: 45px;
	margin-bottom: 200px;
}
</style>

</head>
<body>
<form action="${pageContext.request.contextPath }/Orderserlvet?method=addorder" method="post">
	<div style="background-color: #D3D3D3; width: 100%; height: 35px;">
		<a href="#" style="margin-left: 200px;">
			<font size="5px" color="black" style="margin-top: 20px;">XX购买图书网站->购物车</font>
		</a>
		<a href="${pageContext.request.contextPath }/Index/welcomepage.jsp" style="margin-left: 200px;">
			<font size="3px" color="blue" style="margin-top: 20px;">首页</font>
		</a>
		
		<a href="${pageContext.request.contextPath }/Orderserlvet?method=addorder" style="margin-left: 200px;">
			<font size="3px" color="blue" style="margin-top: 20px;">订单管理</font>
		</a>
		<a href="${pageContext.request.contextPath }/cartservlet?method=showcart" style="margin-left: 200px;">
			<font size="3px" color="blue" style="margin-top: 20px;">个人中心</font>
		</a>
	
	</div>
<c:if test="${sessionScope.items==null }">
	<font size="15px" >购物车为空...</font>
</c:if>
<c:if test="${sessionScope.items!=null }">
<hr width="80%">
<div class="box">
	<table >
			<tr><td></td><td>书名</td><td>单价</td><td>数量</td><td>小计</td><td>操作</td></tr>
			<c:forEach items="${sessionScope.items }" var="its"> 
			<tr >
				<td><img src="${its.item.imgURL }" width="125px" height="150px"></td>
				
				<td>${its.item.title }</td>
				<td width="15%"><font size="5px" color="red">${its.item.unitprice }</font></td>
				<td width="25%" >
					<a  href="${pageContext.request.contextPath }/cartservlet?method=inmun&isbn=${its.item.isbn }"><button>+</button></a>
					<input id="${its.item.isbn}" name="quantity"  type="text" value="${its.amount }" style="width: 25px;height: 25px; text-align: center;" />
					<a  href="${pageContext.request.contextPath }/cartservlet?method=demun&isbn=${its.item.isbn }"><button>-</button></a>
				</td>
				<td width="15%">${its.item.unitprice*its.amount }</td>
				<td><a href="${pageContext.request.contextPath }/cartservlet?method=delete&isbn=${its.item.isbn }">删除</a></td>
			</tr>
			</c:forEach>
	</table>
</div>				
	<div class="bottom" >
		<a href="${pageContext.request.contextPath }/cartservlet?method=deletecart&isbn=${its.item.isbn }">
			<button style="width: 150px;height: 35px; font-size: 6px; margin:25px;"><font size="5px">清空购物车</font></button>
		</a>
		
		<font color="blue" size="4px" style="margin: 25px">总价：<c:out value="${sessionScope.cart.getTotalprice() }"></c:out></font>		
		<input type="submit" style="width: 200px; height: 50px; background-color: #ff3300; margin: 25px;color: #fff; font-size: large;" value="提交订单" />
		<script type="text/javascript">
			$(function(){		
				$('input:text[name=quantity]').change(function(){
					//alert($('input:text[name=quantity]').val());获取内容的数量
					$.post("${pageContext.request.contextPath }/cartservlet?method=inputamount&&isbn="+$(this).attr("id")+"&&amount="+$(this).val(),function(data){
						$(document.body).html(data); 
					});
				});
			});
		</script>
	</div>
		
</c:if>
</form>
</body>
</html>