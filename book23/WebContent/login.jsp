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
	<h2>用户登陆</h2><form method="get" action="doLogin.jsp" 
    onSubmit="return ckLogin()">
		<dl>
			<dt>用户名：</dt>
			<dd><input class="input-text" type="text" name="userName" id="userID" />
            <span id="uidTip"></span></dd>
			<dt>密　码：</dt>
			<dd><input class="input-text" type="password" name="passWord" id="pwdId" />
            <span id="pwdTip"></span></dd>
			<dt></dt>
			<dd class="button"><input class="input-btn" type="submit" name="submit" value="" /><input class="input-reg" type="button" name="register" value="" onclick="window.location='register.html';" /></dd>
		</dl>
	</form>
</div>
<div id="footer" class="wrap">
	传习教育网上书城 &copy; 版权所有
</div>
<script type="text/javascript">
function ckLogin(){
	var isok=false;
	var uid = document.getElementByld("userID");
	if(uid.value==""){
		document.getElementByld("uidTip").innerHTML="请输入登录的用户名称！"
        isok=false;
	}else{
    	document.getElementById("uidTip").innerHTML="";
        isok=true;
    }
    var pid = document.getElementById("pwdId");
    if(pid.value==""){
    	document.getElementById("pwdTip").innerHTML="请输入登录的密码！";
        isok=false;
    }else{
    	document.getElementById("pwdTip").innerHTML="";
        isok=true;
    }
    return isok;
}
</script>
</body>
</html>