package com.common.interfaces;


import android.app.Activity;
import android.content.Intent;

/**
 * Created by linlipin on 18/1/3.
 */
public interface ZxingInter {
    void startCaptureActivityWithContractId(Activity activity, Long contractId);
    void startCaptureActivityWithUserId(Activity activity, Long userId);
    void startCaptureActivityWithContractIdRunnable(Activity activity, Long contractId);
}
