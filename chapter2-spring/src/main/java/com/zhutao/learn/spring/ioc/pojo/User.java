package com.zhutao.learn.spring.ioc.pojo;

import java.text.MessageFormat;

/**
 * @Author: zhutao
 * @Date: 2019/1/31 17:00
 * @Version 1.0
 */
public class User {
    private Long id;

    private String name;

    private String note;

    public User() {
    }

    public User(Long id, String name, String note) {
        this.id = id;
        this.name = name;
        this.note = note;
    }
//
//    @Override
//    public String toString(){
//        return MessageFormat.format("id: {0}, name: {1}, note: {2}", id, name, note);
//    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
