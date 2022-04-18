package com.example.bookstoreall.web;

import com.example.bookstoreall.poje.User;
import com.example.bookstoreall.service.UserService;
import com.example.bookstoreall.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*
* 没用了
*
* */
public class LoginServlet  extends HttpServlet {
    private UserService userService = new UserServiceImpl();

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //获取参数
//        String username= req.getParameter("username");
//        String password=req.getParameter("password");
//        // 调用userService处理业务\
//        User loginUser = userService.login(new User(null, username, password, null));
//       //==null说明登录失败
//        if(loginUser==null){
//            System.out.println("用户名或者密码错误");
//            req.getRequestDispatcher("/page/user/login.jsp").forward(req,resp);
//        }else {
//            //登陆成功
//            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
//
//        }
//    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        //获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 调用userService处理业务\
        User loginUser = userService.login(new User(null, username, password, null));
        //==null说明登录失败
        if(loginUser==null){
            req.setAttribute("msg","用户名或者密码错误");
            req.setAttribute("username",username);
            //跳回登陆页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            //登陆成功
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);

        }
    }


}
