package com.example.fresherslivecompany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class compReg extends AppCompatActivity {
    TextView textLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp_reg);
        textLogin = (TextView) findViewById(R.id.textLogin);
        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(compReg.this, compLogin.class));
                finish();
            }
        });
    }
}