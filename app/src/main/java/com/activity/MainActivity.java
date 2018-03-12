package com.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.common.base.ZxingActivity;
import com.common.interfaces.BaseInter;
import com.common.utils.ActivityUtil;

public class MainActivity extends ZxingActivity
        implements BaseInter,
        NavigationView.OnNavigationItemSelectedListener,
        View.OnClickListener {

    private final static String TAG = "MainActivity";

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
//    private FloatingActionButton floatingActionButton;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initForm();

//        User user = getUserApplication().getSimpleUser();
//        ToastUtil.showShort(getApplicationContext(), user.getUsername());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = getDrawerLayout();
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == id_action_setting) {
//            showToastShort("setting");
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.nav_camera:
                doVerify();
                break;
            case R.id.nav_contract:
                showContracts();
                break;
            case R.id.nav_mine:
                ActivityUtil.startActivitySimple(this, MineActivity.class);
//                ToastUtil.showShort(this, "mine");
                break;
        }

        getDrawerLayout().closeDrawer(GravityCompat.START);
        return true;
    }

    private void showContracts() {
//        ToastUtil.showShort(this, "contract");
        ActivityUtil.startActivitySimple(MainActivity.this, ContractPartActivity.class);
//        try{
//            HttpApiUtil.getContractPart(getUserApplication().getUserVo().getUser().getId(),
//                    new Callback() {
//                        @Override
//                        public void onFailure(Call call, IOException e) {
//                            e.printStackTrace();
//                        }
//
//                        @Override
//                        public void onResponse(Call call, Response response) throws IOException {
//                            ContractPartGettingResponse gettingResponse =
//                                    GsonUtil.fromResponse(response, ContractPartGettingResponse.class);
//
//                            if(gettingResponse.getCode().compareTo("200") == 0){
//                                L.d(TAG,gettingResponse.toString());
//                            }
//
//                        }
//                    });
//        }catch (Exception e){
//            e.printStackTrace();
//        }

    }

    @Override
    public void initForm() {
        setDrawerLayout((DrawerLayout) findViewById(R.id.drawer_layout));

        setToolbar((Toolbar) findViewById(R.id.toolbar));
        setSupportActionBar(getToolbar());

//        setFloatingActionButton((FloatingActionButton) findViewById(id_fab));
//        getFloatingActionButton().setOnClickListener(this);

        setNavigationView((NavigationView) findViewById(R.id.nav_view));
        getNavigationView().setNavigationItemSelectedListener(this);

        setImageButton((ImageButton) findViewById(R.id.imageButton));
        getImageButton().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton:
                doVerify();
                break;
            default:
                break;
        }
    }

    private void doVerify() {
        if (isTestModel()) {
            startCaptureActivityWithContractId(MainActivity.this, (long) 1);
        } else {

            //扫码验真
            try {
                startCaptureActivityWithUserId(MainActivity.this,
                        getUserApplication().getUserVo().getUser().getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        onCaptureActivityResult(requestCode, resultCode, data);
//    }

    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }

    public void setDrawerLayout(DrawerLayout drawerLayout) {
        this.drawerLayout = drawerLayout;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    public NavigationView getNavigationView() {
        return navigationView;
    }

    public void setNavigationView(NavigationView navigationView) {
        this.navigationView = navigationView;
    }

//    public FloatingActionButton getFloatingActionButton() {
//        return floatingActionButton;
//    }
//
//    public void setFloatingActionButton(FloatingActionButton floatingActionButton) {
//        this.floatingActionButton = floatingActionButton;
//    }

    public ImageButton getImageButton() {
        return imageButton;
    }

    public void setImageButton(ImageButton imageButton) {
        this.imageButton = imageButton;
    }

//    @Override
//    public void resultSuccess(final String result) {
//        super.resultSuccess(result);
////        Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
////        查找商品信息
//        if(isTestModel()){
//            //TODO 商品信息展示
//            ActivityUtil.startActivitySimple(MainActivity.this, ProductInfoActivity.class);
//        }else {
//            HttpApiUtil.getProductCode(result, new Callback() {
//                @Override
//                public void onFailure(Call call, IOException e) {
//                    e.printStackTrace();
//                }
//
//                @Override
//                public void onResponse(Call call, Response response) throws IOException {
//
//                    String ret = response.body().string();
//                    L.d(TAG, ret);
//                    ProductCodeInfoResponse codeInfoResponse = GsonUtil.fromJson(ret, ProductCodeInfoResponse.class);
//                    try {
//                        if(codeInfoResponse.getCode().compareTo("200") == 0){
//                            //TODO 商品信息展示
////                            Intent intent = new Intent(MainActivity.this, ProductInfoActivity.class);
////                            intent.putExtra(
////                                    getResources().getString(R.string.product_code_extra),
////                                    codeInfoResponse.getData()
////                            );
////
////                            runOnUiThread(new ResponseActivity(MainActivity.this, intent));
//                            //TODO 商品保真
//                            //新建合同 修改状态
//
//
//                        }
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//
//                }
//            });
//        }
//
//        //Toast.makeText(this, "商品为真", Toast.LENGTH_LONG).show();
//
////        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//////                dialog.setTitle("保真");
////        dialog.setMessage("真货");
////        dialog.setCancelable(false);
////        dialog.setPositiveButton(R.string.qrcode_result_okBtn, new DialogInterface.OnClickListener() {
////
////            @Override
////            public void onClick(DialogInterface dialog, int which) {
////                //TODO 二维码识别成功
//////                Intent intent = new Intent(this, QRcodeResultActivity.class);
//////                intent.putExtra(MainActivity.this.getString(R.string.zxing_result), result);
//////                startActivity(intent);
////            }
////        });
////        dialog.setNegativeButton(R.string.qrcode_result_cancleBtn, new DialogInterface.OnClickListener() {
////            @Override
////            public void onClick(DialogInterface dialog, int which) {
////
////            }
////        });
////        dialog.show();
//    }
}
