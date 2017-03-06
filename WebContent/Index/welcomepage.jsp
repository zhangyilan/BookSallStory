<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>XX购买图书网站</title>
<link href="${pageContext.request.contextPath }/css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/base.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery-1.10.1.min.js"></script>
<script src="${pageContext.request.contextPath }/js/google-maps.js"></script>
<script>
	$(document).ready(function() {
		$(".vertical-nav").verticalnav({
			speed : 400,
			align : "left"
		});
	});
</script>

<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<style type="text/css">

.input {
	border: 2px solid #FF0000;
	padding: 4px;
}

.input input {
	width: 250px;
	border: 0;
	margin: 0;
	padding: 0;
	outline: none;
}
</style>

</head>
<body>
	<div style="background-color: #D3D3D3; width: 100%; height: 35px;">
	
		<a href="#"style="margin-left: 200px;">
			<font size="5px" color="black" style="margin-top: 20px;">欢迎<c:out value="${sessionScope.uname.loginid }"></c:out>来到购买图书网站</font></a>
		<a href="${pageContext.request.contextPath }/cartservlet?method=showcart" style="margin-left: 200px;">
			<font size="3px" color="blue" style="margin-top: 20px;">查看购物车</font>
		</a>
		<a href="${pageContext.request.contextPath }/Orderserlvet?method=showorder" style="margin-left: 200px;">
			<font size="3px" color="blue" style="margin-top: 20px;">订单管理</font>
		</a>
		<a href="${pageContext.request.contextPath }/Index/personal.jsp" style="margin-left: 200px;">
			<font size="3px" color="blue" style="margin-top: 20px;">后台管理</font>
		</a>
	</div>
	<div class="container">
		
		<div class="row">
			<img alt="买书，就上图书网" src="${pageContext.request.contextPath }/Index/img/logo.png">
			<form action="${pageContext.request.contextPath }/Bookserlvet?opt=byTitle&num=1" method="post">
				<div class="form-group has-error" style="position: absolute; top: 96px; left: 195px;">
					<div class="col-sm-10">
						<input type="text" name="bookname" class="form-control" placeholder="请输入查询的书名" style="width: 400px; left:.............. 630px;">
					</div>
				</div>
				<button type="submit" class="btn btn-primary" style="color: #FFFFFF; position: absolute; top: 96px; left: 630px;">搜索</button>
			</form>
		</div>
	
	
		<div class="row">
			<div class="col-md-3"> 
				<ul class="vertical-nav dark red">
						<li class="active"><a href="#"><i class="icon-home">
						</i>Home</a></li>
						<li><a href="#"><i class="icon-cogs"></i>图书关键字 
							<span class="glyphicon glyphicon-align-justify pull-right"></span></a>
							<ul>
								<c:if test="${applicationScope.clist!=null }">
									<c:set var="i" value="1"></c:set>

									<c:forEach items="${applicationScope.clist }" var="c">
										<li><a href="${pageContext.request.contextPath }/Bookserlvet?opt=byCatagoryid&cid=${c.id }&num=1">
												${c.name } </a></li>
									</c:forEach>
								</c:if>

							</ul></li>
						<li><a href="#"><i class="icon-briefcase"></i>出版社关键字 <span
								class="submenu-icon"></span></a>
							<ul>
								<li><a href="#">什么出版社</a></li>
								<li><a href="#">出版社a</a></li>
								<li><a href="#">出版社b<span
										class="sglyphicon glyphicon-align-justify"></span></a>
									<ul>
										<li><a href="#">出版社bb</a></li>
										<li><a href="#">出版社bbb</a></li>
										<li><a href="#">出版社bbbb <span
												class="glyphicon glyphicon-align-justify"></span>
										</a>
											<ul>
												<li><a href="#">出版社c</a></li>
												<li><a href="#">出版社cc</a></li>
												<li><a href="#">出版社ccc</a></li>
												<li><a href="#">出版社cccc</a></li>
											</ul></li>
										<li><a href="#">。。。</a></li>
									</ul></li>
								<li><a href="#">Second level</a></li>
								<li><a href="#">Second level</a></li>
							</ul></li>

						<li><a href="#"><i class="icon-bar-chart"></i>我的订单</a></li>
						<li><a href="#"><i class="icon-comments-alt"></i>我的快递</a></li>
						<li><a href="#"><i class="icon-picture"></i>我的书单</a></li>
						<li><a href="#"><i class="icon-info"></i>我的Info</a></li>
						<li><a href="#"><i class="icon-group"></i>个人中心</a></li>
						<li><a href="#"><i class="icon-question"></i>联系客服</a></li>
						<li><a href="#"><i class="icon-envelope"></i>我的疑问</a></li>
						<li><a href="#"><i class="icon-user"></i>关于我们</a></li>
					</ul>
			</div>
			
			<div class="col-md-9">
				<div class="row" style="margin-top: 25px;">
					<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="970" height="347">
 						<param name="movie" value="imageshow.swf" />
 						<param name="quality" value="high" />
  						<embed src="xml/imageshow.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="970" height="347"></embed>
					</object> 
				</div>
				
				
				<div class="row">
					<c:set var="i" value="0" />
					<!-- 这里是初始的书本，如果搜索没有，则显示初始 -->
					<c:if test="${applicationScope.books!=null and sessionScope.books==null }">
						<table>
							<c:forEach items="${applicationScope.books }" var="b">
								<c:if test="${i%4==0 }">
									<tr>
								</c:if>
								<td><img
									src="${pageContext.request.contextPath }/Index/${b.imgURL}"
									width="150px" height="200px"><br /> <font size="3px"
									color="black"> ${b.title } <br /></font> <font color="blue"
									size="2px"> ${b.author }<br /></font> <font color="red">
										￥ ${b.unitprice } </font><br/>
									<a href="${pageContext.request.contextPath }/cartservlet?method=add&isbn=${b.isbn }">购买</a></td>
								<c:set var="i" value="${i+1 }" />
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							</c:forEach>
						</table>
					</c:if>
					<!-- 上面搜索框如果搜索出来，则显示这一部分搜索的 -->
					<c:if test="${sessionScope.books!=null }">
						<table>
							<c:forEach items="${sessionScope.books }" var="b">
								<c:if test="${i%4==0 }">
									<tr>
								</c:if>
								<td><img
									src="${pageContext.request.contextPath }/Index/${b.imgURL}"
									width="150px" height="200px"><br /> <font size="3px"
									color="black"> ${b.title } <br /></font> <font color="blue"
									size="2px"> ${b.author }<br /></font> <font color="red">
										￥ ${b.unitprice } </font><br/>
										<a href="${pageContext.request.contextPath }/cartservlet?method=add&isbn=${b.isbn }">购买</a></td>
								<c:set var="i" value="${i+1 }" />
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							</c:forEach>
						</table>
					</c:if>					
				</div>
				<hr color="#DCDCDC"  size="1"> 
				<br><br><br><br><br>
				<div class="row" align="left"style="margin-left: 200px">
					 <div class="btn-group btn-group-sm">		
					 	
					 	<a href="${pageContext.request.contextPath }/Bookserlvet?opt=byTitle&num=${i}">
    						<c:set var="i" value="${i+1 }"/>
    						<button class="btn btn-default">上一页</button>
    					</a>
    						<a href="${pageContext.request.contextPath }/Bookserlvet?opt=byTitle&num=${i}">
    						<button class="btn btn-default">下一页</button>
    					</a>
					</div>
				</div>
				
			</div>
		</div>
		
		<div align="center" style="background-color: #eaeaea">
			<hr color="#DCDCDC"  size="1">
			<img alt="" src="img/101.png"/>			
				<p><a href="#">关于我们</a></p>
				<p>©2016 index 使用本站前必读 意见反馈 京ICP证030173号</p> 
				<p>京公网安备11000002000001号</p>			
		</div>
	</div>
</body>
</html>