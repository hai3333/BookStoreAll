package com.example.bookstoreall.poje.web;

import com.example.bookstoreall.poje.Book;
import com.example.bookstoreall.poje.Page;
import com.example.bookstoreall.service.BookService;
import com.example.bookstoreall.service.impl.BookServiceImpl;
import com.example.bookstoreall.utils.WebUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();



    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* int pageNo=WebUtils.parseInt(req.getParameter("pageNo"),0);
        pageNo+=1;*/
        //1获取请求的参数==封装成为book类
        Book book= WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        //2 调用bookService.addBook()保存图书
        bookService.addBook(book);

        //3 跳转到图书页面
                //  /manager/bookServlet? action=list
        // 这样写会多次提交页面
        //req.getRequestDispatcher("/manager/bookServlet? action=list").forward(req,resp);
        // 要加上工程名
        //System.out.println(req.getContextPath());
        //resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="
                +req.getParameter("pageNo"));
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //  1获取请求的参数id
        //test


           int id=WebUtils.parseInt(req.getParameter("id"),0);
        //2调用bookService.deletedBookById();删除图书
        bookService.deleteBookById(id);

        //3 重定向到图书管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="
        +req.getParameter("pageNo"));

    }
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取修改的图书编号
        int id=WebUtils.parseInt(req.getParameter("id"),0);
        // 调用bookService.queryBookById查寻图书
        Book book = bookService.queryBookById(id);
        // 保存图书到Request中
        req.setAttribute("book",book);
        //请求转发到pages/manager/book
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);



    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数 封装成为对象
        Book book=WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        //调用BookService.updateBook(book)
        bookService.updateBook(book);

        //重定向到图书管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="
                +req.getParameter("pageNo"));

    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过BookService 查询全部图书
        List<Book> books = bookService.queryBooks();

        //把全部图书保存到Request域中
        req.setAttribute("books", books);

        // 请求转发到/pages/manger/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);


    }


    /*
    *处理分页
    * */

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // 获取请求的参数pageNo和pageSize
        int pageNo=WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUtils.parseInt(req.getParameter("pageSize"),Page.PAGE_SIZE);
        // 调用BookService.page(pageNo,pageSize) page对象
        Page<Book> page=bookService.page(pageNo,pageSize);
        page.setUrl("manager/bookServlet?action=page");
        //保存Page对象到request域中
        req.setAttribute("page",page);
        //请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);


    }


}

