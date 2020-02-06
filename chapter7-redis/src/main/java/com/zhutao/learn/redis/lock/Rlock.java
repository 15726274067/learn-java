package com.zhutao.learn.redis.lock;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhutao
 * @Date: 2019-08-26 18:43
 * @Version 1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Rlock {

    /**
     * 分布式锁的key
     */
    String localKey();

    /**
     * 锁释放时间 默认五秒
     *
     * @return
     */
    long leaseTime() default 5*1000;

    /**
     * 时间格式 默认：毫秒
     *
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;
}
