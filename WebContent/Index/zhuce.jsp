<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>

<script src="${pageContext.request.contextPath }/jquery-3.0.0.js"></script>
<script src="${pageContext.request.contextPath }/PCASClass.js"></script>

<style type="text/css"  >

.div0 {
	width: 100%;
	height: 100%;
	position: absolute;
	background-repeat: no-repeat;
	background: url(img/img5.jpg);
}
.div1{
	width：50%;
	height: 100%;
	position: absolute;
	left: 600px;
	right: 110px;
	background: url(img/img1.png);
	border-radius: 10px;
}
.div2{
	width：50%;
	height: 100%;
	position: absolute;
	left: 50px;
	right: 110px;
	border-radius: 10px;
	
}
.int{
	width:305px;
	height:30px;
	border:#06F solid 1px;
	border-radius:4px;
}

.inty{
	width:210px;
	height:30px;
	border:#06F solid 1px;
	border-radius:4px;
}
.chek{
	width:100px;
	height:30px;
	border:#06F solid 1px;
	border-radius:4px;
}

.span{
	position: absolute;
	left: 50px;
	top: 20px;
	font-family: 幼圆;
}

.span1{
	position: absolute;
	left: 70px;
	top: 20px;
	font-family: 幼圆;
}

.span2{
	position: absolute;
	left: 40px;
	top: 20px;
	font-family: 幼圆;
}

.btn{
	width:200px;
	height:40px;
	border:#06F solid 1px;
	border-radius:4px;
	background:#27ff5f;
}
.t0 {
	position: absolute;
	left: 85px;
	top: 40px;
	font-family: 幼圆;
}

.t1 {
	position: absolute;
	left: 100px;
	top: 100px;
	font-family: 幼圆;
}

.t2 {
	position: absolute;
	left: 70px;
	top: 160px;
	font-family: 幼圆;
}

.t3 {
	position: absolute;
	left: 100px;
	top: 220px;
	font-family: 幼圆;
}

.t4 {
	position: absolute;
	left: 70px;
	top: 280px;
	font-family: 幼圆;
}

.t5 {
	position: absolute;
	left: 100px;
	top: 340px;
	font-family: 幼圆;
}
.t6 {
	position: absolute;
	left: 100px;
	top: 400px;
	font-family: 幼圆;
}

.t7 {
	position: absolute;
	left: 140px;
	top: 460px;
	font-family: 幼圆;
}
.t8{
	position: absolute;
	left: 180px;
	top: 510px;
	font-family: 幼圆;
}
</style>

</head>
<body>
	<script type="text/javascript"></script>

	
	<script>
	var i = 1;
	function change1()
	{
			span0.innerHTML="<br/><center><font  size='2' >*支持中文、字母、数字、符号的组合，4-20字符</font></center>";
	}
	
	function change2()
	{
			span1.innerHTML="<br/><center><font  size='2' >*请输入您的真实姓名</font></center>";
	}
	
	function change3()
	{
			span2.innerHTML="<br/><center><font  size='2' >*电话号码为以1开头的11位数字</font></center>";
	}
	
	function change4()
	{
			span3.innerHTML="<br/><center><font  size='2'>*建议使用字母、数字和符号的组合，6-20字符</font></center>";
	}
	
	function change5()
	{
			span4.innerHTML="<br/><center><font  size='2'>*请再次输入您的密码</font></center>";
	}
	
	function cs1()
	{
		var txt0=document.getElementById("text0");
		var sp0=document.getElementById("span00");
		span0.innerHTML="";
		  if(txt0.value.length==0)
			{
				sp0.innerHTML="<font  size='1'  color=red>账号不能为空</font>";
				i++;
			}
		  else if(txt0.value.length<=4)
			{
				sp0.innerHTML="<font  size='1'  color=red>账号不能小于4个字符</font>";
				i++;
			}
		  else
			  {
			  sp0.innerHTML="";
			  i=0;
			  }
	}
	
	function cs2()
	{
		var txt1=document.getElementById("text1");
		var sp1=document.getElementById("span11");
		span1.innerHTML="";
		  if(txt1.value.length==0)
			{
				sp1.innerHTML="<font  size='1'  color=red>姓名不能为空</font>";
				i++;
			}
		  else
			  {
			  sp1.innerHTML="";
			  i=0;
			  }
	}
	
	function cs3()
	{
		var txt2=document.getElementById("text2");
		var sp2=document.getElementById("span22");
		span2.innerHTML="";
		  if(txt2.value.length==0)
			{
				sp2.innerHTML="<font  size='1'  color=red>手机号不能为空</font>";
				i++;
			}
		  else if(txt2.value.length<11 || txt2.value.length>11)
			{
				sp2.innerHTML="<font  size='1'  color=red>手机号位数不合法</font>";
				i++;
			}
		  else
			  {
			  sp2.innerHTML="";
			  i=0;
			  }
		  
	}
	
	function cs4()
	{
		var txt3=document.getElementById("text3");
		var sp3=document.getElementById("span33");
		span3.innerHTML="";
		  if(txt3.value.length==0)
			{
				sp3.innerHTML="<font  size='1'  color=red>密码不能为空</font>";
				i++;
			}
		  else if(txt3.value.length<6)
			{
				sp3.innerHTML="<font  size='1'  color=red>密码应该在6-20字符之间</font>";
				i++;
			}
		  else
			  {
			  sp3.innerHTML="";
			  i=0;
			  }
	}
	
	function cs5()
	{
		var txt4=document.getElementById("text4");
		var sp4=document.getElementById("span44");
		var txt3=document.getElementById("text3");
		span4.innerHTML="";
		  if(txt4.value.length==0)
			{
				sp4.innerHTML="<font  size='1'  color=red>确认密码不能为空</font>";
				i++;
			}
		  else if(txt4.value!=txt3.value)
			{
				sp4.innerHTML="<font  size='1'  color=red>两次密码不相同</font>";
				i++;
			}
		  else
			  {
			  sp4.innerHTML="";
			  i=0;
			  }
	}
	
	function zuce()
	{
		var checkboxid=document.getElementById("ck");
		if(!checkboxid.checked)
		{
		alert("请先同意相关服务条款!");
		i++;
		}
		else if(i!=0)
			alert("相关信息不合法，请完善!");
		
			else if(i==0)
				
			alert("可以注册");
		
	}
	
</script>

<div class="div0">
	<div class="div1">
	</div>
	<div class="div2">
		<div class="t0">
		<form method="post" action="../UserServlet?method=regist">
				用户名&nbsp;<input type="text" class="int"  name="loginId"  onclick="change1()" onBlur="cs1()" id="text0" placeholder="您的账户和登录名"/><span id="span0" class="span"></span>
				<span id="span00"></span>
				</div>
		<div class="t1">	
				姓名&nbsp;<input type="text" class="int" id="text1" onclick="change2()" onBlur="cs2()" placeholder="请输入您的真实姓名"  name="name" /><span id="span1" class="span"></span>
				<span id="span11"></span>
				</div>	
		<div class="t2">		
				联系电话&nbsp;<input type="text" class="int" id="text2" onclick="change3()" onBlur="cs3()" name="phone" placeholder="请输入你的手机号"/><span id="span2" class="span1"></span>
				<span id="span22"></span>
				</div>
		<div class="t3">		
				密码&nbsp;<input type="password" class="int" name="loginPwd" id="text3" onclick="change4()" onBlur="cs4()" placeholder="建议至少使用两种字符"/><span id="span3" class="span2"></span>
				<span id="span33"></span>
				</div>
		<div class="t4">
				确认密码&nbsp;<input type="password" class="int" id="text4" onclick="change5()" onBlur="cs5()" placeholder="请再次输入密码"/><span id="span4" class="span1"></span>
		       <span id="span44"></span>
		        </div>
		<div class="t5">		
				<td align="right">住址：</td>
				<td><select
					style="padding-left: 5px; width: 102px; height: 30px; border-color: green;"
					name="p1" id="ad1" ></select>&nbsp;
					<select
					style="padding-left: 5px; width: 101px; height: 30px; border-color: green;"
					name="c1" id="ad2"></select></td>
			
				</div>
		<div class="t6">
			          邮箱&nbsp;<input type="text" name="mail" class="inty" placeholder="请输入您的邮箱号"/>
			          <select class="chek">
			          <option selected="selected">@qq.com</option>
			          <option>@361.com</option>
					 </select>
					 <span id="span6"></span><br/>
				</div>
		<div class="t7">
				<input type="checkbox"  id="ck">我已阅读并同意相关服务条款和隐私政策</input><span id="span7" class="span1"></span><br/>
				</div>
		<div class="t8">
				<input type="submit"  class="btn" onclick="zuce()" value="提交注册"/>
				</div>
		</form>
	</div>
</div>  
<script>
	new PCAS("p1", "c1");
</script>
</body>
</html>