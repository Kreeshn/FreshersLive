package com.example.fresherslivecompany.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fresherslivecompany.R;

public class compLogin extends AppCompatActivity {
    TextView text_newuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp_login);
        text_newuser = (TextView) findViewById(R.id.textNewUser);
        text_newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(compLogin.this,compReg.class));
                finish();
            }
        });
    }
}