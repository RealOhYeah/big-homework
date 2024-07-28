package com.gsxy.filesystemserver.domain.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * 2024-03-06 zhuxinyu
 * 用户注册
 */
public class UserRegBo implements Serializable {
    private String username;//账号
    private String password;//密码
    private String name;//姓名
    private String org;//部门
    private Long createBy;//创建人
    private Date createTime;//创建时间

    public UserRegBo(String username, String password, String name, String org, Long createBy, Date createTime) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.org = org;
        this.createBy = createBy;
        this.createTime = createTime;
    }

    public UserRegBo() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserRegBo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", org='" + org + '\'' +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                '}';
    }
}
