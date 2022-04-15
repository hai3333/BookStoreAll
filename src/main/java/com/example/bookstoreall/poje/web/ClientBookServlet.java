package com.example.bookstoreall.poje.web;

import com.example.bookstoreall.poje.Book;
import com.example.bookstoreall.poje.Page;
import com.example.bookstoreall.service.BookService;
import com.example.bookstoreall.service.impl.BookServiceImpl;
import com.example.bookstoreall.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet{
    private BookService bookService=new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("经过前台的程序");
        // 获取请求的参数pageNo和pageSize
        int pageNo= WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        // 调用BookService.page(pageNo,pageSize) page对象
        Page<Book> page=bookService.page(pageNo,pageSize);
        //保存Page对象到request域中
        req.setAttribute("page",page);

        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);


    }

}
