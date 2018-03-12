package com.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.common.adapter.ContractPartAdapter;
import com.common.base.BaseActivity;
import com.common.interfaces.BaseInter;
import com.common.pojo.ContractPartEntityResponse;
import com.common.pojo.ContractPartGettingResponse;
import com.common.pojo.PageDataResponse;
import com.common.runnables.MessageToast;
import com.common.utils.GsonUtil;
import com.common.utils.HttpApiUtil;
import com.common.utils.L;
import com.common.utils.ToastUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ContractPartActivity extends BaseActivity implements BaseInter{

    final static String TAG = "ContractPartActivity";
    final static int CONTRACT_PART_HANDLE_CODE = 22;

//    private final int STATE_NONE = 0x00;
//    private final int STATE_LOADING = 0x01;
//    private final int STATE_FAILURE = 0x02;
//    private final int STATE_COMPLETE = 0x03;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mRecyclerViewLayoutManager;

    private boolean loadMoreEnable;

    private List<ContractPartEntityResponse> partList = new ArrayList<>();

    private int mCurrentPage = 0;
    private boolean lastPage;

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what){
                case CONTRACT_PART_HANDLE_CODE:
                    updateRecyclerView(getPartList());
                    break;
                default:
                    break;
            }

        }
    };

    private void updateRecyclerView(List<ContractPartEntityResponse> list) {
        mRecyclerView.setAdapter(
                new ContractPartAdapter(list));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract_part);

        initForm();

        initPartList();
    }

    private void initPartList() {
        getContractPartWithPage(mCurrentPage);
    }

    private void getContractPartWithPage(int page) {
        setLoadMoreEnable(false);
        if(isLastPage()){
            ToastUtil.showShort(ContractPartActivity.this, "没有更多数据");
            setLoadMoreEnable(true);
            return;
        }

        try {
            HttpApiUtil.getContractPart(getUserApplication().getUserVo().getUser().getId(),
                    page,
                    new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            e.printStackTrace();
                            setLoadMoreEnable(true);
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            ContractPartGettingResponse gettingResponse =
                                    GsonUtil.fromResponse(response, ContractPartGettingResponse.class);
                                setLoadMoreEnable(true);

                            try{
                                if (gettingResponse.getCode().compareTo("200") == 0) {
//                                L.d(TAG,gettingResponse.toString());
                                    PageDataResponse<ContractPartEntityResponse> dataResponse = gettingResponse.getData();
//                                    TODO 数据叠加
                                    if(dataResponse.getTotalElements() == 0){
                                        runOnUiThread(new MessageToast(ContractPartActivity.this, "暂无数据"));
                                    }

                                    if (dataResponse != null) {
                                        mCurrentPage = dataResponse.getNumber();
                                        setLastPage(dataResponse.getLast());
                                        List<ContractPartEntityResponse> partList =
                                                dataResponse.getContent();

                                        getPartList().addAll(partList);

//                                        handler.sendMessage(handler.obtainMessage(
//                                                CONTRACT_PART_HANDLE_CODE, partList));
                                        handler.sendEmptyMessage(CONTRACT_PART_HANDLE_CODE);
                                    }
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }


                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initForm() {
        mRecyclerView = (RecyclerView) findViewById(R.id.contract_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mRecyclerViewLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mRecyclerViewLayoutManager);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        // specify an adapter (see also next example)
//        mAdapter = new ContractPartAdapter(partList);
//        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                L.d(TAG,"newState");
                L.d(TAG,String.valueOf(newState));
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(isLoadMoreEnable() && dy > 0){
                    LinearLayoutManager layoutManager = (LinearLayoutManager)mRecyclerViewLayoutManager;
                    int totalItemCount = layoutManager.getItemCount();
                    int lastVisibleItem = layoutManager.findLastVisibleItemPosition();
                    if (lastVisibleItem + 1 >= totalItemCount) {
                        onLoadMore(recyclerView);
                    }
                }
            }
        });

    }

    private void onLoadMore(RecyclerView recyclerView) {
        getContractPartWithPage(++mCurrentPage);
    }

    public boolean isLoadMoreEnable() {
        return loadMoreEnable;
    }

    public void setLoadMoreEnable(boolean loadMoreEnable) {
        this.loadMoreEnable = loadMoreEnable;
    }

    public List<ContractPartEntityResponse> getPartList() {
        return partList;
    }

    public void setPartList(List<ContractPartEntityResponse> partList) {
        this.partList = partList;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }
}
