package com.zhutao.service.impl;

import com.zhutao.dao.MyBatisUserDao;
import com.zhutao.pojo.User;
import com.zhutao.pojo.vo.UserQueryVO;
import com.zhutao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<User> getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    public List<User> getListById(List<Long> list) {
        return userDao.getListById(list);
    }

    @Override
    public List<User> getListByQuery(UserQueryVO userQueryVO) {
        return userDao.getListByQuery(userQueryVO);
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int insertBatch(List<User> users) {
        return userDao.insertBatch(users);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int removeUser(Long id) {
        return userDao.removeUser(id);
    }
}
