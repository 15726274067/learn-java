package com.zhutao.pojo.vo;

import com.zhutao.pojo.User;
import org.apache.ibatis.type.Alias;

/**
 * @Author: zhutao
 * @Date: 2019/2/12 16:17
 * @Version 1.0
 */
@Alias("userQueryVO")
public class UserQueryVO {
    private User user;

    private int size = 10;

    private int page = 1;

    private int start;

    private int end;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getStart() {
        return size * (page - 1);
    }


    public int getEnd() {
        return page * size;
    }

    public UserQueryVO(User user) {
        this.user = user;
    }

    public UserQueryVO(User user, int size, int page) {
        this.user = user;
        this.size = size;
        this.page = page;
    }
}
