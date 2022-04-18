package com.example.bookstoreall.web;

import com.example.bookstoreall.poje.Book;
import com.example.bookstoreall.poje.Page;
import com.example.bookstoreall.service.BookService;
import com.example.bookstoreall.service.impl.BookServiceImpl;
import com.example.bookstoreall.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("经过前台的程序");
        // 获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        // 调用BookService.page(pageNo,pageSize) page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=page");

        //保存Page对象到request域中
        req.setAttribute("page", page);

        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);


    }


    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // 获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        // 调用BookService.page(pageNo,pageSize) page对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        //如果有最小 追加到分页地址
        if (req.getParameter("min") != null) {
            sb.append("&min=").append(req.getParameter("min"));
        }
        if (req.getParameter("max") != null) {
            sb.append("&max=").append(req.getParameter("max"));
        }

        page.setUrl(sb.toString());
        //保存Page对象到request域中
        req.setAttribute("page", page);

        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);


    }


}
