<%@page import="java.util.ArrayList"%>
<%@ page import="model.Products" %>
<%@ page import="dao.ProductsDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>传习教育网上书城</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"> 
	   传习教育网上书城
	</div>
    <div style="width:380px; height:50px; float:right; position:absolute; left:60%; top:2px; line-height:50px">
	    <img src="images/cart.gif" style="margin-bottom:-4px" width="26" height="23">
		  欢迎您： ${User.username } &nbsp;
                  <a href="myAccount.jsp">我的帐户</a>
				| <a href="productCategory.jsp">商品分类</a> 
				| <a href="#">帮助中心</a>  
	</div>
	<div id="navbar">
		<div class="userMenu">
			<ul>
				<li class="current"><a href="index.html">User首页</a></li>
				<li><a href="orderlist.html">我的订单</a></li>
				<li><a href="shopping.html">购物车</a></li>
				<li><a href="logout.do" onclick="javascript:return confirm_logout()">注销</a></li>
			</ul>
		</div>
		<form method="get" name="search" action="">
			搜索：<input class="input-text" type="text" name="keywords" /><input class="input-btn" type="submit" name="submit" value="" />
		</form>
	</div>
</div>
<div id="content" class="wrap">
	<div class="list bookList">
		<form method="post" name="shoping" action="shopping.html">
			<table>
				<tr class="title">
					<th class="checker"></th>
					<th>书名</th>
					<th class="price">价格</th>
					<th class="store">库存</th>
					<th class="view">图片预览</th>
				</tr>
				<%
				ProductsDao dao = new ProductsDao();
				ArrayList<Products> prods = dao.findAll();
				for(int i=0; i<prods.size(); i++){
					Products p = prods.get(i);
				%>
				<tr>
					<td><input type="checkbox" name="bookId" value="<%=p.getId() %>" /></td>
					<td class="title"><%=p.getName() %></td>
					<td>￥<%=p.getClass() %></td>
					<td><%=p.getPnum() %></td>
					<td class="thumb"><img src="<%=p.getImgurl() %>" width="100px" height="100px"/></td>
				</tr>
				<%}%>
			</table>
			<div class="page-spliter">
				<a href="#">&lt;</a>
				<a href="#">首页</a>
				<span class="current">1</span>
				<a href="#">2</a>
				<a href="#">3</a>
				<a href="#">4</a>
				<span>...</span>
				<a href="#">尾页</a>
				<a href="#">&gt;</a>
			</div>
			<div class="button"><input class="input-btn" type="submit" name="submit" value="" /></div>
		</form>
	</div>
</div>
<div id="footer" class="wrap">
	传习教育网上书城 &copy; 版权所有

</div>
</body>
</html>
 