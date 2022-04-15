package com.example.bookstoreall.dao;

import com.example.bookstoreall.dao.impl.BookDaoImpl;
import com.example.bookstoreall.poje.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    private  BookDao bookDao=new BookDaoImpl();


    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"李钦钦sb","干啥",new BigDecimal(10000),0,100,null));
    }

    @Test
    public void deleteBook() {
        bookDao.deleteBook(70);
    }

    @Test
    public void updateBook() {
       bookDao.updateBook(new Book(70,"李钦钦真好看（记得打钱）","干啥",new BigDecimal(10000),0,100,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(69));
    }

    @Test
    public void queryBooks() {
        for(Book k: bookDao.queryBooks()){
            System.out.println(k);
        }
    }
    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        System.out.println(bookDao.queryForPageItems(0,4));
        System.out.println();
    }

}