package com.example.bookstoreall.dao;

import com.example.bookstoreall.utils.JdbcUtils;
import org.testng.annotations.Test;

import java.sql.Connection;

public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils() {
        for (int i = 0; i < 100; i++) {
            // 获取之后要释放
            Connection connection=JdbcUtils.getConnection();
            System.out.println(connection);
           // 释放
            JdbcUtils.Close(connection);
        }
    }
}
