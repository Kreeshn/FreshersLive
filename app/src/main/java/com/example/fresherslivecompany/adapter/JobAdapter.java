package com.example.fresherslivecompany.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fresherslivecompany.R;
import com.example.fresherslivecompany.model.JobComp;
import com.example.fresherslivecompany.model.UserComp;

import java.util.List;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.viewHolder>{
    Context context;
    List<JobComp> jobCompList;

    public JobAdapter(Context context, List<JobComp> jobCompList) {
        this.context = context;
        this.jobCompList = jobCompList;
    }

    @NonNull
    @Override
    public JobAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.job_item, parent, false);
        return new JobAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobAdapter.viewHolder holder, int position) {
        holder.jobProfComp.setText(jobCompList.get(position).getProfile());
        holder.jobCompName.setText(jobCompList.get(position).getCo_name());
        holder.jobWorkType.setText(jobCompList.get(position).getWork_type());
        holder.jobSalary.setText(jobCompList.get(position).getSallaty_type());
        String duration = jobCompList.get(position).getDuration() +" Month";
        holder.jobDuration.setText(duration);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ClickedItem = jobCompList.get(position).getProfile()+"\n"+jobCompList.get(position).getCo_name();
                Toast.makeText(context,ClickedItem,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobCompList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView jobProfComp, jobCompName, jobWorkType, jobSalary, jobDuration;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            jobProfComp = itemView.findViewById(R.id.job_prof_comp);
            jobCompName = itemView.findViewById(R.id.job_compname_comp);
            jobWorkType = itemView.findViewById(R.id.job_work_type_comp);
            jobSalary = itemView.findViewById(R.id.job_salary_comp);
            jobDuration = itemView.findViewById(R.id.job_duration_comp);

        }
    }
}
