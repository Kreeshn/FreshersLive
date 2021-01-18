package com.example.freshersliveadmin.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.freshersliveadmin.R;
import com.example.freshersliveadmin.apputil.SharedPrefManager;
import com.example.freshersliveadmin.model.AdminLoginResponse;
import com.example.freshersliveadmin.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminLoginActivity extends AppCompatActivity {
    EditText etcompEmailLogin, etcompPassLogin;
    Button btnLogin;
    SharedPrefManager sharedPrefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        sharedPrefManager = new SharedPrefManager(this);
        etcompEmailLogin = (EditText)findViewById(R.id.etCompEmailLogin);
        etcompPassLogin = (EditText)findViewById(R.id.etCompPassLogin);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAdminLogin();
            }
        });
    }

    private void performAdminLogin() {
        String adEmail = etcompEmailLogin.getText().toString().trim();
        String adPass = etcompPassLogin.getText().toString().trim();

        if(adEmail.isEmpty()){
            etcompEmailLogin.requestFocus();
            etcompEmailLogin.setError("Enter Email");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(adEmail).matches()){
            etcompEmailLogin.requestFocus();
            etcompEmailLogin.setError("Enter Valid Email");
            return;
        }
        if(adPass.isEmpty()){
            etcompPassLogin.requestFocus();
            etcompPassLogin.setError("Enter Password");
            return;
        }

        Call<AdminLoginResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .adminLogin(adEmail,adPass);
        call.enqueue(new Callback<AdminLoginResponse>() {
            @Override
            public void onResponse(Call<AdminLoginResponse> call, Response<AdminLoginResponse> response) {
                AdminLoginResponse adminLoginResponse = response.body();
                if (response.isSuccessful()){
                    if(adminLoginResponse.getError().equals("200")){
                        sharedPrefManager.updateAdminLoginStatus(true);
                        sharedPrefManager.saveidofAdmin(adminLoginResponse.getAid());
                        sharedPrefManager.saveNameofAdmin(adminLoginResponse.getA_name());
                        sharedPrefManager.saveEmailofAdmin(adminLoginResponse.getA_email());
                        Intent intent = new Intent(AdminLoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(AdminLoginActivity.this, adminLoginResponse.getMessage() ,Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(AdminLoginActivity.this,adminLoginResponse.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(AdminLoginActivity.this,adminLoginResponse.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AdminLoginResponse> call, Throwable t) {
                Toast.makeText(AdminLoginActivity.this, t.getMessage() ,Toast.LENGTH_SHORT).show();
            }
        });
    }
    protected void onStart() {
        super.onStart();
        if(sharedPrefManager.isCompLogin()){
            Intent intent = new Intent(AdminLoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

}