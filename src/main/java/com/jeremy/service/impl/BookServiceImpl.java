package com.jeremy.service.impl;

import com.jeremy.bean.Book;
import com.jeremy.bean.Page;
import com.jeremy.dao.BookDAO;
import com.jeremy.dao.impl.BookDAOImpl;
import com.jeremy.service.BookService;

import java.math.BigDecimal;
import java.util.List;

public class BookServiceImpl implements BookService {
    BookDAOImpl bookDAO = new BookDAOImpl();
    @Override
    public int insertBook(Book book) {
        return bookDAO.insertBook(book);
    }

    @Override
    public int updateBook(Book book) {
        return bookDAO.updateBook(book);
    }

    @Override
    public int deleteBook(Integer id) {
        return bookDAO.deleteBook(id);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDAO.queryBookByid(id);
    }



    @Override
    public List<Book> queryBooksAll() {
        return bookDAO.queryBooksAll();
    }

    @Override
    public Page queryPage(Integer pageNo, Integer pageSize) {
        Long booksTotal =(long) bookDAO.numberCount();
        Integer pageTotal = getPageTotal(pageSize,booksTotal);

        if(pageTotal==0) return new Page(1,pageSize,1,null,(long)0);

        if(pageNo <= 0) {
            List<Book> books = bookDAO.queryPage(1, pageSize);
            return new Page(1,pageSize,pageTotal,books,booksTotal);
        }
        if(pageNo > pageTotal) {
            List<Book> books = bookDAO.queryPage(pageTotal, pageSize);
            return new Page(pageTotal,pageSize,pageTotal,books,booksTotal);
        }

        List<Book> books = bookDAO.queryPage(pageNo, pageSize);
        return new Page(pageNo,pageSize,pageTotal,books,booksTotal);

    }

    public Integer getPageTotal(Integer pageSize,Long booksTotal) {
        Integer pageTotal = Math.toIntExact(booksTotal)/pageSize;
        if(booksTotal%pageSize!=0) pageTotal++;
        if(pageTotal==0) pageTotal=1;
        return pageTotal;
    }


    @Override
    public long numberCount() {
        return (long)bookDAO.numberCount();
    }

    @Override
    public Page queryPageWithPriceRange(Integer pageNo,Integer pageSize, BigDecimal lowPrice, BigDecimal highPrice) {
        Long booksTotal = (long) bookDAO.numberCountConditionPrice(lowPrice,highPrice);
        Integer pageTotal = getPageTotal(pageSize,booksTotal);
        if(pageTotal==0) return new Page(1,pageSize,1,null,(long)0);
        if(pageNo <= 0) {
            List<Book> books = bookDAO.queryPageItemsByPrice(lowPrice,highPrice,1,pageSize);
            return new Page(1,pageSize,pageTotal,books,booksTotal);
        }
        if(pageNo > pageTotal) {
            List<Book> books = bookDAO.queryPageItemsByPrice(lowPrice,highPrice,pageTotal, pageSize);
            return new Page(pageTotal,pageSize,pageTotal,books,booksTotal);
        }

        List<Book> books = bookDAO.queryPageItemsByPrice(lowPrice, highPrice, pageNo,pageSize);
        return new Page(pageNo,pageSize,pageTotal,books,booksTotal);

    }
}
