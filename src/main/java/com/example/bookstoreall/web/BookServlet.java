package com.example.bookstoreall.web;

import com.example.bookstoreall.poje.Book;
import com.example.bookstoreall.service.BookService;
import com.example.bookstoreall.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class BookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过BookService 查询全部图书
        List<Book> books = bookService.queryBooks();

        //把全部图书保存到Request域中
        req.setAttribute("books", books);

        // 请求转发到/pages/manger/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);


    }

}

