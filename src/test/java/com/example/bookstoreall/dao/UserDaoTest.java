package com.example.bookstoreall.dao;

import com.example.bookstoreall.dao.impl.UserDaoImpl;
import com.example.bookstoreall.poje.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    UserDao userDao=new UserDaoImpl();
    @Test
    void queryByUsername() {

        //System.out.println(userDao.queryByUsername("admin"));
        if(userDao.queryByUsername("admin")==null){
            System.out.println("用户名可用");
        }else{
            System.out.println("用户名已存在");
        }
    }

    @Test
    void queryUserByUsernameAndPassword() {
       if(userDao.queryUserByUsernameAndPassword("admin0","admin")==null){
           System.out.println("用户名或者密码错误，登陆失败");
       }else{
           System.out.println("登陆成功");
       }

    }

    @Test
    void saveUser() {
        System.out.println(userDao.SaveUser(new User(null,"李青青","123456","12321213@qq.com")));
    }
}