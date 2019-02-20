package com.zhutao.service;

import com.zhutao.pojo.User;
import com.zhutao.pojo.vo.UserQueryVO;

import java.util.List;

/**
 * @Author: zhutao
 * @Date: 2019/2/12 14:44
 * @Version 1.0
 */
public interface UserService {
    User getUser(Long id);

    User getUser2(Long id);

    List<User> getUserByName(String name);

    List<User> getListById(List<Long> list);

    List<User> getListByQuery(UserQueryVO userQueryVO);

    int insertUser(User user);

    int insertBatch(List<User> users);

    int updateUser(User user);

    int removeUser(Long id);

    int insertUsers(List<User> users);
}
