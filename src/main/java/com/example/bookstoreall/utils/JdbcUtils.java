package com.example.bookstoreall.utils;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static DruidAbstractDataSource dataSource;

    static {

        Properties properties = new Properties();


        try {

            //读取jdbcpro配置文件
            InputStream inputStream = JdbcUtils.class.getResourceAsStream("/jdbc.properties");
            // 从流中加载数据
            properties.load(inputStream);

            // 创建数据库连接池
            dataSource = (DruidAbstractDataSource) DruidDataSourceFactory.createDataSource(properties);

            System.out.println(dataSource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

    /*
     * 获取数据库连接
     *返回conn 连接失败的话返回null
     * */

    public static Connection getConnection() {
        Connection conn=null;
        try {
            conn=dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return conn;
    }

    /*
     * 关闭连接 放回数据库连接池
     *
     * */
    public static void Close(Connection coon) {
        if(coon!=null){
            try {
                coon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
