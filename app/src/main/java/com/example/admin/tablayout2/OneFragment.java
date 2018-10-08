package com.example.admin.tablayout2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class OneFragment extends Fragment{
    private ListView listview;
    String []arr={"Surya","Nirosha","Asif","Swetha","Lakshmi","Seshadri","Ramesh","Prashanthi","Tejkumar","Subhakar","Vinod","Jaggu"};
    ArrayAdapter<String> adapter;
    CustomAdapter2 customAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Log.i("onAttach", "called");
        listview=view.findViewById(R.id.listview);
        customAdapter =new CustomAdapter2(getActivity(),arr);
        listview.setAdapter(customAdapter);
        return view;
    }
}
