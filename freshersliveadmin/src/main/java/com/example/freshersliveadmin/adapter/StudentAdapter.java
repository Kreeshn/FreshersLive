package com.example.freshersliveadmin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freshersliveadmin.R;
import com.example.freshersliveadmin.model.Comp;
import com.example.freshersliveadmin.model.CompApproveRejectResponse;
import com.example.freshersliveadmin.model.Student;
import com.example.freshersliveadmin.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.viewHolder> {
    Context context;
    List<Student> StdList;

    public StudentAdapter(Context context, List<Student> stdList) {
        this.context = context;
        StdList = stdList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_item, parent, false);
        return new StudentAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        String fullName = StdList.get(position).getFname()+" "+StdList.get(position).getLname();
        holder.etStdName.setText(fullName);
        holder.etStdEmail.setText(StdList.get(position).getEmail());
        holder.imgApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                approvestd(StdList.get(position).getSid());
            }
        });
        holder.imgReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rejectstd(StdList.get(position).getSid());
            }
        });
    }

    @Override
    public int getItemCount() {
        return StdList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView etStdName, etStdEmail;
        ImageView imgApprove, imgReject;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            etStdName = (TextView) itemView.findViewById(R.id.stdName);
            etStdEmail = (TextView) itemView.findViewById(R.id.stdEmail);
            imgApprove = (ImageView) itemView.findViewById(R.id.imgApprovestd);
            imgReject = (ImageView) itemView.findViewById(R.id.imgRejectstd);
        }
    }

    public void approvestd(int sid){
        Call<CompApproveRejectResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .stdApproveReject(sid, 1);
        call.enqueue(new Callback<CompApproveRejectResponse>() {
            @Override
            public void onResponse(Call<CompApproveRejectResponse> call, Response<CompApproveRejectResponse> response) {
                if(response.isSuccessful()){
                    if (response.body().getError().equals("200")){
                        Toast.makeText(context,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(context,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CompApproveRejectResponse> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void rejectstd(int sid){
        Call<CompApproveRejectResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .stdApproveReject(sid, 2);
        call.enqueue(new Callback<CompApproveRejectResponse>() {
            @Override
            public void onResponse(Call<CompApproveRejectResponse> call, Response<CompApproveRejectResponse> response) {
                if(response.isSuccessful()){
                    if (response.body().getError().equals("200")){
                        Toast.makeText(context,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(context,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CompApproveRejectResponse> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
