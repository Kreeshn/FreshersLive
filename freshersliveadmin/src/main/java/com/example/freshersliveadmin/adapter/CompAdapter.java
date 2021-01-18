package com.example.freshersliveadmin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freshersliveadmin.R;
import com.example.freshersliveadmin.fragment.CompReqFragment;
import com.example.freshersliveadmin.model.Comp;
import com.example.freshersliveadmin.model.CompApproveRejectResponse;
import com.example.freshersliveadmin.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompAdapter extends RecyclerView.Adapter<CompAdapter.viewHolder> {
    Context context;
    List<Comp> CompList;

    public CompAdapter(Context context, List<Comp> compList) {
        this.context = context;
        CompList = compList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comp_item, parent, false);
        return new CompAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
            holder.compName.setText(CompList.get(position).getCo_name());
            holder.compEmail.setText(CompList.get(position).getCo_email());

            holder.imgapprove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Call<CompApproveRejectResponse> call = RetrofitClient
                            .getInstance()
                            .getApi()
                            .compApproveReject(CompList.get(position).getCo_id(),1);
                    call.enqueue(new Callback<CompApproveRejectResponse>() {
                        @Override
                        public void onResponse(Call<CompApproveRejectResponse> call, Response<CompApproveRejectResponse> response) {
                            if(response.isSuccessful()){
                                if (response.body().getError().equals("200")){
                                    Toast.makeText(context,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(context,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(context,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<CompApproveRejectResponse> call, Throwable t) {
                            Toast.makeText(context,t.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });
/*
                    AppCompatActivity activity = (AppCompatActivity)v.getContext();
                    CompReqFragment compReqFragment = new CompReqFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, compReqFragment)
                            .addToBackStack(null)
                            .commit(); */
                }
            });

        holder.imgreject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<CompApproveRejectResponse> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .compApproveReject(CompList.get(position).getCo_id(),2);
                call.enqueue(new Callback<CompApproveRejectResponse>() {
                    @Override
                    public void onResponse(Call<CompApproveRejectResponse> call, Response<CompApproveRejectResponse> response) {
                        if(response.isSuccessful()){
                            if (response.body().getError().equals("200")){
                                Toast.makeText(context,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(context,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(context,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<CompApproveRejectResponse> call, Throwable t) {
                        Toast.makeText(context,t.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
/*
                AppCompatActivity activity = (AppCompatActivity)v.getContext();
                CompReqFragment compReqFragment = new CompReqFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, compReqFragment)
                        .addToBackStack(null)
                        .commit(); */
            }
        });

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "You Click"+ CompList.get(position).getCo_name(),Toast.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    public int getItemCount() {
        return CompList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView compName, compEmail;
        ImageView imgapprove, imgreject;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            compName = (TextView) itemView.findViewById(R.id.CompName);
            compEmail = (TextView) itemView.findViewById(R.id.CompEmail);
            imgapprove = (ImageView) itemView.findViewById(R.id.imgApprove);
            imgreject = (ImageView) itemView.findViewById(R.id.imgReject);
        }
    }
}
