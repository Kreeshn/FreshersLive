package com.example.freshersliveadmin.fragment;

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

import com.example.freshersliveadmin.R;
import com.example.freshersliveadmin.adapter.CompAdapter;
import com.example.freshersliveadmin.model.Comp;
import com.example.freshersliveadmin.model.FetchCompDetailsResponse;
import com.example.freshersliveadmin.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompAcceptReqFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Comp> CompList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comp_accept_req, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.approvedCompReqRecylerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //retrofit
        Call<FetchCompDetailsResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .fetchCompDetailsApproved();
        call.enqueue(new Callback<FetchCompDetailsResponse>() {
            @Override
            public void onResponse(Call<FetchCompDetailsResponse> call, Response<FetchCompDetailsResponse> response) {
                if(response.isSuccessful()){
                    CompList= response.body().getCompList();
                    recyclerView.setAdapter(new CompAdapter(getActivity(),CompList));
                }
                else {
                    Toast.makeText(getActivity(),response.body().getError(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FetchCompDetailsResponse> call, Throwable t) {
                Toast.makeText(getActivity(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}