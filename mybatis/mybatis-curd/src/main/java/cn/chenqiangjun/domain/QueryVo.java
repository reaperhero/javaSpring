package cn.chenqiangjun.domain;

import java.io.Serializable;

public class QueryVo implements Serializable {
    private User user;
    // 如果还有其他的查询条件，就可以一并封装进来

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

