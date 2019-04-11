<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
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
		<div class="userMenu">
			<ul>
				<li><a href="index.html">User首页</a></li>
				<li><a href="orderlist.html">我的订单</a></li>
				<li class="current"><a href="shopping.html">购物车</a></li>
				<li><a href="#">注销</a></li>
			</ul>
		</div>
		<form method="get" name="search" action="">
			搜索：<input class="input-text" type="text" name="keywords" /><input class="input-btn" type="submit" name="submit" value="" />
		</form>
	</div>
</div>
<div id="content" class="wrap">
	<div class="list bookList">
		<form method="post" name="shoping" action="shopping-success.html">
			<table>
				<tr class="title">
					<th class="view">图片预览</th>
					<th>书名</th>
					<th class="nums">数量</th>
					<th class="price">价格</th>
				</tr>
				<c:if test="${empty cart}">
				   <tr>
				     <td colspan="4">
				       <h3>您的购物车空空如也</h3>
				     </td>
				   </tr>
				</c:if>
				<c:if test="${!empty cart}">
				<c:set var="totalPrice" value="0"/>
				<c:forEach items="${cart}" var="entry">
				<tr>
					<td class="thumb"><img src="${entry.key.imgurl}" width="100px" height="100px"/></td>
					<td class="title">${entry.key.name}</td>
					<td>
					<input type="button" value=" - " onclick="changeNum('${entry.key.id}',${entry.value-1 })">
					<input class="input-text" type="text" readonly="readonly" id="nums" name="nums" maxlength="3"
					 value="${entry.value }" />			
					<input type="button" value=" + " onclick="changeNum('${entry.key.id}',${entry.value+1 })">
					</td>
					<td>￥<span>${entry.key.price}</span></td>
				</tr>
				<c:set var="totalPrice" value="${totalPrice + entry.key.price * entry.value}"/>
				</c:forEach>
				</c:if>
			</table>
			<div class="button">
				<h4>总价：￥<span>${totalPrice}</span>元</h4>
				<input class="input-chart" type="submit" name="submit" value="" />
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	function changeNum(id,count){
		//salert(id);
		//alert(count);
		//数量不能小于0，大于总数
		location.href="http://localhost:8080/book8/updateCart.do?id="+id+"&count="+count;
	}
</script>
<div id="footer" class="wrap">
	传习教育网上书城 &copy; 版权所有

</div>
</body>
</html>
    