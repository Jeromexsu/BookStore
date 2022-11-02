<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>客户书城首页</title>
		<base href="http://localhost:8080/BookStore/">
		<link type="text/css" rel="stylesheet" href="static/css/style.css" >
	</head>
	<body>

		<div id="header">
				<img class="logo_img" alt="" src="static/img/logo.gif" >
				<span class="wel_word">网上书城</span>
				<div>
					<a href="pages/user/login.jsp">登录</a> |
					<a href="pages/user/register.jsp">注册</a> &nbsp;&nbsp;
					<a href="pages/cart/cart.jsp">购物车</a>
					<a href="pages/manager/manager.jsp">后台管理</a>
				</div>
		</div>
		<div id="main">
			<div id="book">
				<div class="book_cond">
					<form action="clientBookServlet" method="get">
						<input type="hidden" name="action" value="getPageByPrice">
						<input type="hidden" name="pageNo" value="1">
						<input type="hidden" name="pageSize" value="4">
						价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
							<input id="max" type="text" name="max" value="${param.max}"> 元
							<input type="submit" value="查询" />
					</form>
				</div>
				<div style="text-align: center">
					<span>您的购物车中有3件商品</span>
					<div>
						您刚刚将<span style="color: red">时间简史</span>加入到了购物车中
					</div>
				</div>
				<c:forEach items="${page.items}" var="book">
					<div class="b_list">
						<div class="img_div">
							<img class="book_img" alt="" src="static/img/default.jpg" />
						</div>
						<div class="book_info">
							<div class="book_name">
								<span class="sp1">书名:</span>
								<span class="sp2">${book.name}</span>
							</div>
							<div class="book_author">
								<span class="sp1">作者:</span>
								<span class="sp2">${book.author}</span>
							</div>
							<div class="book_price">
								<span class="sp1">价格:</span>
								<span class="sp2">￥${book.price}</span>
							</div>
							<div class="book_sales">
								<span class="sp1">销量:</span>
								<span class="sp2">${book.sales}</span>
							</div>
							<div class="book_amount">
								<span class="sp1">库存:</span>
								<span class="sp2">${book.stock}</span>
							</div>
							<div class="book_add">
								<button>加入购物车</button>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<%@include file="../public/page.jsp"%>
		</div>

		<%@include file="../public/footer.jsp"%>
	</body>
</html>