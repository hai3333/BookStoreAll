package com.example.bookstoreall.dao;

import com.example.bookstoreall.poje.Book;

import java.util.List;

//写有什么功能
public interface BookDao {
    //增加
    public int addBook(Book book);

    //删除
    public  int deleteBook(Integer id);

    //修改
    public  int  updateBook(Book book);

    // 查找
    public  Book queryBookById(Integer id);
    public List<Book> queryBooks();


    // 分页
    Integer queryForPageTotalCount();


    List<Book> queryForPageItems(int begin, int pageSize);
}
