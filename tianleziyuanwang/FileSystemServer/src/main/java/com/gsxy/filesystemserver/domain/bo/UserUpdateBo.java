package com.gsxy.filesystemserver.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 2024-03-09
 * 修改用户信息
 */
public class UserUpdateBo implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String org;
    private Long updateBy;//修改人
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;//修改时间

    public UserUpdateBo(Long id, String username, String password, String name, String org, Long updateBy, Date updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.org = org;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

    public UserUpdateBo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserUpdateBo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", org='" + org + '\'' +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                '}';
    }
}
