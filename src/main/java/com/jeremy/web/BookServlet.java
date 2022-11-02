package com.jeremy.web;

import com.jeremy.bean.Book;
import com.jeremy.bean.Page;
import com.jeremy.service.BookService;
import com.jeremy.service.impl.BookServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    public void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooksAll();
        long count = bookService.numberCount();
        req.setAttribute("books", books);
        req.setAttribute("count",count);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);

    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String id = req.getParameter("id");
        System.out.println(bookService.deleteBook(Integer.parseInt(id)));
        Integer pageNo = Integer.parseInt(req.getParameter("pageNo"));
        // current page pageNo=page.pageNo
        getPage(req,resp);
    }

    public void addBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Book book = new Book();
        Map<String, String[]> parameterMap = req.getParameterMap();
        BigDecimalConverter bd = new BigDecimalConverter(null);
        ConvertUtils.register(bd, java.math.BigDecimal.class);
        BeanUtils.populate(book,parameterMap);
        bookService.insertBook(book);
        //last page pageNo = itemsTotal
        getPage(req,resp);

    }

    public void updateBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Book book = new Book();
        Map<String, String[]> parameterMap = req.getParameterMap();
        BigDecimalConverter bd = new BigDecimalConverter(null);
        ConvertUtils.register(bd, java.math.BigDecimal.class);
        BeanUtils.populate(book,parameterMap);
        bookService.updateBook(book);
        // current page pageNo=page.pageNo
        getPage(req,resp);
    }

    public void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String id = req.getParameter("id");
        Book book = bookService.queryBookById(Integer.parseInt(id));
        req.setAttribute("book",book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);

    }

    public void getPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Integer pageNo = Integer.parseInt(req.getParameter("pageNo"));
        Integer pageSize = Integer.parseInt(req.getParameter("pageSize"));
        Page page = bookService.queryPage(pageNo, pageSize);
        page.setUrl("bookServlet?action=getPage");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

    }

}
