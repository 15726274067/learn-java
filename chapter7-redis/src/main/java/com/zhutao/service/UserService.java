package com.zhutao.service;

import com.zhutao.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhutao
 * @Date: 2019/2/14 23:36
 * @Version 1.0
 */
@Service
public interface UserService {
    User getUser(Long id);

    List<User> findUsers(String userName, String note);

    User insertUser(User user);

    User updateUserName(Long id, String userName);

    int deleteUser(Long id);
}
