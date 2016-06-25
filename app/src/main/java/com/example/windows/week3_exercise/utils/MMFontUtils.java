package com.example.windows.week3_exercise.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import com.example.windows.week3_exercise.Week3_ExerciseApp;

/**
 * Created by windows on 6/26/2016.
 */
public class MMFontUtils {
    private static Typeface mmTypeFace;
    static {
        Context context = Week3_ExerciseApp.getContext();
        mmTypeFace = Typeface.createFromAsset(context.getAssets(), "fonts/Zawgyi.ttf");
    }

    public  static  void setMMFont(TextView view){view.setTypeface(mmTypeFace);}


}



