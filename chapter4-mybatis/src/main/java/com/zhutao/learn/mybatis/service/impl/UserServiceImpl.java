package com.zhutao.learn.mybatis.service.impl;

import com.zhutao.learn.mybatis.dao.MyBatisUserDao;
import com.zhutao.learn.mybatis.pojo.User;
import com.zhutao.learn.mybatis.pojo.vo.UserQueryVO;
import com.zhutao.learn.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * @Transactional 注解表示启动事务机制
     * 将方法织入约定流程中
     * 可以放在接口跟实现类上, 推荐放在实现类上..
     *
     * - value: 配置事务管理器(同transactionManager),一般会自动配置
     * - timeout: 事务允许存在的时间戳,单位为秒
     * - readOnly: 只读事务
     * - rollbackFor:
     * - rollbackForClassName
     * - noRollbackFor
     * - noRollbackForClassName
     * - isolation: 隔离级别
     * - propagation: 传播行为(下面详解)
     * @param id
     * @return
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
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

    /**
     * @Transactional 自调用失效问题及其解决方式
     * spring 通过aop实现事务管理,aop的原理是动态代理
     * 自调用过程中,是类自身的调用,不是代理对象去调用,那么spring不会把方法织入约定流程中
     *
     * 解决方式:
     * 调用另外的service
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int insertUsers(List<User> users){
        int count = 0;

        for (User user: users){
            count += insertUser(user);
        }

        return count;
    }
}
