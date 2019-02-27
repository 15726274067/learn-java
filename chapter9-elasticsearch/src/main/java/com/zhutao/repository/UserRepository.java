package com.zhutao.repository;

import com.zhutao.pojo.User;
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
