package com.zhutao.dao;

import com.zhutao.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: zhutao
 * @Date: 2019/2/12 11:22
 * @Version 1.0
 */
@Repository
public interface MyBatisUserDao {
    User getUser(Long id);

    User getUser2(Long id);
}
