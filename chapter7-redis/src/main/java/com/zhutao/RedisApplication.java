package com.zhutao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = "com.zhutao")
@EnableCaching // 使用缓存管理器
@MapperScan(basePackages = "com.zhutao", annotationClass = Repository.class)
public class RedisApplication
{

    @Autowired
    private RedisTemplate redisTemplate = null;

    // 连接工厂
    @Autowired
    private RedisConnectionFactory redisConnectionFactory = null;

    // 消息监听器
    @Autowired
    private MessageListener redisMessageListener = null;

    // 任务池
    private ThreadPoolTaskScheduler taskScheduler = null;


    /**
     * Spring Boot 的自动装配机制就会读取配置来生成有关 Redis 的操作对象
     * 这里它会自动生成 RedisConnectionFactory、RedisTemplate、StringRedisTemplate
     * @param args
     */
    public static void main( String[] args )
    {
        SpringApplication.run(RedisApplication.class);
    }

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
     * 创建任务池，运行线程等待处理 Redis 的消息
     */
    @Bean
    public ThreadPoolTaskScheduler initTaskScheduler(){
        if (this.taskScheduler != null) return this.taskScheduler;

        this.taskScheduler = new ThreadPoolTaskScheduler();
        this.taskScheduler.setPoolSize(20);
        return this.taskScheduler;
    }

    /**
     * 定义redis监听容器
     *
     * redis client 执行 publish topic message 即可发布消息
     * 或者使用
     */
    @Bean
    public RedisMessageListenerContainer initRedisContainer(){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();

        // 连接工厂
        container.setConnectionFactory(redisConnectionFactory);
        // 任务运行池
        container.setTaskExecutor(initTaskScheduler());

        // 定义topic监听渠道
        Topic topic = new ChannelTopic("test-topic");

        // 添加监听器
        container.addMessageListener(redisMessageListener, topic);
        return container;
    }
}
