package com.zhutao.dao;

import com.zhutao.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * 事务
 * @Author: zhutao
 * @Date: 2019/2/11 20:59
 * @Version 1.0
 */
@Component
public class Dao2 {
    @Autowired
    private AppConfig appConfig;

    public String getDriverName(){
        System.out.println(appConfig.getUrl());
        return appConfig.getDriverName();
    }

    public static void main(String[] args){

    }

    public void testTrans() throws ClassNotFoundException {
        Class.forName(appConfig.getDriverName());

        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        Savepoint savepoint = null;
        try{

            connection = DriverManager.getConnection(appConfig.getUrl(), appConfig.getUsername(), appConfig.getPassword());

            String sql = "update t_user set `note` = 'hahaha' where id = 1";

            String sql2 = "update t_user set `note` = 'hahaha' where id = 2";

            String sql3 = "update t_user set `note` = 'note_haha' where id = ?";


            /**
             * 开启事务,将自动提交设为false
             */
            connection.setAutoCommit(false);

            statement = connection.createStatement();
            statement.executeUpdate(sql);
            savepoint = connection.setSavepoint("sp1");
            statement.executeUpdate(sql2);

            /**
             * 这样对sql进行拼接, 防止sql注入
             * index从1开始
             */
            preparedStatement = connection.prepareStatement(sql3);
            preparedStatement.setInt(1, 5);
            preparedStatement.executeUpdate();
            /**
             * 手动提交
             */
            connection.commit();


        }catch (Exception ex){
            try {
                if (savepoint != null){
                    connection.rollback(savepoint);
                } else {
                    connection.rollback();
                }

            } catch (SQLException e) {
                e.printStackTrace();
        }
        ex.printStackTrace();
        } finally {
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
