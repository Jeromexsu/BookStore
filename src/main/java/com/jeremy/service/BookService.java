package com.jeremy.service;

import com.jeremy.bean.Book;
import com.jeremy.bean.Page;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {
    int insertBook(Book book);
    int updateBook(Book book);
    int deleteBook(Integer id);
    Book queryBookById(Integer id);
    List<Book> queryBooksAll();
    Page queryPage(Integer pageNo, Integer pageSize);
    Integer getPageTotal(Integer pageSize,Long booksTotal);
    long numberCount();
    Page queryPageWithPriceRange(Integer pageNo,Integer pageSize, BigDecimal lowPrice, BigDecimal highPrice);
}
