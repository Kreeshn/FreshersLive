package com.example.freshersliveadmin.apputil;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    private Context context;
    private SharedPreferences sharedPreferences;

    public SharedPrefManager(Context context, SharedPreferences sharedPreferences) {
        this.context = context;
        this.sharedPreferences = sharedPreferences;
    }
    public boolean isCompLogin(){
        return sharedPreferences.getBoolean("isAdminlogin", false);
    }

    public void updateCompLoginStatus(Boolean status){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isAdminlogin", status);
        editor.apply();
    }

    public void saveidofAdmin(String id){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("idofadmin",id);
        editor.apply();
    }
    public void saveEmailofAdmin(String aemail){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("emailofadmin",aemail);
        editor.apply();
    }
    public String getEmailofAdmin(){
        return sharedPreferences.getString("emailofadmin","unknown");
    }
    public int getIdofAdmin(){
        return sharedPreferences.getInt("idofadmin", -1);
    }

}
