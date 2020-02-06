package com.zhutao.learn.redis.main;

import com.zhutao.learn.redis.config.RedisConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @Author: zhutao
 * @Date: 2019/2/14 11:57
 * @Version 1.0
 */
public class RedisTemplateMain {
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(RedisConfig.class);

        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);

        /**
         * 127.0.0.1:6379> keys *key1
         * 1) "\xac\xed\x00\x05t\x00\x04key1"
         * 可以看到,redis中存入的key不是"key1"
         * 原因:
         * Redis是一种基于字符串存储的 NoSQL,而 Java 是基于对象的语言，对象是无法存储到 Redis 中
         * 不过 Java提供了序列化机制, 只要类实现了 java.io.Serializable 接口, 代表类的对象能够进行序列化,
         * 通过将类对象进行序列化就能够得到二进制字符串，这样 Redis 就可以将这些类对象以字符串进行存储
         * Java 也可以将那些二进制字符串通过反序列化转为对象
         *
         *
         * 通过这个原理, Spring 提供了序列化器的机制, 并且实现了几个序列化器
         * 1. defaultSerializer: 默认序列化器, 默认是JdkSerializationRedisSerializer
         * 2. keySerializer: redis键序列化器
         * 3. valueSerializer: 值序列化器
         * 4. hashKeySerializer: hash field 序列化器
         * 5. hashValueSerializer: hash value 序列化器
         * 6. stringSerializer: 字符串序列化器
         */

        // redisTemplate 会自动初始化StringSerializer
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();

        // 设置字符串序列化器, 这里为string, hash的key/value都设置了
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);

        redisTemplate.opsForValue().set("key1", "val1");

        redisTemplate.opsForHash().put("hash1", "field", "val1");

        String value = (String) redisTemplate.opsForValue().get("key1");
        System.out.println(value);


        /**
         * bound: 绑定一个xx类型的键操作,会在一个连接内执行
         */
        Object str = redisTemplate.boundValueOps("key1").get();
        System.out.println(str);
    }

    // 高级接口, 优先使用, 会在一个连接中执行
    public void userSessionCallBack(RedisTemplate redisTemplate){
        redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.opsForValue().set("key1", "value1");
                redisOperations.opsForValue().set("key2", "value2");
                return null;
            }
        });
    }
}
