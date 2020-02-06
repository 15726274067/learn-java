package com.zhutao.learn.mq.pojo;

/**
 * @Author: zhutao
 * @Date: 2019/2/26 15:29
 * @Version 1.0
 */
public class User {
    private String userName;

    private int age;

    private String note;

    public User(String userName, int age, String note) {
        this.userName = userName;
        this.age = age;
        this.note = note;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", note='" + note + '\'' +
                '}';
    }
}
