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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}