package com.heima.domian;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName User.java
 * @Description TODO
 * @createTime 2020年01月06日 20:55:00
 */
public class User implements Serializable {
    private  Integer  user_id;
    private  String user_username;
    private Date   user_birthday;
    private Character user_sex;
    private  String user_address;

//  配置一对多
    private List<Account> accounts;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public Date getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(Date user_birthday) {
        this.user_birthday = user_birthday;
    }

    public Character getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(Character user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_username='" + user_username + '\'' +
                ", user_birthday=" + user_birthday +
                ", user_sex=" + user_sex +
                ", user_address='" + user_address + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
