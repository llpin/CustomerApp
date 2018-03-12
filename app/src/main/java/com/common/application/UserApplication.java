package com.common.application;

import android.app.Application;

import com.common.handler.CrashHandler;
import com.common.pojo.UserVoResponse;

/**
 * Created by linlipin on 18/3/2.
 */

public class UserApplication extends Application {
    private UserVoResponse userVo;

    @Override
    public void onCreate(){
        super.onCreate();
        CrashHandler.getInstance().init(this);
    }
    public UserVoResponse getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVoResponse userVo) {
        this.userVo = userVo;
    }

}
