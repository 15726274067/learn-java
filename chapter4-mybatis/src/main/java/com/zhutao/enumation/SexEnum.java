package com.zhutao.enumation;

/**
 * @Author: zhutao
 * @Date: 2019/2/12 10:51
 * @Version 1.0
 */
public enum SexEnum {
    MALE(1, "男"),
    FEMALE(2, "女");

    private int id;

    private String name;

    SexEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static SexEnum getSexById(int id){
        for (SexEnum sexEnum: SexEnum.values()){
            if (sexEnum.id == id)
                return sexEnum;
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }}
