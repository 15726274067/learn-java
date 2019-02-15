package com.zhutao.service.impl;

import com.zhutao.dao.UserDao;
import com.zhutao.pojo.User;
import com.zhutao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: zhutao
 * @Date: 2019/2/14 23:38
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao = null;

    /**
     * 注解@Cacheable 表示先从缓存中通过定义的键查询.
     * 如果可以查询到数据，则返回
     * 否则执行该方法,返回数据,并且将返回结果保存到缓存中
     * @param id
     * @return
     */
    @Override
    @Cacheable(value = "redisCache", key = "'user:' + #id")
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    /**
     * 缓存命中率低,不使用缓存
     * @param userName
     * @param note
     * @return
     */
    @Override
    public List<User> findUsers(String userName, String note) {
        return userDao.findUsers(userName, note);
    }

    /**
     * 注解@CachePut表示将方法返回结果进行缓存
     *
     * @param user
     * @return
     */
    @Override
    @Transactional
    @CachePut(value = "redisCache", key = "'user:' + #result.id")
    public User insertUser(User user) {
        userDao.insertUser(user);
        return user;
    }

    // 更新数据后，更新缓存，如果 condition 配置项使结果返回为 null, 不缓存
    @CachePut(value = "redisCache", key = "'user:' + #id", condition = "#result!='null'")
    public User updateUserName(Long id, String userName){
        /**
         * 这里直接调用缓存注解方法,缓存注解会失效(基于aop实现)
         */
        User user = this.getUser(id);
        if (user == null) return null;
        user.setUserName(userName);
        userDao.updateUser(user);
        return user;
    }

    /**
     * 移除缓存: @CacheEvict注解
     * beforeInvocation: 是否在方法执行前移除缓存, default: false
     * @param id
     * @return
     */
    @Override
    @Transactional
    @CacheEvict(value = "redisCache", key = "'user:' + #id", beforeInvocation = false)
    public int deleteUser(Long id) {
        return userDao.deleteUser(id);
    }
}
