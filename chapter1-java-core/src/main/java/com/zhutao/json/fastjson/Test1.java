package com.zhutao.json.fastjson;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.zhutao.App;

import java.util.List;

/**
 * @Author: zhutao
 * @Date: 2019-06-27 11:22
 * @Version 1.0
 */
public class Test1<T> {

    public static void main(String[] args) {
    }

    public MiCommonResponseDTO<T> getResponse() {
        String response = "";

        JSONObject.parseObject(response, new TypeReference<MiCommonResponseDTO<T>>() {});
        return null;
    }
}
