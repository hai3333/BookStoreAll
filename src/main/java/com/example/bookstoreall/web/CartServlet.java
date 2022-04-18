package com.example.bookstoreall.web;

import com.example.bookstoreall.poje.Book;
import com.example.bookstoreall.poje.Cart;
import com.example.bookstoreall.poje.CartItem;
import com.example.bookstoreall.service.BookService;
import com.example.bookstoreall.service.impl.BookServiceImpl;
import com.example.bookstoreall.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    //  加入购物车
    protected void addItems(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        //调用bookservice。queryBookbyid得到图书信息
        Book book = bookService.queryBookById(id);
        //把图书信息转换为cartitem
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //调用cart.additem添加商品
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);

        req.getSession().setAttribute("LastName",cartItem.getName());
        //重定向到商品页

        resp.sendRedirect(req.getHeader("Referer"));

    }

    /* 删除商品项目*/
    protected void deleteItems(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
            //重定向购物车展示
            resp.sendRedirect(req.getHeader("Referer"));

        }


    }

    /*
     * 清空购物车
     * */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }


    }
    /*
    * 修改商品数量
    * */

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           //获取商品编号
        int id=WebUtils.parseInt(req.getParameter("id"),0);
        int count=WebUtils.parseInt(req.getParameter("count"),1);
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart!=null){
            //修改
            cart.updateCount(id,count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}