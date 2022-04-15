package com.example.bookstoreall.service;

import com.example.bookstoreall.poje.Book;
import com.example.bookstoreall.poje.Page;
import com.example.bookstoreall.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {
    BookService bookService=new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"真的学习效率低","海福生",new BigDecimal(99),1000,99,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(72);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(71,"李钦钦sbb","李钦钦",new BigDecimal(23.5),1000,1,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(71));
    }

    @Test
    public void queryBooks() {
       for(Book i: bookService.queryBooks()){
           System.out.println(i);
       }
    }


    @Test
    public  void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }
}