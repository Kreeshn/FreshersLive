package com.example.fresherslivecompany.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.fresherslivecompany.R;
import com.example.fresherslivecompany.apputil.SharedPrefManager;

public class nav_drawer_header extends AppCompatActivity {
    private TextView compNameHeader, compEmailHeader;
    private SharedPrefManager sharedPrefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer_header);
        compNameHeader = (TextView) findViewById(R.id.compNameOnNavHeader);
        compEmailHeader = (TextView) findViewById(R.id.compEmailOnNavHeader);
        sharedPrefManager = new SharedPrefManager(this);
        compEmailHeader.setText(sharedPrefManager.getEmailofComp().toString());
        compNameHeader.setText(sharedPrefManager.getNameofComp().toString());
    }

}