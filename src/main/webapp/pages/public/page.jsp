<%--
  Created by IntelliJ IDEA.
  User: JeromeSu
  Date: 27/10/2022
  Time: 10:21 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page" align="center">
  <a href="${page.url}&pageNo=1&pageSize=${page.pageSize}">首页</a>&nbsp
  <a href="${page.url}&pageNo=${page.pageNo==1?1:page.pageNo-1}&pageSize=${page.pageSize}">上一页</a>&nbsp
  <a href="${page.url}&pageNo=${page.pageNo==1?1:page.pageNo-1}&pageSize=${page.pageSize}">${page.pageNo==1?"":page.pageNo-1}</a>&nbsp
  [${page.pageNo}] &nbsp
  <a href="${page.url}&pageNo=${page.pageNo==page.pageTotal? page.pageTotal:page.pageNo+1}&pageSize=${page.pageSize}">${page.pageNo==page.pageTotal? "":page.pageNo+1}</a>&nbsp
  <a href="${page.url}&pageNo=${page.pageNo==page.pageTotal? page.pageTotal:page.pageNo+1}&pageSize=${page.pageSize}">下一页</a>&nbsp
  <a href="${page.url}&pageNo=${page.pageTotal}&pageSize=${page.pageSize}">末页</a>&nbsp
  共${page.pageTotal}页 &nbsp
  共${page.itemTotal}条记录 &nbsp
  <form action="${page.url}" method="get">
    <input type="hidden" name="pageSize" value="${page.pageSize}">
    到第
    <input type="text" name="pageNo"/>
    页
    <input type="submit" value="跳转">
  </form>
</div>
