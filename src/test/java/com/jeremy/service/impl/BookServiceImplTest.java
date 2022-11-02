package com.jeremy.service.impl;

import com.jeremy.bean.Book;
import com.jeremy.service.BookService;
import org.junit.Test;

import java.math.BigDecimal;

public class BookServiceImplTest {
    BookServiceImpl bookService = new BookServiceImpl();
    private Book book = new Book(null, "Test", "Jeremy", new BigDecimal(9.9), 10, 1, null);
    @Test
    public void insertBook() {
        System.out.println(bookService.insertBook(book));
    }

    @Test
    public void updateBook() {
        book.setId(22);
        book.setName("Test Service Update");
        System.out.println(bookService.updateBook(book));
    }

    @Test
    public void deleteBook() {
        System.out.println(bookService.deleteBook(22));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(1));
    }


    @Test
    public void queryBooksAll() {
            bookService.queryBooksAll().forEach(System.out::println);
    }

    @Test
    public void numberCount() {
        System.out.println(bookService.numberCount());
    }

    @Test
    public void queryPage() {
        System.out.println(bookService.queryPage(1,5));
    }

    @Test
    public void queryPageWithPriceRange() {
        System.out.println(bookService.queryPageWithPriceRange(2,4,new BigDecimal(0),new BigDecimal(9999)));
    }
}