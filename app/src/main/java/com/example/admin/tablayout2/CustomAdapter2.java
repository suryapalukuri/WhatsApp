package com.example.admin.tablayout2;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

class CustomAdapter2 extends BaseAdapter{
    Context context;
    private String []arr;

    public CustomAdapter2( Context context, String[] arr) {
        this.context=context;
        this.arr=arr;
    }

    @Override
    public int getCount() {
        return arr.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View customView;

        view =  LayoutInflater.from(context).inflate(R.layout.custom_list_view2,viewGroup,false);
        TextView names = view.findViewById(R.id.txt3);
        names.setText(arr[i]);
        customView=view;

        return customView;
    }
}
