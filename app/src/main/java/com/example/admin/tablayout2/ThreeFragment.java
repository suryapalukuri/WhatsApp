package com.example.admin.tablayout2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ThreeFragment extends Fragment {
    ListView listView;
    String []arr={"Surya","Nirosha","Asif","Swetha","Lakshmi","Seshadri","Ramesh","Prashanthi","Tejkumar","Subhakar","Vinod","Jaggu"};
    String  []numbers={"9866004629","8125224669"};
    int []img={R.drawable.phone};
    ArrayAdapter<String> adapter;
    CustomAdapter customAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Log.i("onAttach", "called");
        listView=view.findViewById(R.id.listview);
        customAdapter =new CustomAdapter(getActivity(),arr,img);
        listView.setAdapter(customAdapter);
        return view;
    }
}
