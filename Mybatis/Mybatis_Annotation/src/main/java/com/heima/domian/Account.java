package com.heima.domian;

import java.io.Serializable;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Account.java
 * @Description TODO
 * @createTime 2020年01月11日 08:53:00
 */
public class Account implements Serializable {
    private Integer ID;
    private Integer UID;
    private Integer MONEY;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getUID() {
        return UID;
    }

    public void setUID(Integer UID) {
        this.UID = UID;
    }

    public Integer getMONEY() {
        return MONEY;
    }

    public void setMONEY(Integer MONEY) {
        this.MONEY = MONEY;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID=" + ID +
                ", UID=" + UID +
                ", MONEY=" + MONEY +
                ", user=" + user +
                '}';
    }
}
