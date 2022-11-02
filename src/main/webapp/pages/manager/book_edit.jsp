<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>编辑图书</title>
	<%@include file="../public/head.jsp"%>>
	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>

<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
			<%@include file="../public/manage_menu.jsp"%>>
		</div>
		
		<div id="main">
				<span class="book_count"></span>
				<form action="bookServlet" method="post">
					<input type="hidden" name="action" value=${empty requestScope.book? "addBook":"updateBook"}>
					<input type="hidden" name="pageNo" value="${param.get("pageNo")}">
					<input type="hidden" name="pageSize" value="${param.get("pageSize")}">
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="name" type="text" value=${requestScope.book.name}></td>
						<td><input name="price" type="text" value=${requestScope.book.price}></td>
						<td><input name="author" type="text" value=${requestScope.book.author}></td>
						<td><input name="sales" type="text" value=${requestScope.book.sales}></td>
						<td><input name="stock" type="text" value=${requestScope.book.stock}></td>
						<input type="hidden" name="id" value=${requestScope.book.id}>
						<td><input type="submit" value="${empty requestScope.book? "添加":"修改"}" /></td>
					</tr>	
				</table>
			</form>
			
	
		</div>
		
		<%@include file="../public/footer.jsp"%>
</body>
</html>