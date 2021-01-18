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
import com.example.freshersliveadmin.adapter.StudentAdapter;
import com.example.freshersliveadmin.model.Comp;
import com.example.freshersliveadmin.model.FetchStudentsDetails;
import com.example.freshersliveadmin.model.Student;
import com.example.freshersliveadmin.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentPenndingReqFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Student> StdList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_pennding_req, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.penddingStudentReqRecylerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //retrofit

        Call<FetchStudentsDetails> call = RetrofitClient
                .getInstance()
                .getApi()
                .fetchStudentsDetails();
        call.enqueue(new Callback<FetchStudentsDetails>() {
            @Override
            public void onResponse(Call<FetchStudentsDetails> call, Response<FetchStudentsDetails> response) {
                if(response.isSuccessful()){
                    StdList= response.body().getStdList();
                    recyclerView.setAdapter(new StudentAdapter(getActivity(),StdList));
                }
                else {
                    Toast.makeText(getActivity(),response.body().getError(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FetchStudentsDetails> call, Throwable t) {
                Toast.makeText(getActivity(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}