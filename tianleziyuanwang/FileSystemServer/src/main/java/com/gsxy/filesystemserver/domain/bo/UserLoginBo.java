package com.gsxy.filesystemserver.domain.bo;

import java.io.Serializable;

/**
 * 2024-3-6
 * 用户登录实体类
 */
public class UserLoginBo implements Serializable {
    private String username;//账号
    private String password;//密码

    public UserLoginBo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserLoginBo() {
    }

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

    @Override
    public String toString() {
        return "UserLoginBo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
