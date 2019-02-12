package com.zhutao.service;

import com.zhutao.dao.Dao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: zhutao
 * @Date: 2019/2/11 21:01
 * @Version 1.0
 */
@Service
public class JdbcService {
    @Autowired
    private Dao2 dao2 = null;

    @Autowired
    private DataSource dataSource = null;

    public void testDataSource(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            System.out.println(connection.getClass().getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
