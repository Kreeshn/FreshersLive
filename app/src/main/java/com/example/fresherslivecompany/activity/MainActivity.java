package com.example.fresherslivecompany.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.fresherslivecompany.R;
import com.example.fresherslivecompany.model.FetchJobDetailsResponse;
import com.example.fresherslivecompany.model.UserComp;
import com.example.fresherslivecompany.adapter.CompUserAdapter;
import com.example.fresherslivecompany.retrofitutil.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<UserComp> compList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.compRecylerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //retrofit
        Call<FetchJobDetailsResponse> call = RetrofitClient.getInstance().getApi().CompDetails();
        call.enqueue(new Callback<FetchJobDetailsResponse>() {
            @Override
            public void onResponse(Call<FetchJobDetailsResponse> call, Response<FetchJobDetailsResponse> response) {
                if (response.isSuccessful())
                {
                    compList = response.body().getCompList();
                    recyclerView.setAdapter(new CompUserAdapter(getApplicationContext(),compList));
                }
                else{
                    Toast.makeText(MainActivity.this,response.body().getError(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FetchJobDetailsResponse> call, Throwable t) {
                    Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}