package com.supercoders.androidnotetakingapp;

import android.content.Context;
import android.content.SharedPreferences;

public class StaticUtils {
    public static void StoreLoggedEmail(Context context,String email){
        SharedPreferences sharedPreferences=context.getSharedPreferences("MyPref",0);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("email",email);
        editor.apply();
    }

    public static String getUserEmail(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("MyPref",0);
        return sharedPreferences.getString("email",null);
    }
}
