package com.zhutao.service;

import com.zhutao.dao.Dao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String getDriverName() {
       return dao2.getDriverName();
    }
}
