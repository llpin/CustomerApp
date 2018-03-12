package com.common.utils;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by linlipin on 17/7/3.
 */

public class ActivityUtil {
    public static void startActivitySimple(Activity act, Class<?> cls){
        Intent intent = new Intent(act, cls);
        act.startActivity(intent);
    }

    public static void startActivitySimple(Activity act, Intent intent){
        act.startActivity(intent);
    }
}
