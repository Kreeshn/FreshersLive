package com.example.freshersliveadmin.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.freshersliveadmin.R;

public class AdminLoginActivity extends AppCompatActivity {
    EditText etcompEmailLogin, etcompPassLogin;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
    }
}