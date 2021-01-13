package com.example.fresherslivecompany.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fresherslivecompany.R;
import com.example.fresherslivecompany.model.CompLoginResponse;
import com.example.fresherslivecompany.retrofitutil.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class compLogin extends AppCompatActivity {
    TextView text_newuser;
    EditText etcompEmailLogin, etcompPassLogin;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp_login);
        etcompEmailLogin = (EditText)findViewById(R.id.etCompEmailLogin);
        etcompPassLogin = (EditText)findViewById(R.id.etCompPassLogin);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCompLogin();
            }
        });
        text_newuser = (TextView) findViewById(R.id.textNewUser);
        text_newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(compLogin.this,compReg.class));
                finish();
            }
        });
    }
    public void performCompLogin(){
        String cemail = etcompEmailLogin.getText().toString().trim();
        String cpass = etcompPassLogin.getText().toString().trim();

        if(cemail.isEmpty()){
            etcompEmailLogin.requestFocus();
            etcompEmailLogin.setError("Enter Email");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(cemail).matches()){
            etcompEmailLogin.requestFocus();
            etcompEmailLogin.setError("Enter Valid Email");
            return;
        }
        if(cpass.isEmpty()){
            etcompPassLogin.requestFocus();
            etcompPassLogin.setError("Enter Password");
            return;
        }

        Call<CompLoginResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .CompLogin(cemail,cpass);
        call.enqueue(new Callback<CompLoginResponse>() {
            @Override
            public void onResponse(Call<CompLoginResponse> call, Response<CompLoginResponse> response) {
                String msg = response.body().getMessage();
                if (response.isSuccessful()){
                    Intent intent = new Intent(compLogin.this, MainActivity.class);
                    intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK|intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    Toast.makeText(compLogin.this,msg,Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(compLogin.this,msg,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CompLoginResponse> call, Throwable t) {
                Toast.makeText(compLogin.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}