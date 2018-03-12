package com.common.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by linlipin on 17/7/3.
 */

public class ToastUtil {
    public static boolean enable = true;

    public static boolean isEnable() {
        return enable;
    }

    public static void setEnable(boolean enable) {
        ToastUtil.enable = enable;
    }

    public static void  showShort(Context ct, String str){
        if (isEnable())
            Toast.makeText(ct, str, Toast.LENGTH_SHORT).show();
    }

    public static void  showLong(Context ct, String str){
        if (isEnable())
            Toast.makeText(ct, str, Toast.LENGTH_LONG).show();
    }

}
