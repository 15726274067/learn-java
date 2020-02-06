package com.zhutao.learn.redis;

import io.netty.channel.nio.NioEventLoopGroup;
import org.mybatis.spring.annotation.MapperScan;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
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

@SpringBootApplication(scanBasePackages = "com.zhutao.learn.redis")
@EnableCaching // 使用缓存管理器
@MapperScan(basePackages = "com.zhutao.learn.redis", annotationClass = Repository.class)
public class RedisApplication
{
    private String address="redis://localhost:6379";
    private int connectionMinimumIdleSize = 10;
    private int idleConnectionTimeout=10000;
    private int pingTimeout=1000;
    private int connectTimeout=10000;
    private int timeout=3000;
    private int retryAttempts=3;
    private int retryInterval=1500;
    private int reconnectionTimeout=3000;
    private int failedAttempts=3;
    private String password = null;
    private int subscriptionsPerConnection=5;
    private String clientName=null;
    private int subscriptionConnectionMinimumIdleSize = 1;
    private int subscriptionConnectionPoolSize = 50;
    private int connectionPoolSize = 64;
    private int database = 0;
    private boolean dnsMonitoring = false;
    private int dnsMonitoringInterval = 5000;

    private int thread; //当前处理核数量 * 2

    private String codec="org.redisson.codec.JsonJacksonCodec";

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

    /**
     * 整合redission
     * @return
     * @throws Exception
     */
    @Bean(destroyMethod = "shutdown")
    RedissonClient redisson() throws Exception {
        Config config = new Config();
        config.useSingleServer().setAddress(address)
                .setConnectionMinimumIdleSize(connectionMinimumIdleSize)
                .setConnectionPoolSize(connectionPoolSize)
                .setDatabase(database)
                .setDnsMonitoring(dnsMonitoring)
                .setDnsMonitoringInterval(dnsMonitoringInterval)
                .setSubscriptionConnectionMinimumIdleSize(subscriptionConnectionMinimumIdleSize)
                .setSubscriptionConnectionPoolSize(subscriptionConnectionPoolSize)
                .setSubscriptionsPerConnection(subscriptionsPerConnection)
                .setClientName(clientName)
                .setFailedAttempts(failedAttempts)
                .setRetryAttempts(retryAttempts)
                .setRetryInterval(retryInterval)
                .setReconnectionTimeout(reconnectionTimeout)
                .setTimeout(timeout)
                .setConnectTimeout(connectTimeout)
                .setIdleConnectionTimeout(idleConnectionTimeout)
                .setPingTimeout(pingTimeout)
                .setPassword(password);
        config.setThreads(thread);
        config.setEventLoopGroup(new NioEventLoopGroup());
        config.setUseLinuxNativeEpoll(false);
        return Redisson.create(config);
    }
}
