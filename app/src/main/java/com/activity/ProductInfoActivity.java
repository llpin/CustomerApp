package com.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.common.base.BaseActivity;
import com.common.interfaces.BaseInter;
import com.common.pojo.CodeOrderEntityResponse;
import com.common.pojo.OrganizationEntityResponse;
import com.common.pojo.ProductCodeEntityResponse;
import com.common.pojo.ProductEntityResponse;
import com.common.pojo.ProductPromiseEntityResponse;

public class ProductInfoActivity extends BaseActivity implements BaseInter, View.OnClickListener {
    private final static String TAG = "ProductInfoActivity";
    private ProductCodeEntityResponse mProductCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        mProductCode =
                (ProductCodeEntityResponse) getIntent().getSerializableExtra(
                        getResources().getString(R.string.product_code_extra)
                );

        initForm();
    }

    @Override
    public void initForm() {
        try {
            CodeOrderEntityResponse order = mProductCode.getOrder();
            OrganizationEntityResponse factory = order.getFactory();
            ProductEntityResponse product = order.getProduct();
            ProductPromiseEntityResponse promise = product.getPromise();
            ((TextView)findViewById(R.id.name)).setText(product.getName());
            ((TextView)findViewById(R.id.function)).setText(product.getFunction());
            ((TextView)findViewById(R.id.description)).setText(product.getDescription());
            ((TextView)findViewById(R.id.promise)).setText(promise.getContent());
            ((TextView)findViewById(R.id.orgName)).setText(factory.getName());
            ((TextView)findViewById(R.id.orgPhone)).setText(factory.getPhone());
            ((TextView)findViewById(R.id.orgAddress)).setText(factory.getAddress());
        }catch (Exception e){
            e.printStackTrace();
        }

        ((Button)findViewById(R.id.signButton)).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.signButton:

                break;
        }
    }
}
