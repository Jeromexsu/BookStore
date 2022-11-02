package com.jeremy.dao.impl;

import com.jeremy.bean.Book;
import com.jeremy.dao.BookDAO;

import java.math.BigDecimal;
import java.util.List;

public class BookDAOImpl extends BaseDAO implements BookDAO {


    @Override
    public int insertBook(Book book) {
        String sql = "insert into book(`name`,`author`,`price`,`sales`,`stock`,`cover_path`) values(?,?,?,?,?,?)";
        return
            update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getCover_path());
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`cover_path`=? where id = ?";
        return
            update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getCover_path(),book.getId());
    }

    @Override
    public int deleteBook(Integer id) {
        String sql = "delete from book where id = ? ";
        return update(sql,id);
    }

    @Override
    public Book queryBookByid(Integer id) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`cover_path` from book where id = ?";
        return query(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooksAll() {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`cover_path` from book";
        return queryList(Book.class,sql);
    }


    @Override
    public Object numberCountConditionPrice(BigDecimal lowPrice, BigDecimal highPrice) {
        String sql = "select count(id) from book where price >= ? and price <= ?";
        return queryVal(sql,lowPrice,highPrice);
    }

    @Override
    public List<Book> queryPage(Integer pageNo, Integer pageSize) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`cover_path` from book limit ?,?";
        Integer begin = (pageNo-1)*pageSize;
        Integer length = pageSize;
        return queryList(Book.class,sql,begin,length);
    }

    @Override
    public Object numberCount() {
        String sql = "select count(id) from book";
         return queryVal(sql);
    }

    @Override
    public List<Book> queryPageItemsByPrice(BigDecimal lowPrice, BigDecimal highPrice,Integer pageNo,Integer pageSize) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`cover_path` from book where price >= ? and price <=? limit ?,?";
        Integer begin = (pageNo-1)*pageSize;
        Integer length = pageSize;
        return queryList(Book.class,sql,lowPrice,highPrice,begin,length);
    }



}
