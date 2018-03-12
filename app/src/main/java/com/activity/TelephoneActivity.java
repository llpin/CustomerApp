package com.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;

import com.common.base.BaseActivity;
import com.common.interfaces.BaseInter;
import com.common.pojo.BaseResultResponse;
import com.common.pojo.IndividualEntityRequest;
import com.common.pojo.IndividualRegisterResponse;
import com.common.pojo.ResultResponseModel;
import com.common.pojo.SmsVerifyResponse;
import com.common.runnables.MessageToast;
import com.common.runnables.ResponseActivity;
import com.common.utils.GsonUtil;
import com.common.utils.HttpApiUtil;
import com.common.utils.L;
import com.common.utils.OkHttpUtil;
import com.common.utils.ToastUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class TelephoneActivity extends BaseActivity implements BaseInter, View.OnClickListener {
    private final static String TAG = "TelephoneActivity";
    TextInputEditText mTelephone;
    TextInputEditText mVerifyCode;

    private IndividualEntityRequest mIndividualRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephone);

        mIndividualRequest =
                (IndividualEntityRequest) getIntent().getSerializableExtra(
                        getResources().getString(R.string.individual_extra)
                );

        initForm();
    }

    @Override
    public void initForm() {
        mTelephone = (TextInputEditText)findViewById(R.id.telephone);
        mVerifyCode = (TextInputEditText)findViewById(R.id.verifyCode);
        ((Button)findViewById(R.id.verifyButton)).setOnClickListener(this);
        ((Button)findViewById(R.id.submitButton)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.verifyButton:{
                String telephone = mTelephone.getText().toString();
                HttpApiUtil.getVerifyCode(telephone, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        L.d(TAG, response.body().toString());
                        SmsVerifyResponse smsResponse =
                                GsonUtil.fromResponse(response, SmsVerifyResponse.class);

                        try{
                            if (smsResponse.getCode().compareTo("200") == 0){
                                runOnUiThread(new MessageToast(TelephoneActivity.this, smsResponse.getMessage()));
                            }else {
                                runOnUiThread(new MessageToast(TelephoneActivity.this,
                                        smsResponse.getMessage() + ":" + smsResponse.getErrMsg()));
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
            }
                break;
            case R.id.submitButton: {
                final String telephone = mTelephone.getText().toString();
                final String verifyCode = mVerifyCode.getText().toString();
//                验证二维码
//                HttpApiUtil.verifyCode(telephone, verifyCode, new Callback() {
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//                        e.printStackTrace();
//                    }
//
//                    @Override
//                    public void onResponse(Call call, Response response) throws IOException {
//                        L.d(TAG, response.body().string());
//                        ResultResponseModel resultResponse =
//                                GsonUtil.fromResponse(response, ResultResponseModel.class);
//                        try{
//                            if(resultResponse.getCode().compareTo("200") != 0){
//                                runOnUiThread(new MessageToast(TelephoneActivity.this,
//                                        resultResponse.getMessage()));
//                                L.d(TAG, resultResponse.getMessage());
//                            }else {
//                                mIndividualRequest.setTelephone(telephone);
//                                HttpApiUtil.register(mIndividualRequest, new Callback() {
//                                    @Override
//                                    public void onFailure(Call call, IOException e) {
//                                        e.printStackTrace();
//                                    }
//
//                                    @Override
//                                    public void onResponse(Call call, Response response) throws IOException {
//                                        IndividualRegisterResponse registerResponse =
//                                                GsonUtil.fromResponse(response, IndividualRegisterResponse.class);
//                                        try{
//                                            runOnUiThread(new MessageToast(TelephoneActivity.this,
//                                                    registerResponse.getMessage()));
//                                            if(registerResponse.getCode().compareTo("200") == 0){
////                                        跳转登录页
//                                                runOnUiThread(new ResponseActivity(TelephoneActivity.this,
//                                                        new Intent(TelephoneActivity.this, LoginActivity.class)));
//                                            }
//                                        }catch (Exception e){
//                                            e.printStackTrace();
//                                        }
//                                    }
//                                });
//                            }
//
//                        }catch (Exception e){
//                            e.printStackTrace();
//                        }
//                    }
//                });
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Response response = HttpApiUtil.verifyCode(telephone, verifyCode);
                            ResultResponseModel resultResponse =
                                    GsonUtil.fromResponse(response, ResultResponseModel.class);

                            if (resultResponse.getCode().compareTo("200") != 0) {
                                runOnUiThread(new MessageToast(TelephoneActivity.this,
                                        resultResponse.getMessage()));
                            } else {
//                                注册
                                mIndividualRequest.setTelephone(telephone);

                                Response registerResponse = HttpApiUtil.register(mIndividualRequest);
                                IndividualRegisterResponse individualRegisterResponse =
                                        GsonUtil.fromResponse(registerResponse, IndividualRegisterResponse.class);

                                runOnUiThread(new MessageToast(TelephoneActivity.this,
                                        individualRegisterResponse.getMessage()));
                                if (individualRegisterResponse.getCode().compareTo("200") == 0) {
                                    // 跳转登录页
                                    runOnUiThread(new ResponseActivity(TelephoneActivity.this,
                                            new Intent(TelephoneActivity.this, LoginActivity.class)));
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();


            }
                break;
            default:
                break;
        }
    }
}
