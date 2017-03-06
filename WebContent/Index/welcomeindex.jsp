<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>查询图书</title>
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
.div_big {
	margin: 10px;
}

.div1 {
	width: 80%;
}

.div2 {
	width: 265px;
	position: absolute;
	top: 200px;
}

.div3 {
	width: 1000px;
	position: absolute;
	top: 600px;
	left: 300px;
	float: right;
	z-index: 1;
}
.div3_1{
	width:1000px;
	position:absolute;
	top:200px;
	left: 300px;
	float:right;
	
}

.div4 {
	width: 1000px;
	height: 100%;
	position: absolute;
	top: 200px;
	left: 300px;
	float: right;
	z-index: 2;
}

.div5 {
	width: 1000px;
	height: 100%;
	position: absolute;
	top: 130px;
	left: 300px;
	float: right;
	z-index: 3;
}

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
	<div class="div_big">

		<div class="head">
			<img alt="买书，就上图书网" src="${pageContext.request.contextPath }/Index/img/logo.png">
			<form action="${pageContext.request.contextPath }/Bookserlvet?opt=byTitle" method="post">
				<div class="form-group">
					<select class="form-control" style="width: 200px;style="height: 206px;"">
						<option>按书名查询</option>
						<option>按种类查询</option>
						<option>按出版社查询</option>

					</select>
				</div>

				<div class="form-group has-error"
					style="position: absolute; top: 96px; left: 195px;">
					<div class="col-sm-10">
						<input type="text" name="bookname" class="form-control" placeholder="请输入查询的书名" style="width: 400px;">
					</div>
				</div>
				<button type="submit" class="btn btn-primary" style="color: #FFFFFF; position: absolute; top: 96px; left: 630px;">搜索</button>
			</form>
		</div>

		<div class="div1">
			<div class="div2">
				<div class="content">
					<ul class="vertical-nav dark red">
						<li class="active"><a href="#"><i class="icon-home">
						</i>Home</a></li>
						<li><a href="#"><i class="icon-cogs"></i>图书关键字 
							<span class="glyphicon glyphicon-align-justify pull-right"></span></a>
							<ul>
								<c:if test="${applicationScope.clist!=null }">
									<c:set var="i" value="1"></c:set>

									<c:forEach items="${applicationScope.clist }" var="c">
										<li><a
											href="${pageContext.request.contextPath }/Bookserlvet?opt=byCatagoryid&cid=${c.id }">
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
			</div>
			<!-- div3_1是显示切换图片的 -->
					<div class="div3_1">
						<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="970" height="347">
  							<param name="movie" value="imageshow.swf" />
  							<param name="quality" value="high" />
  							<embed src="imageshow.swf"  type="application/x-shockwave-flash" width="970" height="347"></embed>
						</object>
					</div>
				<div class="div3">
					
					<c:set var="i" value="0" />

					<c:if
						test="${applicationScope.books!=null and sessionScope.books==null }">
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
										￥ ${b.unitprice } </font></td>
								<c:set var="i" value="${i+1 }" />
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							</c:forEach>
						</table>
					</c:if>

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
										￥ ${b.unitprice } </font></td>
								<c:set var="i" value="${i+1 }" />
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							</c:forEach>
						</table>

					</c:if>
				</div>

				<div class="div4">
				<!-- 搜索图书的div -->
					<c:set var="i" value="0" />
					<c:if test="${requestScope.books!=null }">
						<table>

							<c:forEach items="${requestScope.books }" var="b">

								<c:if test="${i%4==0 }">
									<tr>
								</c:if>
								<td>
								<img src="${pageContext.request.contextPath }/Index/${b.imgURL}"
									width="150px" height="200px"><br /> 
									<font size="3px" color="black"> ${b.title } <br /></font> 
									<font color="blue" size="2px"> ${b.author }<br /></font> 
									<input type="hidden" class="books" value="${b.title } "> 
									<font color="red"> ￥ ${b.unitprice } </font></td>
								<c:set var="i" value="${i+1 }" />
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							</c:forEach>
						</table>
					</c:if>
				</div>
			
		</div>

		<script type="text/javascript">
			$(function() {
				$(function() {
					if ($(".books").length == 0) {
						$(".div3").css("display", "block");
					} else {
						$(".div3").css("display", "none");
					}
				});
			});
		</script>

	</div>
</body>
</html>