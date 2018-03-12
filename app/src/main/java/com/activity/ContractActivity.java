package com.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.common.base.BaseActivity;
import com.common.interfaces.BaseInter;
import com.common.pojo.ContractEntityResponse;
import com.common.pojo.ContractPartEntityResponse;
import com.common.pojo.UserEntityResponse;
import com.common.utils.DateUtil;

public class ContractActivity extends BaseActivity implements BaseInter {
    ContractPartEntityResponse partEntityResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);

        partEntityResponse = (ContractPartEntityResponse)getIntent().getSerializableExtra(
                getResources().getString(R.string.contract_entity_extra));

        initForm();
    }

    @Override
    public void initForm() {
        try {
            ContractEntityResponse contract = getPartEntityResponse().getContract();
            ((TextView)findViewById(R.id.signTime)).setText(
                    DateUtil.formatDate(getPartEntityResponse().getCreateTime()));

            ((TextView)findViewById(R.id.cno)).setText(contract.getCno());

            ((TextView)findViewById(R.id.createTime)).setText(
                    DateUtil.formatDate(contract.getCreateTime()));

            ((TextView)findViewById(R.id.title)).setText(contract.getTitle());

            ((TextView)findViewById(R.id.content)).setText(contract.getContent());

            UserEntityResponse draftUser = contract.getDraftUser();
            ((TextView)findViewById(R.id.draftUser)).setText(draftUser.getUsername());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ContractPartEntityResponse getPartEntityResponse() {
        return partEntityResponse;
    }

    public void setPartEntityResponse(ContractPartEntityResponse partEntityResponse) {
        this.partEntityResponse = partEntityResponse;
    }


}
