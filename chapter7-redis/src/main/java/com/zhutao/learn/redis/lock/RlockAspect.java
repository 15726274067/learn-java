package com.zhutao.learn.redis.lock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: zhutao
 * @Date: 2019-08-26 18:42
 * @Version 1.0
 */
@Aspect
@Component
public class RlockAspect {

    private final static Logger logger = LoggerFactory.getLogger(RlockAspect.class);

    @Autowired
    private RedissonClient redissonClient;

    @Pointcut("@annotation(com.zhutao.learn.redis.lock.Rlock)")
    public void RlockAspect() {
    }

    @Around("RlockAspect()")
    public Object arround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object object = null;
        RLock lock = null;

        logger.info("rlockAspect start ");

        try {
            Rlock rlockInfo = getRlockInfo(proceedingJoinPoint);
            lock = redissonClient.getLock(getLocalKey(proceedingJoinPoint, rlockInfo));

            if (lock != null) {
                final boolean status = lock.tryLock(rlockInfo.leaseTime(), rlockInfo.timeUnit());
                if (status) {
                    object = proceedingJoinPoint.proceed();
                }
            }
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
        return object;
    }

    public Rlock getRlockInfo(ProceedingJoinPoint proceedingJoinPoint) {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        return methodSignature.getMethod().getAnnotation(Rlock.class);
    }

    /**
     * redis lock key 生成逻辑  这里只是简单生成，如需投入生产使用，可考虑复杂化
     *
     * @param proceedingJoinPoint
     * @return
     */
    public String getLocalKey(ProceedingJoinPoint proceedingJoinPoint, Rlock rlockInfo) {
        StringBuilder localKey = new StringBuilder("Rlock");
        final Object[] args = proceedingJoinPoint.getArgs();

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getMethod().getName();
        localKey.append(rlockInfo.localKey()).append(methodName);

        return localKey.toString();
    }
}
