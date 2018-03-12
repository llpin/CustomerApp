package com.common.utils;

import android.content.Context;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by linlipin on 18/1/3.
 */

public class PropUtil {

    private static Properties properties;

    public static Properties getProperties(Context context, int id) {
      return loadRawProperties(context, id);
    }

    /**
     * 读取Raw文件夹的文件
     */
    public static Properties loadRawProperties(Context context, int id) {
        Properties prop = new Properties();
        //first load default properties
        try {
            prop.load(context.getResources().openRawResource(id));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;

    }

    /**
     * 读取assets文件夹下的文件
     */
    public static Properties loadAssetsProperties(Context context, String arg) {
        Properties prop = null;
        prop = new Properties();
        //first load default properties
        try {
            prop.load(context.getAssets().open(arg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;

    }


}
