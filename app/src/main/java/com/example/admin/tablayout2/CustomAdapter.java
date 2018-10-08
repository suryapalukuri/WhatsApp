package com.example.admin.tablayout2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends BaseAdapter{
Context context;
    private String []arr;
    private  int []img;



    public CustomAdapter(Context context, String[] arr,int[] img) {
        this.context=context;
        this.arr=arr;
this.img=img;


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

        view =  LayoutInflater.from(context).inflate(R.layout.custom_list_view,viewGroup,false);
        TextView names = view.findViewById(R.id.txt1);
        ImageView images=view.findViewById(R.id.image1);
        names.setText(arr[i]);
        images.setImageResource(img[0]);
        customView=view;

        return customView;
    }
}
