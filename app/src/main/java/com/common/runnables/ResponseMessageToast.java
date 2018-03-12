package com.common.runnables;

import android.content.Context;

import com.common.pojo.BaseResultResponse;
import com.common.pojo.ResultResponseModel;
import com.common.utils.ToastUtil;

/**
 * Created by linlipin on 18/3/1.
 */

public class ResponseMessageToast implements Runnable {
    private ResultResponseModel resultResponse;
    private Context ct;

    public ResponseMessageToast(ResultResponseModel resultResponse, Context ct) {
        this.resultResponse = resultResponse;
        this.ct = ct;
    }

    @Override
    public void run() {
        ToastUtil.showLong(ct, resultResponse.getMessage());
    }
}
