package com.common.handler;

import android.content.Context;

import com.common.utils.L;

import java.text.SimpleDateFormat;

/**
 * Created by linlipin on 18/3/5.
 */

public class CrashHandler implements
        Thread.UncaughtExceptionHandler{

    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private static CrashHandler mInstance;
    private Context mContext;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    private String TAG = this.getClass().getSimpleName();


    private CrashHandler(){
        // Empty Constractor
    }



    public static synchronized CrashHandler getInstance(){
        if(null == mInstance){
            mInstance = new CrashHandler();
        }
        return mInstance;
    }

    /* 初始化 */
    public void init(Context context){
        this.mContext = context;
        Thread.setDefaultUncaughtExceptionHandler(this);
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
    }

    @Override
    public void uncaughtException(Thread thread, final Throwable ex) {
        L.d(TAG,ex.getMessage());
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                Looper.prepare();
//
//                ToastUtil.showShort(mContext,"程序发生了点小意外，即将关闭... "+
//                        ex.getMessage());
//                Looper.loop();
//
//                L.d(TAG, ex.getMessage());
//
//                SystemClock.sleep(3000);
//
//                // 将Activity的栈清空
//                AppManager.removeAll();
//                // 退出程序
//                Process.killProcess(Process.myPid());
//                // 关闭虚拟机，彻底释放内存空间
//                System.exit(0);
//
//            }
//        }).start();
    }
}