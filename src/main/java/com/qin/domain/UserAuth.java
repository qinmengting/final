package com.qin.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter@Getter@ToString
public class UserAuth {
    private Integer id;

    private String username;

    private String password;

    private boolean isAdmin;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createdTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    //不加注解则返回的json字段中为admin，或者改变get方法，如下所示
    @JsonProperty(value = "isAdmin")
    public boolean isAdmin() {
        return isAdmin;
    }

    @JsonProperty(value = "isAdmin")
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public UserAuth(Integer id, String username, String password, boolean isAdmin, Date createdTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.createdTime = createdTime;
    }


    public UserAuth() {
    }

    @Override
    public String toString() {
        return "UserAuth{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", createdTime=" + createdTime +
                '}';
    }
}