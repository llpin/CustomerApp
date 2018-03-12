package com.common.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.common.vo.TypeVo;
import com.activity.R;

import java.util.List;

/**
 * Created by linlipin on 18/3/2.
 */

public class TypeAdapter<T> extends BaseAdapter {
    private List<TypeVo<T>> mList;
    private Context mContext;

    public TypeAdapter(List<TypeVo<T>> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater _LayoutInflater=LayoutInflater.from(mContext);
        convertView=_LayoutInflater.inflate(R.layout.spinner_item_custom, null);
        if(convertView!=null) {
            TextView textView=(TextView)convertView.findViewById(R.id.spinnerCustomItemTextView);
            textView.setText(mList.get(position).getValue());
        }
        return convertView;
    }
}
