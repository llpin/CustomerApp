package com.common.pojo;

import com.common.base.enums.PlatformMainTypeEnum;

import java.io.Serializable;

/**
 * Created by linlipin on 18/3/2.
 */

public class UserEntityRequest implements Serializable {
    private static final long serialVersionUID=1000L;
    private String username;
    private String password;
    private String doPassword;

    private PlatformMainTypeEnum platformMainTypeEnum;

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

    public String getDoPassword() {
        return doPassword;
    }

    public void setDoPassword(String doPassword) {
        this.doPassword = doPassword;
    }

    public PlatformMainTypeEnum getPlatformMainTypeEnum() {
        return platformMainTypeEnum;
    }

    public void setPlatformMainTypeEnum(PlatformMainTypeEnum platformMainTypeEnum) {
        this.platformMainTypeEnum = platformMainTypeEnum;
    }
}


