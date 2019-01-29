package com.zhutao.extend;

/**
 * 枚举中使用构造函数,方法和域
 * @Author: zhutao
 * @Date: 2019/1/29 17:21
 * @Version 1.0
 */
public enum Size{
    SMALL("S"),
    MEDIUM("M"),
    LARGE("L");

    private String desc;

    Size(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public int Order(){
        return this.ordinal();
    }
}