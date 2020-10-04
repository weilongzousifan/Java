package com.heima.domain;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName QueryVo.java
 * @Description TODO
 * @createTime 2020年01月09日 20:21:00
 */
public class QueryVo {
    private User user;
    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "user=" + user +
                ", ids=" + ids +
                '}';
    }
}
