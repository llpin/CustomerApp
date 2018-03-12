package com.common.utils;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

/**
 * Created by linlipin on 18/3/4.
 */

public class FileUtil{

    public static File fromUri(Uri uri, AppCompatActivity activity){
        File file = null;
        try {
            String path = getPathFromUri(uri, activity);
            file = new File(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return file;
    }

//    从相册
    public static void fromGallery(AppCompatActivity activity, int requestCode){
        // 激活系统图库，选择一张图片
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_GALLERY
        activity.startActivityForResult(intent, requestCode);
    }

    public static String getPathFromUri(Uri uri, AppCompatActivity activity)
    {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = activity.getContentResolver().query(uri, projection, null, null, null);
        if (cursor == null) return null;
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String s=cursor.getString(column_index);
        cursor.close();
        return s;
    }
}
