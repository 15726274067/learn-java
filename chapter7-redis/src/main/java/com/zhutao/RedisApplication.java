package com.zhutao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import javax.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = "com.zhutao")
public class RedisApplication
{

    @Autowired
    private RedisTemplate redisTemplate = null;

    // 自定义的后初始化方法
    @PostConstruct
    public void init(){
        initRedisTemplate();
    }

    /**
     * 将RedisTemplate中的序列化器改为stringSerializer
     */
    private void initRedisTemplate() {
        RedisSerializer serializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(serializer);
        redisTemplate.setValueSerializer(serializer);
        redisTemplate.setHashKeySerializer(serializer);
        redisTemplate.setHashValueSerializer(serializer);
        redisTemplate.setStringSerializer(serializer);
    }

    /**
     * Spring Boot 的自动装配机制就会读取配置来生成有关 Redis 的操作对象
     * 这里它会自动生成 RedisConnectionFactory、RedisTemplate、StringRedisTemplate
     * @param args
     */
    public static void main( String[] args )
    {
        SpringApplication.run(RedisApplication.class);
    }
}
