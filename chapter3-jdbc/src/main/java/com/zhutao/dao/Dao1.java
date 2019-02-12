package com.zhutao.dao;

import com.mysql.cj.jdbc.MysqlSavepoint;

import java.sql.*;

/**
 * @Author: zhutao
 * @Date: 2019/2/11 20:32
 * @Version 1.0
 */
public class Dao1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /**
         * 1. 注册驱动(mysql5 之后的驱动可以不注册)
         *     static {
         *         try {
         *             DriverManager.registerDriver(new Driver());
         *         } catch (SQLException var1) {
         *             throw new RuntimeException("Can't register driver!");
         *         }
         *     }
         * 这里实际上使用的是静态代码块中registerDriver方法进行注册
         * 这些代码会在类被加载时执行
         */
        Class.forName("com.mysql.jdbc.Driver");


        /**
         * 2. 获取连接对象
         */
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "qwe121324");

        // 3. 定义sql
        String sql = "update t_user set `note` = 'hahaha' where id = 1";

        /**
         * 4.获取执行sql的对象statement/PreparedStatement
         */
        Statement statement = connection.createStatement();

        /**
         * 5. 执行sql
         */
        int count = statement.executeUpdate(sql);

        /**
         * 6. 处理结果
         */
        System.out.println(count);

        /**
         * 7. 释放资源
         */

        statement.close();

        connection.close();
    }
}
