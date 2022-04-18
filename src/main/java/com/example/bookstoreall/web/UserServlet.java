package com.example.bookstoreall.web;


import com.example.bookstoreall.poje.User;
import com.example.bookstoreall.service.UserService;
import com.example.bookstoreall.service.impl.UserServiceImpl;
import com.example.bookstoreall.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {

    UserService userService = new UserServiceImpl();
    /*
     * 除了登录请求
     *
     * */

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 调用userService处理业务\
        User loginUser = userService.login(new User(null, username, password, null));
        //==null说明登录失败
        if (loginUser == null) {
            req.setAttribute("msg", "用户名或者密码错误");
            req.setAttribute("username", username);
            //跳回登陆页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {

            //登陆成功
            //保存用户登录之后的信息
            req.getSession().setAttribute("user",loginUser);
            //跳转到页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);

        }

    }

    /*
    * 注销
    * */

    protected void loginOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                //1 销毁session中用户的登录信息
        req.getSession().invalidate();

        //2重定向到首页
        resp.sendRedirect(req.getContextPath());
    }


    /*
     *
     * 处理注册请求
     * */

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//super.doPost(req,resp);
        //获取session中的验证码
        String token=(String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);

        // 销毁验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //获取 请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
//
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

       /* try {
            System.out.println("注入前"+user);
            BeanUtils.populate(user,req.getParameterMap());
            System.out.println("注入后"+user);
        } catch (Exception e) {
            e.printStackTrace();
        }*/


//检查验证码是否正确  --- 写死 验证码 abcde
        if (token!=null && token.equalsIgnoreCase(code)) {
            //正确
            // 检查用户名是否正确
            if (userService.existsUsername(username)) {
                //System.out.println("用户名["+username+"]已存在");
                //      用户名存在的话把用户名信息回显
                req.setAttribute("msg", "用户名已存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

                // 返回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //可以用
                userService.registUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            //把错误信息保存
            req.setAttribute("msg", "验证码错误！");
            req.setAttribute("username", username);
            req.setAttribute("email", email);


            System.out.println("验证码错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }

    }

    /*
     *
     * 分发请求
     * */


}
