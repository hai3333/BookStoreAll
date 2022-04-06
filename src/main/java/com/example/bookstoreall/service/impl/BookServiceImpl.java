package com.example.bookstoreall.service.impl;

import com.example.bookstoreall.dao.BookDao;
import com.example.bookstoreall.dao.impl.BookDaoImpl;
import com.example.bookstoreall.poje.Book;
import com.example.bookstoreall.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);

    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {

        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }
}
