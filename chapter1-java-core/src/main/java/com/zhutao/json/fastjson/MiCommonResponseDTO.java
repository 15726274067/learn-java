package com.zhutao.json.fastjson;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zhutao
 * @Date: 2019-06-27 11:23
 * @Version 1.0
 */
@Data
public class MiCommonResponseDTO<T> implements Serializable {
    private ResponseHead header;

    private T body;

    @Data
    protected static class ResponseHead {
        private int code;
        private String desc;
    }
}

