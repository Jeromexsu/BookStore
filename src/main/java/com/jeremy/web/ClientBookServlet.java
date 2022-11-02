package com.jeremy.web;

import com.jeremy.bean.Page;
import com.jeremy.service.BookService;
import com.jeremy.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class ClientBookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();
    public void getPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageNo = Integer.parseInt(request.getParameter("pageNo"));
        Integer pageSize= Integer.parseInt(request.getParameter("pageSize"));
        Page page = bookService.queryPage(pageNo, pageSize);
        page.setUrl("clientBookServlet?action=getPage");
        page.setAction("getPage");
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/user/index.jsp").forward(request,response);
    }

    public void getPageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageNo = Integer.parseInt(request.getParameter("pageNo"));
        Integer pageSize= Integer.parseInt(request.getParameter("pageSize"));
        Integer lowPrice = Integer.parseInt(request.getParameter("min"));
        Integer highPrice = Integer.parseInt(request.getParameter("max"));
        Page page = bookService.queryPageWithPriceRange(pageNo,pageSize,new BigDecimal(lowPrice),new BigDecimal(highPrice));
        page.setUrl("clientBookServlet?action=getPageByPrice&min="+lowPrice+"&max="+highPrice);
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/user/index.jsp").forward(request,response);
    }

}
