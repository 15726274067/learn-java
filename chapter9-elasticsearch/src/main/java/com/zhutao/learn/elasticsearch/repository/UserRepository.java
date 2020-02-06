package com.zhutao.learn.elasticsearch.repository;

import com.zhutao.learn.elasticsearch.pojo.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @Author: zhutao
 * @Date: 2019/2/26 22:01
 * @Version 1.0
 */
@Component
public interface UserRepository extends ElasticsearchRepository<User, Long> {

}
