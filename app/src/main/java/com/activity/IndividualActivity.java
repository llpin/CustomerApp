package com.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.common.adapter.TypeAdapter;
import com.common.base.BaseActivity;
import com.common.base.enums.DirectionTypeEnum;
import com.common.base.enums.GenderTypeEnum;
import com.common.interfaces.BaseInter;
import com.common.pojo.FileResourceUploadResponse;
import com.common.pojo.IndividualEntityRequest;
import com.common.runnables.MessageToast;
import com.common.utils.ActivityUtil;
import com.common.utils.FileUtil;
import com.common.utils.GsonUtil;
import com.common.utils.HttpApiUtil;
import com.common.utils.L;
import com.common.vo.TypeVo;
//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.appindexing.Thing;
//import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class IndividualActivity extends BaseActivity implements BaseInter, View.OnClickListener {

    private static final int FRONT_ID_REQUEST_GALLERY = 1;// 从相册中选择
    private static final int BACK_ID_REQUEST_GALLERY = 2;// 从相册中选择


    private final static String TAG = "IndividualActivity";

    private TextInputEditText mNameEditText;

    private Spinner mGenderSpinner;
    //定义一个String类型的List数组作为数据源
    private List<TypeVo<GenderTypeEnum>> mGenderList;
    //定义一个ArrayAdapter适配器作为spinner的数据适配器
    private TypeAdapter<TypeVo<GenderTypeEnum>> mGenderSpinnerAdapter;

    private TextInputEditText mAddressEditText;
    private TextInputEditText mPostAddressEditText;
    private TextInputEditText mIdNumberEditText;
    private Long mFrontIDImageId;
    private Long mBackIDImageId;
    private ImageView mFrontIDImage;
    private ImageView mBackIDImage;

    private TextView mNextTextView;

    private IndividualEntityRequest mIndividualRequest;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
//    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual);

        mIndividualRequest =
                (IndividualEntityRequest) getIntent().getSerializableExtra(
                        getResources().getString(R.string.individual_extra)
                );
        L.d(TAG, mIndividualRequest.getUser().getUsername());

        initForm();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void initForm() {
        mNameEditText = (TextInputEditText) findViewById(R.id.name);

        mGenderSpinner = (Spinner) findViewById(R.id.genderSpinner);
        mGenderList = new ArrayList<TypeVo<GenderTypeEnum>>();
        mGenderList.add(new TypeVo<GenderTypeEnum>(GenderTypeEnum.MALE, "男"));
        mGenderList.add(new TypeVo<GenderTypeEnum>(GenderTypeEnum.FEMALE, "女"));
        mGenderSpinnerAdapter = new TypeAdapter(mGenderList, this);
        mGenderSpinner.setAdapter(mGenderSpinnerAdapter);
        mGenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                L.d(TAG, String.valueOf(id));
                TypeVo<GenderTypeEnum> typeVo = mGenderList.get(position);
                L.d(TAG, typeVo.getEm().name());
                mIndividualRequest.setGenderType(typeVo.getEm().name());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mNameEditText = (TextInputEditText) findViewById(R.id.name);
        mAddressEditText = (TextInputEditText) findViewById(R.id.address);
        mPostAddressEditText = (TextInputEditText) findViewById(R.id.postAddress);
        mIdNumberEditText = (TextInputEditText) findViewById(R.id.idNumber);

        mNextTextView = (TextView) findViewById(R.id.nextTextView);
        mNextTextView.setOnClickListener(this);

        ((Button)findViewById(R.id.frontIDImageButton)).setOnClickListener(this);
        ((Button)findViewById(R.id.backIDImageButton)).setOnClickListener(this);

        mFrontIDImage = (ImageView)findViewById(R.id.frontIDImage);
        mBackIDImage = (ImageView)findViewById(R.id.backIDImage);

//        // 激活系统图库，选择一张图片
//        Intent intent = new Intent(Intent.ACTION_PICK);
//        intent.setType("image/*");
//        // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_GALLERY
//        startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.nextTextView:
                mIndividualRequest.setName(
                        mNameEditText.getText().toString()
                );
                mIndividualRequest.setAddress(
                        mAddressEditText.getText().toString()
                );
                mIndividualRequest.setPostAddress(
                        mPostAddressEditText.getText().toString()
                );
                mIndividualRequest.setIdNumber(
                        mIdNumberEditText.getText().toString()
                );
                mIndividualRequest.setFrontIDImageId(mFrontIDImageId);
                mIndividualRequest.setBackIDImageId(mBackIDImageId);

                Intent intent = new Intent(IndividualActivity.this, TelephoneActivity.class);
                intent.putExtra(
                        getResources().getString(R.string.individual_extra),
                        mIndividualRequest);
                ActivityUtil.startActivitySimple(IndividualActivity.this, intent);
                break;
            case R.id.frontIDImageButton:
                FileUtil.fromGallery(this, FRONT_ID_REQUEST_GALLERY);
                break;
            case R.id.backIDImageButton:
                FileUtil.fromGallery(this, BACK_ID_REQUEST_GALLERY);
                break;
            default:
                break;
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
//    public Action getIndexApiAction() {
//        Thing object = new Thing.Builder()
//                .setName("Individual Page") // TODO: Define a title for the content shown.
//                // TODO: Make sure this auto-generated URL is correct.
//                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
//                .build();
//        return new Action.Builder(Action.TYPE_VIEW)
//                .setObject(object)
//                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
//                .build();
//    }

//    @Override
//    public void onStart() {
//        super.onStart();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        AppIndex.AppIndexApi.start(client, getIndexApiAction());
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        AppIndex.AppIndexApi.end(client, getIndexApiAction());
//        client.disconnect();
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case FRONT_ID_REQUEST_GALLERY: {
                if (data != null) {
                    Uri uri = data.getData();
                    displayIDImage(uri, mFrontIDImage);
                    uploadImage(uri, DirectionTypeEnum.FRONT);
                }
            }
                break;
            case BACK_ID_REQUEST_GALLERY: {
                if (data != null) {
                    Uri uri = data.getData();
                    displayIDImage(uri, mBackIDImage);
                    uploadImage(uri,DirectionTypeEnum.BACK);
                }
            }
            default:
                break;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void displayIDImage(Uri uri, ImageView view) {
        Bitmap bitmap = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        view.setImageBitmap(bitmap);
    }

    private void uploadImage(final Uri uri, final DirectionTypeEnum directionTypeEnum){
        //                    上传图片
        File image = FileUtil.fromUri(uri, this);
        if(image != null){
            HttpApiUtil.uploadImage(image, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    L.d(TAG, response.body().toString());
                    FileResourceUploadResponse fileResponse =
                            GsonUtil.fromResponse(response, FileResourceUploadResponse.class);
                    try{
                        if(fileResponse.getCode().compareTo("200") == 0){
                            if(directionTypeEnum == DirectionTypeEnum.FRONT){
                                mFrontIDImageId = fileResponse.getData().getId();
                            }else if(directionTypeEnum == DirectionTypeEnum.BACK){
                                mBackIDImageId = fileResponse.getData().getId();
                            }
                        }else {
                            runOnUiThread(new MessageToast(IndividualActivity.this,
                                    fileResponse.getMessage()));
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            });
        }

    }
}
