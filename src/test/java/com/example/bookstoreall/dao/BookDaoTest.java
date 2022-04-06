package com.example.bookstoreall.dao;

import com.example.bookstoreall.dao.impl.BookDaoImpl;
import com.example.bookstoreall.poje.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookDaoTest {
    private  BookDao bookDao=new BookDaoImpl();


    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"李钦钦sb","干啥",new BigDecimal(10000),0,100,null));
    }

    @Test
    public void deleteBook() {
        //bookDao.deleteBook(63);
    }

    @Test
    public void updateBook() {
       bookDao.updateBook(new Book(64,"李钦钦真好看（记得打钱）","干啥",new BigDecimal(10000),0,100,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(64));
    }

    @Test
    public void queryBooks() {
        //System.out.println(bookDao.queryBooks());
    }
}