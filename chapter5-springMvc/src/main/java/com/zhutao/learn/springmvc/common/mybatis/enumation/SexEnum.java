package com.zhutao.learn.springmvc.common.mybatis.enumation;

/**
 * @Author: zhutao
 * @Date: 2019/2/20 22:01
 * @Version 1.0
 */
public enum SexEnum {
    MALE("男", 1),
    FEMALE("女", 2);

    private String name;

    private int id;

    SexEnum(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static SexEnum getEnumById(int id){
        for (SexEnum sexEnum: SexEnum.values()){
            if (sexEnum.id == id)
                return sexEnum;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }}
