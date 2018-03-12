package com.common.runnables;

import android.app.Activity;
import android.content.Intent;

import com.common.utils.ActivityUtil;

/**
 * Created by linlipin on 18/3/3.
 */

public class ResponseActivity implements Runnable {
    Activity activity;
    Intent intent;

    public ResponseActivity(Activity activity, Intent intent) {
        this.activity = activity;
        this.intent = intent;
    }

    @Override
    public void run() {
        try {
            ActivityUtil.startActivitySimple(activity, intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
