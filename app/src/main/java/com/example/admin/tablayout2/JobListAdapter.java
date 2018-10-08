package com.example.admin.tablayout2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class JobListAdapter extends RecyclerView.Adapter<JobListAdapter.MyViewHolder> {
    Context context;

    List<JobListItem> jobList = new ArrayList<>();
    public JobListAdapter(Context context, List<JobListItem> jobList) {
        this.context = context;
        this.jobList = jobList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())

                .inflate(R.layout.job_list_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.name.setText(jobList.get(i).getName());

        myViewHolder.position_name.setText(jobList.get(i).getPosName());

        myViewHolder.exp.setText(jobList.get(i).getExperience());

        myViewHolder.sal_range.setText(jobList.get(i).getSalRange());

        myViewHolder.location.setText(jobList.get(i).getLocation());

        myViewHolder.key_skills.setText(jobList.get(i).getKeySkills());

        myViewHolder.card_layout.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {



            }

        });

    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView position_name, exp, sal_range, location, key_skills,name;

        CardView card_layout;

        CheckBox checkBox;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            position_name = itemView.findViewById(R.id.position_name);
            card_layout = itemView.findViewById(R.id.card_layout);
            exp = itemView.findViewById(R.id.exp);
            sal_range = itemView.findViewById(R.id.sal_range);
            location = itemView.findViewById(R.id.location);
            key_skills = itemView.findViewById(R.id.key_skills);
            checkBox = itemView.findViewById(R.id.check_apply);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(checkBox.isChecked()) {

                    } else{

                    }



                }

            });
        }
    }
}
