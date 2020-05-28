package cn.chenqiangjun.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Account implements Serializable {

    private String username;
    private String password;
    // 实体类中有引用实体类
    // private User user;
    private List<User> list;
    private Map<String,User> map;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
