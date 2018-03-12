package com.common.base;

import android.support.v7.app.AppCompatActivity;

import com.common.application.UserApplication;
import com.common.base.enums.AppModel;
import com.common.utils.PropUtil;
import com.common.utils.ToastUtil;
import com.activity.R;

import java.util.Properties;

/**
 * Created by linlipin on 18/1/3.
 */

public class BaseActivity extends AppCompatActivity {


    private final static String APP_MODEL = "appModel";
    private final static String API_BASE_URL = "apiBaseUrl";

    private Properties properties = null;

    public Properties getProperties() {
        if(properties == null){
            setProperties(PropUtil.getProperties(this, R.raw.app));
        }
        return properties;
    }

    private void setProperties(Properties properties) {
        this.properties = properties;
    }

    private String getProperty(String key, String def){
        return getProperties().getProperty(key,def);
    }

    private String getProperty(String key){
        return getProperties().getProperty(key);
    }

    public String getAppModel() {
        return getProperty(APP_MODEL, AppModel.test.name());
    }

    public boolean isTestModel(){
        return getAppModel().compareToIgnoreCase(AppModel.test.name()) == 0;
    }

    public boolean isDevModel(){
        return getAppModel().compareToIgnoreCase(AppModel.dev.name()) == 0;
    }

    public boolean isProModel(){
        return getAppModel().compareToIgnoreCase(AppModel.pro.name()) == 0;
    }

    public String getApiBaseUrl() {
        return getProperty(API_BASE_URL);
    }

    public void showToastShort(String msg){
        ToastUtil.showShort(this, msg);
    }

    public void showToastLong(String msg){
        ToastUtil.showLong(this, msg);
    }

    public UserApplication getUserApplication(){
        return (UserApplication) getApplication();
    }
}
