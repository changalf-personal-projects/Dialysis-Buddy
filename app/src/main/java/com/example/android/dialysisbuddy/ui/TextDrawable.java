package com.example.android.dialysisbuddy.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by alfredchang on 2018-09-19.
 */

public class TextDrawable extends Drawable {

    private final float MARGIN = 10f;

    private String mText;
    private Paint mPaint;

    public TextDrawable(String text) {
        mText = text;
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
        mPaint.setAntiAlias(true);
        mPaint.setTextAlign(Paint.Align.LEFT);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawText(mText, MARGIN, MARGIN, mPaint);
    }

    @Override
    public void setAlpha(int a) {
        mPaint.setAlpha(a);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }
}
