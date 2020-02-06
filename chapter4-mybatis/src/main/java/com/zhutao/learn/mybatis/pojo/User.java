package com.zhutao.learn.mybatis.pojo;

import com.zhutao.learn.mybatis.common.enumation.SexEnum;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @Author: zhutao
 * @Date: 2019/2/12 10:47
 * @Version 1.0
 */
@Alias("user")
public class User implements Serializable {

    private Long id = null;

    private String userName = null;

    private String note = null;

    private SexEnum sex = null;

    public User() {
    }

    public User(Long id, String userName, String note, SexEnum sex) {
        this.id = id;
        this.userName = userName;
        this.note = note;
        this.sex = sex;
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
