package com.example.bookstoreall.dao.impl;

import com.example.bookstoreall.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//
public abstract class BaseDao {

    //使用DbUtils操作数据库
    private QueryRunner queryRunner=new QueryRunner();
    // 执行insert update  delete语句
    // 返回-1  表明执行失败  返回其他是受影响的行数
    public int update(String sql , Object ...args){
        Connection connection= JdbcUtils.getConnection();// 建立连接
        try {
           return  queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.Close(connection);
        }
        return -1;
    }

    /*
    *
    * 查询返回一个javabean的sql语句
    * type 返回的对象类型
    * sql 执行的sql语句
    * args sql对应的参数值
    * <T>  返回对应类型的泛型
    *
    * */

    public <T>  T  queryForOne(Class<T> type ,String sql,Object ...args){
        Connection con=JdbcUtils.getConnection();
        try {
           return queryRunner.query(con,sql,new BeanHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.Close(con);
        }
        return null;
    }

    /*
    * 查询返回多个javabean的sql语句
    * type 返回的对象类型
     * sql 执行的sql语句
     * args sql对应的参数值
     * <T>  返回对应类型的泛型
    *
    * */

    public <T> List<T> queryForList(Class<T> type , String sql, Object ...args){
        Connection con=JdbcUtils.getConnection();
        try {
           return queryRunner.query(con,sql,new BeanListHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.Close(con);
        }
        return null;
    }


    /*
    *
    *执行返回一行一列的语句
    * sql  sql 语句
    * args sql对应的参数值
    *
    * */
    public Object queryForSingleValue(String sql,Object...args){
        Connection conn=JdbcUtils.getConnection();
        try {
           return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.Close(conn);
        }
        return null;
    }

}
