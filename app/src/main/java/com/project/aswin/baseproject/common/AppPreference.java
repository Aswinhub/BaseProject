package com.project.aswin.baseproject.common;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Aswin on 10/21/2016.
 */

public class AppPreference {
    private static AppPreference appPreference;
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private AppPreference(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(Constents.PREFERENCE_NAME, context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static synchronized AppPreference getInstance(Context context) {
        if (appPreference == null) {
            appPreference = new AppPreference(context);
        }
        return appPreference;
    }

    public static void setString(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constents.PREFERENCE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(key, value);
        editor.commit();
    }

    public static void setBoolean(Context context, String key, boolean value) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(Constents.PREFERENCE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(key, value);
        editor.commit();

    }

    public static void getString(Context context, String key) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(Constents.PREFERENCE_NAME, context.MODE_PRIVATE);

        sharedPreferences.getString(key, "");

    }

    public static boolean getBoolean(Context context, String key) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(Constents.PREFERENCE_NAME, context.MODE_PRIVATE);

        return sharedPreferences.getBoolean(key, false);

    }

    public void setString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public void setBoolean(String key, boolean value) {

        editor.putBoolean(key, value);
        editor.commit();
    }

    public String getString(String key) {

        return sharedPreferences.getString(key, "");
    }

    public boolean getBoolean(String key) {

        return sharedPreferences.getBoolean(key, false);
    }

}
