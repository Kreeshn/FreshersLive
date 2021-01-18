package com.example.fresherslivecompany.apputil;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    private Context context;
    private SharedPreferences sharedPreferences;

    public SharedPrefManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("pref_file_key", context.MODE_PRIVATE);
    }

    public boolean isCompLogin(){
        return sharedPreferences.getBoolean("isComplogin", false);
    }

    public void updateCompLoginStatus(Boolean status){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isComplogin", status);
        editor.apply();
    }
    public void saveidofComp(String id){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("idofcomp",id);
        editor.apply();
    }

    public void saveNameofComp(String cname){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nameofcomp",cname);
        editor.apply();
    }
    public void saveEmailofComp(String cemail){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("emailofcomp",cemail);
        editor.apply();
    }

    public String getNameofComp(){
        return sharedPreferences.getString("nameofcomp","unknown");
    }
    public String getEmailofComp(){
        return sharedPreferences.getString("emailofcomp","unknown");
    }
    public int getIdofComp(){
        return sharedPreferences.getInt("idofcomp", -1);
    }
}
