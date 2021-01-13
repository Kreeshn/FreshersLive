package com.example.fresherslivecompany.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fresherslivecompany.R;
import com.example.fresherslivecompany.model.CompRegResponse;
import com.example.fresherslivecompany.retrofitutil.RetrofitClient;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class compReg extends AppCompatActivity {
    TextView textLogin;
    EditText compName, compEmail, compPass, compContact, compDesc;
    Button btnReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp_reg);
        compName = (EditText)findViewById(R.id.etCompName);
        compEmail = (EditText)findViewById(R.id.etCompEmail);
        compPass = (EditText)findViewById(R.id.etCompPass);
        compContact = (EditText)findViewById(R.id.etCompNum);
        compDesc = (EditText)findViewById(R.id.etCompDesc);
        btnReg = (Button) findViewById(R.id.btnReg);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCompReg();
            }
        });
        textLogin = (TextView) findViewById(R.id.textLogin);
        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(compReg.this, compLogin.class));
                finish();
            }
        });
    }

    public void performCompReg(){
        String cname = compName.getText().toString().trim();
        String cemail = compEmail.getText().toString().trim();
        String cpassword = compPass.getText().toString().trim();
        String ccontact = compContact.getText().toString().trim();
        String cdec = compDesc.getText().toString().trim();

        if(cname.isEmpty()){
            compName.requestFocus();
            compName.setError("Company Name is Mandatory");
            return;
        }
        if(cemail.isEmpty()){
            compEmail.requestFocus();
            compEmail.setError("Email is Mandatory");
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(cemail).matches()){
            compEmail.requestFocus();
            compEmail.setError("Enter Valid Email");
            return;
        }
        if(cpassword.isEmpty()){
            compPass.requestFocus();
            compPass.setError("Password is Mandatory");
            return;
        }
        if(cpassword.length()<8){
            compPass.requestFocus();
            compPass.setError("Palsswors should be Minimun 8 Character");
            return;
        }
        if(ccontact.isEmpty()){
            compContact.requestFocus();
            compContact.setError("Contact Number is Mandatory");
            return;
        }
        if(!Patterns.PHONE.matcher(ccontact).matches()){
            compContact.requestFocus();
            compContact.setError("Enter Valid Number");
            return;
        }
        if(cdec.isEmpty()){
            compDesc.requestFocus();
            compDesc.setError("Company Description is Mandatory");
            return;
        }

        Call<CompRegResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .CompRegistration(cname, cdec, cemail, cpassword, ccontact);
        call.enqueue(new Callback<CompRegResponse>() {
            @Override
            public void onResponse(Call<CompRegResponse> call, Response<CompRegResponse> response) {
                String msg = response.body().getMessage();
                if(response.isSuccessful()){
                    Toast.makeText(compReg.this, msg,Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(compReg.this, msg,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CompRegResponse> call, Throwable t) {
                Toast.makeText(compReg.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}