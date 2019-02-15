package com.zhutao.dao;

import com.zhutao.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zhutao
 * @Date: 2019/2/14 23:18
 * @Version 1.0
 */
@Repository
public interface UserDao {
    User getUser(Long id);

    List<User> findUsers(@Param("userName") String userName,
                         @Param("note") String note);
    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(Long id);
}
