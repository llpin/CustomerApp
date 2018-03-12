package com.common.base;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.activity.ContinuousCaptureActivity;
import com.activity.R;
import com.common.interfaces.ZxingInter;
import com.common.runnables.ResponseActivity;

/**
 * Created by linlipin on 18/1/3.
 */

public class ZxingActivity extends BaseActivity implements ZxingInter {
    private final static String TAG = "ZxingActivity";

    public final static int CUSTOMIZED_REQUEST_CODE = 0x0000ffff;

//    @Override
//    public void zxingInit() {
//        ZXingLibrary.initDisplayOpinion(this);
//    }

    @Override
    public void startCaptureActivityWithContractId(Activity activity, Long contractId) {
        Intent intent = getCaptureIntentWithContractId(contractId);
        startActivity(intent);
    }

    @Override
    public void startCaptureActivityWithUserId(Activity activity, Long userId) {
        Intent intent = getCaptureIntentWithUserId(userId);
        startActivity(intent);
    }

    @NonNull
    private Intent getCaptureIntentWithContractId(Long contractId) {
        Intent intent = new Intent(this, ContinuousCaptureActivity.class);
        intent.putExtra(getResources().getString(R.string.contract_id_extra),contractId);
        return intent;
    }

    @NonNull
    private Intent getCaptureIntentWithUserId(Long contractId) {
        Intent intent = new Intent(this, ContinuousCaptureActivity.class);
        intent.putExtra(getResources().getString(R.string.user_id_extra),contractId);
        return intent;
    }

    @Override
    public void startCaptureActivityWithContractIdRunnable(Activity activity, Long contractId) {
        Intent intent = getCaptureIntentWithContractId(contractId);
        runOnUiThread(new ResponseActivity(activity, intent));
    }

//    @Override
//    public void onCaptureActivityResult(int requestCode, int resultCode, Intent data) {
//        /**
//         * 处理二维码扫描结果
//         */
//        if (requestCode != CUSTOMIZED_REQUEST_CODE && requestCode != IntentIntegrator.REQUEST_CODE) {
//            // This is important, otherwise the result will not be passed to the fragment
//            super.onActivityResult(requestCode, resultCode, data);
//            return;
//        }
//        switch (requestCode) {
//            case CUSTOMIZED_REQUEST_CODE: {
//                Toast.makeText(this, "REQUEST_CODE = " + requestCode, Toast.LENGTH_LONG).show();
//                break;
//            }
//            default:
//                break;
//        }
//
//        IntentResult result = IntentIntegrator.parseActivityResult(resultCode, data);
//
//        if(result.getContents() == null) {
//            Log.d(TAG, "取消扫码");
//            Toast.makeText(this, "取消扫码", Toast.LENGTH_LONG).show();
//        } else {
////            Log.d(TAG, "扫码结果");
////            Toast.makeText(this, "扫码结果: " + result.getContents(), Toast.LENGTH_LONG).show();
//            resultSuccess(result.getContents());
//        }
//    }

//    @Override
//    public void resultSuccess(String result) {
//        L.d(TAG, result);
//    }
//
//    @Override
//    public void resultError() {
//        showToastLong(this.getString(R.string.zxing_result_failed));
//    }
}
