package com.example.bookstoreall.dao.impl;

import com.example.bookstoreall.dao.UserDao;
import com.example.bookstoreall.poje.User;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryByUsername(String username) {
        String sql="select id,username,password,email from t_user where username=?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql="select id,username,password,email from t_user where username=? and password=?";
        return queryForOne(User.class,sql,username,password);

    }

    @Override
    public int SaveUser(User user) {
        String sql="insert into t_user(username,password,email) values(?,?,?)";
return update(sql,user.getUsername(),user.getPassword(),user.getEmail());

    }
}
