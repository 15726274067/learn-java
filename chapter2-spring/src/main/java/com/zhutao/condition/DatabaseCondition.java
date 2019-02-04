package com.zhutao.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: zhutao
 * @Date: 2019/2/4 15:10
 * @Version 1.0
 */
public class DatabaseCondition implements Condition {
    /**
     * 数据库DataSource装配条件
     * @param conditionContext 条件上下文
     * @param annotatedTypeMetadata 注释类型的元数据
     * @return true:装配bean false:不装配
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        System.out.println("invoke matches in " + this.getClass().getName());
        return environment.containsProperty("database.driverName") &&
                environment.containsProperty("url") &&
                environment.containsProperty("username") &&
                environment.containsProperty("password");
    }
}
