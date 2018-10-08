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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TwoFragment extends Fragment {
    private ListView listview;
    String []arr={"Surya","Nirosha","Asif","Swetha","Lakshmi","Seshadri","Ramesh","Prashanthi","Tejkumar","Subhakar","Vinod","Jaggu"};
    ArrayAdapter<String> adapter;
    CustomAdapter1 customAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main1, container, false);
        Log.i("onAttach", "called");
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //ArrayList<ChatBean> list = new ArrayList<>();
        List<JobListItem> jobListItems = new ArrayList<>();
        String json = "{" +

                "\"job_list\":[" +

                "    {" +

                "\"name\":\"Surya\","+

                "\"pos_name\": \"Android Developer\"," +

                "\"experience\": \"Fresher\"," +

                "\"sal_range\": \"Depending On Performance\"," +

                "\"location\": \"Hyderabad\"," +

                "\"key_skills\": \"Android, java, html, javascript, oracle\"," +

                "\"createddate\": \"2018-08-04\"" +

                "}, {" +

                "\"name\":\"Nirosha\","+

                "\"pos_name\": \"Android Developer\"," +

                "\"experience\": \"Fresher\"," +

                "\"sal_range\": \"Depending On Performance\"," +

                "\"location\": \"Hyderabad\"," +

                "\"key_skills\": \" java, .net, Android,\"," +

                "\"createddate\": \"2018-08-04\"" +
                "}, {" +

                "\"name\":\"Asif\","+

                "\"pos_name\": \"Android Developer\"," +

                "\"experience\": \"Fresher\"," +

                "\"sal_range\": \"Depending On Performance\"," +

                "\"location\": \"Hyderabad\"," +

                "\"key_skills\": \"Android, java,\"," +

                "\"createddate\": \"2018-08-04\"" +

                "},{"+
                "\"name\":\"Swetha\","+

                "\"pos_name\": \"Android Developer\"," +

                "\"experience\": \"Fresher\"," +

                "\"sal_range\": \"Depending On Performance\"," +

                "\"location\": \"Hyderabad\"," +

                "\"key_skills\": \"Android, corejava, adavanced java\"," +

                "\"createddate\": \"2018-08-04\"" +
                "},{"+
                "\"name\":\"Lakshmi\","+

                "\"pos_name\": \"Android Developer\"," +

                "\"experience\": \"Fresher\"," +

                "\"sal_range\": \"Depending On Performance\"," +

                "\"location\": \"Hyderabad\"," +

                "\"key_skills\": \"Android, java, xml\"," +

                "\"createddate\": \"2018-08-04\"" +

                "}]}";

        try {

            JSONObject object = new JSONObject(json);

            JSONArray array = object.getJSONArray("job_list");

            for (int i =0; i<array.length(); i++){

                JobListItem item = new JobListItem();

                JSONObject list_obj = array.getJSONObject(i);

                item.setName(list_obj.getString("name"));

                item.setPosName(list_obj.getString("pos_name"));

                item.setExperience(list_obj.getString("experience"));

                item.setLocation(list_obj.getString("location"));

                item.setSalRange(list_obj.getString("sal_range"));

                item.setKeySkills(list_obj.getString("key_skills"));

//                item.setPosName(list_obj.getString("pos_name"));

                jobListItems.add(item);

            }

            recyclerView.setAdapter(new JobListAdapter(getActivity(), jobListItems));


        } catch (JSONException e) {

            e.printStackTrace();

            }
        return view;
    }
}
