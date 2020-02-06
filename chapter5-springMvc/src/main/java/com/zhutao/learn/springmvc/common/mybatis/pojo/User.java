package com.zhutao.learn.springmvc.common.mybatis.pojo;

import com.zhutao.learn.springmvc.common.mybatis.enumation.SexEnum;

/**
 * @Author: zhutao
 * @Date: 2019/2/20 22:01
 * @Version 1.0
 */
public class User {
    private Long id;

    private String userName;

    private String note;

    private SexEnum sex = null;

    public User(Long id, String userName, String note, SexEnum sex) {
        this.id = id;
        this.userName = userName;
        this.note = note;
        this.sex = sex;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }
}
