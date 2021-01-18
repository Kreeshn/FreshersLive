package com.example.fresherslivecompany.activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fresherslivecompany.activity.nav_drawer_header;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.fresherslivecompany.R;
import com.example.fresherslivecompany.apputil.SharedPrefManager;

public class SpalceScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalce_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SpalceScreenActivity.this, compLogin.class));
                finish();
            }
        },3000);
    }
}