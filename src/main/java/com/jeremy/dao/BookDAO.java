package com.jeremy.dao;

import com.jeremy.bean.Book;

import java.math.BigDecimal;
import java.util.List;

public interface BookDAO {
    int insertBook(Book book);
    int updateBook(Book book);
    int deleteBook(Integer id);
    Book queryBookByid(Integer id);

    List<Book> queryBooksAll();

    List<Book> queryPage(Integer pageNo, Integer pageSize);


    Object numberCount();

    List<Book> queryPageItemsByPrice(BigDecimal lowPrice, BigDecimal highPrice,Integer pageNo, Integer pageSize);
    Object numberCountConditionPrice(BigDecimal lowPrice, BigDecimal highPrice);

}
