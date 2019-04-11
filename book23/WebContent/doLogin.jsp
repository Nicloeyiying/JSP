<%@ page import="model.User" %>
<%@ page import="dao.UsersDao" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>接收用户登录的数据</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String name=request.getParameter("userName");
	String pwd=request.getParameter("passWord");
	out.print("<h1>输入的用户名："+name+"</h1>");
	out.print("<h1>输入的密码："+pwd+"</h1>");
	UsersDao dao = new UsersDao();
	User u = dao.findUserByNameAndPwd(name,pwd);
	if(u == null){
		out.print("<h2>登录失败!</h2>");
	}else{
		out.print("<h2>"+u.getName()+"登录成功！</h2>");
	}
%>
</body>
</html>