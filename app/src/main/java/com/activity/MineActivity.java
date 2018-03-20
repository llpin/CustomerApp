package com.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.common.base.BaseActivity;
import com.common.interfaces.BaseInter;
import com.common.pojo.EmployeeEntityResponse;
import com.common.pojo.IndividualEntityResponse;
import com.common.pojo.UserVoResponse;

public class MineActivity extends BaseActivity implements BaseInter{
    IndividualEntityResponse mIndividual;

    TextView mUsernameText;
    TextView mUsertypeText;
    TextView mName;
    TextView mTelephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);

        try{
            UserVoResponse user = getUserApplication().getUserVo();
            if(user != null)
                mIndividual = user.getIndividual();
        }catch (Exception e){
            e.printStackTrace();
        }


        initForm();
    }

    @Override
    public void initForm() {
        if(mIndividual != null){
            try{
                mUsernameText = (TextView)findViewById(R.id.username);
                mUsertypeText = (TextView)findViewById(R.id.usertype);
                mName = (TextView)findViewById(R.id.name);
                mTelephone = (TextView)findViewById(R.id.telephone);

                mUsernameText.setText(mIndividual.getUser().getUsername());
                mUsertypeText.setText(mIndividual.getUser().getPlatformMainType().getName());
                mName.setText(mIndividual.getName());
                mTelephone.setText(mIndividual.getTelephone());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
