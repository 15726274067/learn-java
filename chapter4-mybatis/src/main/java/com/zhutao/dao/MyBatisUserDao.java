package com.zhutao.dao;

import com.zhutao.pojo.User;
import com.zhutao.pojo.vo.UserQueryVO;
import org.springframework.stereotype.Repository;
import sun.rmi.runtime.Log;

import java.util.List;

/**
 * @Author: zhutao
 * @Date: 2019/2/12 11:22
 * @Version 1.0
 */
@Repository
public interface MyBatisUserDao {
    User getUser(Long id);

    User getUser2(Long id);

    List<User> getUserByName(String name);

    List<User> getListByQuery(UserQueryVO userQueryVO);

    List<User> getListById(List<Long> list);

    int insertUser(User user);

    int insertBatch(List<User> users);

    int updateUser(User user);

    int removeUser(Long id);

}
