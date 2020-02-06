package com.zhutao.learn.spring.ioc.service.impl;

import com.zhutao.learn.spring.ioc.pojo.User;
import com.zhutao.learn.spring.ioc.service.BookService;

/**
 * @Author: zhutao
 * @Date: 2019-09-05 20:36
 * @Version 1.0
 */
public class BookServiceImpl implements BookService {
    private User user;

    public BookServiceImpl(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
