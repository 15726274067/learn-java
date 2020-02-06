package com.zhutao.learn.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: zhutao
 * @Date: 2019/2/14 11:00
 * @Version 1.0
 */
@Configuration
public class RedisConfig {

    private RedisConnectionFactory redisConnectionFactory = null;

    /**
     * 创建RedisConnectionFactory对象
     * 使用redis连接时,需要先从工厂获取,使用结束后释放
     * @return
     */
    @Bean("RedisConnectionFactory")
    public RedisConnectionFactory initRedisConnectionFactory(){
        if (this.redisConnectionFactory != null) return redisConnectionFactory;

        JedisPoolConfig poolConfig = new JedisPoolConfig();

        // 最大空闲数
        poolConfig.setMaxIdle(30);

        poolConfig.setMaxTotal(50);

        poolConfig.setMaxWaitMillis(2000);

        // 创建jedis链接工厂
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory(poolConfig);

        connectionFactory.setHostName("127.0.0.1");
        connectionFactory.setPort(6379);
        this.redisConnectionFactory = connectionFactory;
        return connectionFactory;
    }


    /**
     * RedisTemplate
     * 会自动从 RedisConnectionFactory 工厂中获取连接,然后执行对应的 Redis命令
     * 在最后还会关闭 Redis 的连接,所以并不需要开发者关注Redis 连接的闭合问题
     */
    @Bean("redisTemplate")
    public RedisTemplate<Object, Object> initRedisTemplate(){
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(initRedisConnectionFactory());
        return redisTemplate;
    }
}
