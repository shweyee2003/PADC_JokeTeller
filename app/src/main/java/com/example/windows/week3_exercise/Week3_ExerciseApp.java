package com.example.windows.week3_exercise;

import android.app.Application;
import android.content.Context;

/**
 * Created by windows on 6/23/2016.
 */
public class Week3_ExerciseApp extends Application {
    public  static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        context=null;
    }

    public static Context getContext() {
        return context;
    }
}
