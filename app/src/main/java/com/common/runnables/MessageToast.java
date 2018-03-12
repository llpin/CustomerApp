package com.common.runnables;

import android.content.Context;

import com.common.utils.ToastUtil;

/**
 * Created by linlipin on 18/3/5.
 */

public class MessageToast implements Runnable {
    private String message;
    private Context ct;

    public MessageToast(Context ct, String message) {
        this.ct = ct;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        ToastUtil.showShort(ct, this.getMessage());
    }
}
