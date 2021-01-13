package com.example.fresherslivecompany.retrofitutil;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.fresherslivecompany.R;
import com.example.fresherslivecompany.model.UserComp;

public class SharedPrefManager {
    private static String SHARED_PREF_NAME = "FreshersLiveComp";
    private SharedPreferences sharedPreferences;
    Context context;
    private SharedPreferences.Editor editor;

    public SharedPrefManager(Context context) {
        this.context = context;
    }

    void SaveCompUser(UserComp userComp){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editor.putInt("co_id",userComp.getCo_id());
        editor.putString("co_name",userComp.getCo_name());
        editor.putString("co_email",userComp.getCo_email());
        editor.putBoolean("logged",true);
        editor.apply();
    }

    boolean isLoggedIn(){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("logged", false);
    }

    public UserComp getUserComp(){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return new UserComp(
                sharedPreferences.getInt("co_id",-1),
                sharedPreferences.getString("co_name",null),
                sharedPreferences.getString("co_email",null)
        );
    }

    void logout(){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
