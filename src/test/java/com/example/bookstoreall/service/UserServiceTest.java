package com.example.bookstoreall.service;

import com.example.bookstoreall.poje.User;
import com.example.bookstoreall.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    UserService userService=new UserServiceImpl();
    @Test
    //注册
    void registUser() {
        userService.registUser(new User(null,"还各个","qwerty","hai@qq.com"));
        userService.registUser(new User(null,"海荣","hairongsb","bbbbbb@qq.com"));

    }

    @Test
    // 登录
    void login() {
        System.out.println(userService.login(new User(null,"李固","ligusb","qwert@163.com")));
        System.out.println(userService.login(new User(null,"海荣","hairongsb","bbbbbb@qq.com")));

    }

    @Test
    void existsUsername() {
        // 验证用户名是否可用
        if(userService.existsUsername("wzw")){
            System.out.println("用户名不可用");
        }else{
            System.out.println("用户名可用");
        }
    }
}