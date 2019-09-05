package com.zhutao.ioc.service.impl;

import com.zhutao.ioc.pojo.User;
import com.zhutao.ioc.service.BookService;
import com.zhutao.ioc.service.OtherService;

/**
 * @Author: zhutao
 * @Date: 2019-09-05 20:36
 * @Version 1.0
 */
public class OtherServiceImpl implements OtherService {
    private User user;

    public OtherServiceImpl(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
