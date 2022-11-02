package com.jeremy.dao.impl;

import com.jeremy.bean.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDAOImplTest {
    private BookDAOImpl bookDAO = new BookDAOImpl();
    private Book book = new Book(null, "Test", "Jeremy", new BigDecimal(9.9), 10, 1, null);


    @Test
    public void insertBook() {
        System.out.println(bookDAO.insertBook(book));

    }

    @Test
    public void updateBook() {
        book.setName("Test Update");
        book.setId(21);
        System.out.println(bookDAO.updateBook(book));
    }

    @Test
    public void deleteBook() {
        System.out.println(bookDAO.deleteBook(21));
    }

    @Test
    public void queryBookByid() {
        Book book1 = bookDAO.queryBookByid(1);
        System.out.println(book1);
    }


    @Test
    public void queryAll() {
        bookDAO.queryBooksAll().forEach(System.out::println);
    }

    @Test
    public void numberCount() {
        System.out.println(bookDAO.numberCount());
    }

    @Test
    public void queryPage() {
       bookDAO.queryPage(2,5).forEach(System.out::println);
    }

    @Test
    public void queryPageItemsByPrice() {
       bookDAO.queryPageItemsByPrice(new BigDecimal(10),new BigDecimal(30),1,4).forEach(System.out::println);
    }
    @Test
    public void numberCountConditionPrice() {
        System.out.println(bookDAO.numberCountConditionPrice(new BigDecimal(10) ,new BigDecimal(30)));
    }
}