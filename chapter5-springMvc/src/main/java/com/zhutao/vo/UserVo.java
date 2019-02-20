package com.zhutao.vo;

/**
 * @Author: zhutao
 * @Date: 2019/2/20 22:09
 * @Version 1.0
 */
public class UserVo {
    private Long id;

    private String userName;

    private String note;

    private String sexName;

    private int sexCode;

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

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public int getSexCode() {
        return sexCode;
    }

    public void setSexCode(int sexCode) {
        this.sexCode = sexCode;
    }
}
