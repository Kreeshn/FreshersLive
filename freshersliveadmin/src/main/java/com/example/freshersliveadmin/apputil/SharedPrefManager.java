package com.example.freshersliveadmin.apputil;

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
        return sharedPreferences.getBoolean("isAdminlogin", false);
    }

    public void updateAdminLoginStatus(Boolean status){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isAdminlogin", status);
        editor.apply();
    }

    public void saveidofAdmin(int id){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("idofadmin",id);
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
