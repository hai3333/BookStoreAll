package com.example.bookstoreall.service;

import com.example.bookstoreall.poje.User;

public interface UserService {
    /*
     * 注册用户
     *
     * */
    public void registUser(User user);

    /*
     * 登录
     * 返回null表实登陆失败
     *
     *
     * */
    public User login(User user);

    /*
     *
     * 检查用户名是否可用
     *返回ture表实用户名存在
     * 返回false 表实用户名不存在 可用
     * */

    public boolean existsUsername(String username);


}



