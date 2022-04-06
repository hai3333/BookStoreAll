package com.example.bookstoreall.dao;

import com.example.bookstoreall.poje.User;

public interface UserDao {

    /*
    *根据用户名查询用户信息
    *username 用户名
    * 没有查到返回null
    *
    * */
    public User queryByUsername(String username);


    /*
    * 根据用户名和密码查询用户
    *
    *返回null说明用户名或者密码错误，反之亦然
    *
    * */

    public  User queryUserByUsernameAndPassword(String username,String password);

    /*
    * 保存用户信息
    *
    * */
    public int SaveUser(User user);




}
