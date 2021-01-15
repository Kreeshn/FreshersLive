package com.example.fresherslivecompany.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fresherslivecompany.R;
import com.example.fresherslivecompany.adapter.CompUserAdapter;
import com.example.fresherslivecompany.adapter.JobAdapter;
import com.example.fresherslivecompany.model.FetchJobDetailsResponse;
import com.example.fresherslivecompany.model.JobComp;
import com.example.fresherslivecompany.model.UserComp;
import com.example.fresherslivecompany.retrofitutil.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<JobComp> jobCompList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_job, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.compJobRecylerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //retrofit
        Call<FetchJobDetailsResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .JObDetails();
        call.enqueue(new Callback<FetchJobDetailsResponse>() {
            @Override
            public void onResponse(Call<FetchJobDetailsResponse> call, Response<FetchJobDetailsResponse> response) {
                if(response.isSuccessful()){
                        jobCompList= response.body().getJobCompList();
                        recyclerView.setAdapter(new JobAdapter(getActivity(),jobCompList));
                }
                else {
                    Toast.makeText(getActivity(),response.body().getResult_code(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FetchJobDetailsResponse> call, Throwable t) {
                Toast.makeText(getActivity(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}