<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"> 
	   传习教育网上书城
	</div>
    <div style="width:380px; height:50px; float:right; position:absolute; left:60%; top:2px; line-height:50px">
	    <img src="images/cart.gif" style="margin-bottom:-4px" width="26" height="23">
		  欢迎您： madan &nbsp;
                  <a href="myAccount.jsp">我的帐户</a>
				| <a href="productCategory.jsp">商品分类</a> 
				| <a href="#">帮助中心</a>  
		</div>
	<div id="navbar">
		<form method="get" name="search" action="">
			搜索：<input class="input-text" type="text" name="keywords" /><input class="input-btn" type="submit" name="submit" value="" />
		</form>
	</div>
</div>
<div id="login">
	<h2>用户登陆  ${message}</h2>
	<form onsubmit="return yanzhen()" method="get" action="http://localhost:8080/book4/loginServlet.do">
		<dl>
			<dt>用户名：</dt>
			<dd><input class="input-text" type="text" name="userName" id="userID" />
            <span id="uidTip"></span></dd>
			<dt>密　码：</dt>
			<dd><input class="input-text" type="password" name="passWord" id="pwdId" />
            <span id="pwdTip"></span></dd>
            <dt>记住密码</dt>
            <dd>
            	<input type="radio" name="autologin" value="${60*60*24*7 }"/>7天
            	<input type="radio" name="autologin" value="${60*60*24*15 }"/>15天
            	<input type="radio" name="autologin" value="${60*60*24*30 }"/>30天
            </dd>
			<dt></dt>
			<dd class="button"><input class="input-btn" type="submit" name="submit" value="" /><input class="input-reg" type="button" name="register" value="" onclick="window.location='register.html';" /></dd>
		</dl>
	</form>
</div>
<div id="footer" class="wrap">
	传习教育网上书城 &copy; 版权所有
</div>
<script type="text/javascript">
function yanzhan(){
	  document.getElementById("uidTip").innerHTML ="";
	  document.getElementById("pwdTip").innerHTML ="";
	  //alert("表单验证信息...");
	var uobj=document.getElementById("userID");
	if(uobj.value==""){
	   document.getElementById("uidTip").innerHTML = "用户名不能为空";
	   return false;
	}
	
	var pobj=document.getElementById("pwdId");
	if(pobj.value==""){
	   document.getElementById("pwdTip").innerHTML = "密码不能为空";
	   return false;
	}
	return true;
}
</script>
</body>
</html>