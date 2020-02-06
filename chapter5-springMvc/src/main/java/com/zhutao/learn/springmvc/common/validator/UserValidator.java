package com.zhutao.learn.springmvc.common.validator;


import com.zhutao.learn.springmvc.common.mybatis.pojo.User;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * supports方法参数为需要验证的POJO 类型, 如果该方法返回 true,则 Spring 会使用当前验证器的 validation 方法去验证 POJO
 * 而validation 方法包含需要的 target 对象(参数绑定后 POJO)和错误对象errors
 * @Author: zhutao
 * @Date: 2019/2/20 23:02
 * @Version 1.0
 */
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (target == null){
            // 直接在参数处报错,不会进入控制器
            errors.rejectValue("", "501", "用户不能为空");
            return;
        }

        User user = (User) target;

        if (StringUtils.isEmpty(user.getUserName())){
            errors.rejectValue("", "502", "用户姓名不能为空");
        }


    }
}
