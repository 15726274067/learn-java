package com.zhutao.ioc.service.impl;

import com.zhutao.ioc.pojo.User;
import com.zhutao.ioc.service.BookService;

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
