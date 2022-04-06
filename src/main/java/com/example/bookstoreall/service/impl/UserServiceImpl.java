package com.example.bookstoreall.service.impl;

import com.example.bookstoreall.dao.UserDao;
import com.example.bookstoreall.dao.impl.UserDaoImpl;
import com.example.bookstoreall.poje.User;
import com.example.bookstoreall.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.SaveUser(user);
    }

    @Override
    public User login(User user) {
       return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryByUsername(username) == null) {
            return false;
        } else {
            return true;
        }
    }
}
