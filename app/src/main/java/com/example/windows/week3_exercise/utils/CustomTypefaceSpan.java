package com.example.windows.week3_exercise.utils;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

/**
 * Created by windows on 6/26/2016.
 */
public class CustomTypefaceSpan extends TypefaceSpan {
    private  final Typeface newType;

    public CustomTypefaceSpan(String family,Typeface type)
    {
        super(family);
        newType=type;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        applyCustomTypeFace(ds, newType);
    }

    @Override
    public void updateMeasureState(TextPaint paint) {
        applyCustomTypeFace(paint, newType);
    }

    private static void applyCustomTypeFace(Paint paint,Typeface tf){
        int oldstyle;
        Typeface old=paint.getTypeface();
        if(old==null){
            oldstyle=0;
        }else {
            oldstyle=old.getStyle();
        }
        int fake=oldstyle & ~tf.getStyle();
        if((fake & Typeface.BOLD)!=0){
            paint.setFakeBoldText(true);
        }
        if ((fake & Typeface.ITALIC) != 0) {
            paint.setTextSkewX(-0.25f);
        }

        paint.setTypeface(tf);
    }
}
