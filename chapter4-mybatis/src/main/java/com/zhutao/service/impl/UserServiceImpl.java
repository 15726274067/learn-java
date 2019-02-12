package com.zhutao.service.impl;

import com.zhutao.dao.MyBatisUserDao;
import com.zhutao.pojo.User;
import com.zhutao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhutao
 * @Date: 2019/2/12 14:44
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MyBatisUserDao userDao = null;

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public User getUser2(Long id) {
        return userDao.getUser2(id);
    }
}
