package com.example.bookstoreall.service;

import com.example.bookstoreall.poje.Book;
import com.example.bookstoreall.poje.Page;

import java.util.List;

public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();


    Page<Book> page(int pageNo, int pageSize);
}
