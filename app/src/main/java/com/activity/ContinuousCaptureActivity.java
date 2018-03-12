package com.activity;

import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.BeepManager;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.DefaultDecoderFactory;
import com.common.base.BaseActivity;

import com.common.pojo.ResultResponseModel;
import com.common.runnables.MessageToast;
import com.common.utils.GsonUtil;
import com.common.utils.HttpApiUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * This sample performs continuous scanning, displaying the barcode and source image whenever
 * a barcode is scanned.
 */
public class ContinuousCaptureActivity extends BaseActivity {
    private static final String TAG = ContinuousCaptureActivity.class.getSimpleName();
    private DecoratedBarcodeView barcodeView;
    private BeepManager beepManager;
    private String lastText;
    private TextView textView;
//    private int codeCount = 0;

    private Long userId;

    private BarcodeCallback callback = new BarcodeCallback() {
        @Override
        public void barcodeResult(final BarcodeResult result) {
            if(result.getText() == null || result.getText().equals(lastText)) {
//                textView.setText("重复扫码");
                return;
            }
            lastText = result.getText();
//            TODO http 验真
            if(isTestModel()){
                textView.setText(result.getText());
            }else {
//                验真
                HttpApiUtil.productCodeVerify(lastText,userId, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final ResultResponseModel resultResponseModel=
                                GsonUtil.fromResponse(response, ResultResponseModel.class);
                        if(resultResponseModel.getCode().compareTo("200") == 0){

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    textView.setText(resultResponseModel.getMessage());
                                }
                            });

                        }else {
                            runOnUiThread(new MessageToast(ContinuousCaptureActivity.this,
                                    resultResponseModel.getMessage()));
                        }
                    }
                });

//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        String code = result.getText();
//
//                        try {
//                            Response response = HttpApiUtil.productCodeVerify(code, userId);
//                            ResultResponseModel resultResponseModel =
//                                    GsonUtil.fromResponse(response, ResultResponseModel.class);
//
//                            String html = "<font color='#00ff00'><big>" + resultResponseModel.getMessage() + "</big></font>";
//                            if(result.getText() == null || result.getText().equals(lastText)) {
//                                html += "<font color='#ff0000'>" + "重复验真" + "</font>";
//                            }
//                            textView.setText(Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY));
//
//                            lastText = result.getText();
//
//                            Thread.sleep((long)2000);
//
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }).start();

            }

            beepManager.playBeepSoundAndVibrate();


        }

        @Override
        public void possibleResultPoints(List<ResultPoint> resultPoints) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        codeCount = 0;

        setContentView(R.layout.continuous_scan);

        barcodeView = (DecoratedBarcodeView) findViewById(R.id.barcode_scanner);
        Collection<BarcodeFormat> formats = Arrays.asList(BarcodeFormat.QR_CODE, BarcodeFormat.CODE_39);
        barcodeView.getBarcodeView().setDecoderFactory(new DefaultDecoderFactory(formats));
        barcodeView.decodeContinuous(callback);

        beepManager = new BeepManager(this);

        textView = (TextView)findViewById(R.id.countTextView);
//        String html = "已扫描保真<font color='#ff0000'><big>"+ codeCount +"</big></font>件商品";
//        textView.setText(Html.fromHtml(html,Html.FROM_HTML_MODE_LEGACY));
//
//        contractId = getIntent().getLongExtra(getResources().getString(R.string.contract_id_extra), 0);

        userId = getIntent().getLongExtra(getResources().getString(R.string.user_id_extra),0);
    }

    @Override
    protected void onResume() {
        super.onResume();

        barcodeView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        barcodeView.pause();
    }

    public void pause(View view) {
        barcodeView.pause();
    }

    public void resume(View view) {
        barcodeView.resume();
    }

    public void triggerScan(View view) {
        barcodeView.decodeSingle(callback);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return barcodeView.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }
}
