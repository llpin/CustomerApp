package com.common.pojo;

/**
 * Created by linlipin on 18/3/1.
 */

public class LoginResponse extends ResultResponseModel {
    private UserVoResponse userVo;

    public UserVoResponse getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVoResponse userVo) {
        this.userVo = userVo;
    }
}
