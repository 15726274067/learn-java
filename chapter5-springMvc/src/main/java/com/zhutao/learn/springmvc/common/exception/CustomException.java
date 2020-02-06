package com.zhutao.learn.springmvc.common.exception;

/**
 * @Author: zhutao
 * @Date: 2019/2/21 15:08
 * @Version 1.0
 */
public class CustomException extends RuntimeException {
    private Long code;

    private String message;

    public CustomException(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
