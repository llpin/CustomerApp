package com.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.common.base.BaseActivity;
import com.common.base.enums.IndividualTypeEnum;
import com.common.base.enums.PlatformMainTypeEnum;
import com.common.interfaces.BaseInter;
import com.common.pojo.IndividualEntityRequest;
import com.common.pojo.UserEntityRequest;
import com.common.utils.L;
import com.common.utils.OkHttpUtil;

public class RegisterActivity extends BaseActivity implements BaseInter,View.OnClickListener {
    private TextInputEditText mUserNameInput;
    private TextInputEditText mPasswordInput;
    private TextInputEditText mDoPasswordInput;
    private TextView nextTextView;

    final static String TAG = "RegisterActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initForm();

        String url = getApiBaseUrl();
        if(url !=null){
            L.d(TAG,url);
            OkHttpUtil.setBaseUrl(getApiBaseUrl());
        }
    }


    @Override
    public void initForm() {
        mUserNameInput = (TextInputEditText) findViewById(R.id.username);
        mPasswordInput = (TextInputEditText) findViewById(R.id.password);
        mDoPasswordInput = (TextInputEditText) findViewById(R.id.doPassword);
        nextTextView = (TextView) findViewById(R.id.nextTextView);

        nextTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.nextTextView: {
                UserEntityRequest userEntityRequest = new UserEntityRequest();
                userEntityRequest.setUsername(
                        mUserNameInput.getText().toString()
                );
                userEntityRequest.setPassword(
                        mPasswordInput.getText().toString()
                );
                userEntityRequest.setDoPassword(
                        mDoPasswordInput.getText().toString()
                );
                userEntityRequest.setPlatformMainTypeEnum(
                        PlatformMainTypeEnum.INDIVIDUAL);

                IndividualEntityRequest individualRequest = new IndividualEntityRequest();
                individualRequest.setUser(userEntityRequest);
                individualRequest.setIndividualTypeEnum(IndividualTypeEnum.CUSTOMER);
                Intent intent = new Intent(RegisterActivity.this, IndividualActivity.class);
                intent.putExtra(
                        getResources().getString(R.string.individual_extra) ,
                        individualRequest);
                startActivity(intent);
            }

                break;
            default:
                break;
        }
    }
}
