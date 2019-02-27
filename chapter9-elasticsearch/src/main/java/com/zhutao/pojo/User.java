package com.zhutao.pojo;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * 使用@Document,这个类同步到ElasticSearch中
 *
 * indexName索引名称 可以理解为数据库名 必须为小写 不然会报org.elasticsearch.indices.InvalidIndexNameException异常
 * type类型 可以理解为表名
 * @Author: zhutao
 * @Date: 2019/2/26 21:56
 * @Version 1.0
 */
@Document(indexName = "test", type = "user")
public class User implements Serializable {
    private long id;

    private String userName;

    private String note;

    public User() {
    }

    public User(long id, String userName, String note) {
        this.id = id;
        this.userName = userName;
        this.note = note;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
