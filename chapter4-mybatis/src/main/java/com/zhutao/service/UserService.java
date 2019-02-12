package com.zhutao.service;

import com.zhutao.pojo.User;

/**
 * @Author: zhutao
 * @Date: 2019/2/12 14:44
 * @Version 1.0
 */
public interface UserService {
    User getUser(Long id);

    User getUser2(Long id);
}
