package com.example.pushnotification;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    private static final String SHARED_PREF_NAME = "fcmhared";
    private static final String TOKEN = "token";

    private static Context mContext;
    private static SharedPrefManager mSharedPrefManager;

    private SharedPrefManager(Context context) {
        mContext = mContext;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mSharedPrefManager == null)
            mSharedPrefManager = new SharedPrefManager(context);
        return mSharedPrefManager;
    }

    public boolean storeToken(String token) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOKEN,token);
        editor.apply();
        return true;
    }

    public  String getToken(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(TOKEN,null);
    }
}
