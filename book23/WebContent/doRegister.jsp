<%@ page import="java.util.Date" %>
<%@ page import="model.User" %>
<%@ page import="dao.UsersDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册表单信息</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String name=request.getParameter("userName");
	String passWord=request.getParameter("passWord");
	String rePassWord=request.getParameter("rePassWord");
	String email=request.getParameter("email");
	out.print("<h2>用户名："+name+"</h2>");
	out.print("<h2>密码："+passWord+"</h2>");
	out.print("<h2>确认密码："+rePassWord+"</h2>");
	out.print("<h2>邮箱："+email+"</h2>");
	UsersDao dao = new UsersDao();
	User user = new User();
	user.setName(name);
	user.setPassWord(passWord);
	user.setEmail(email);
	user.setBirthday(new Date());
	if(dao.insert(user)){
		out.print("<h2>"+name+"注册成功！</h2>");
	}else{
		out.print("<h2>注册失败！</h2>");
	}
%>
</body>
</html>