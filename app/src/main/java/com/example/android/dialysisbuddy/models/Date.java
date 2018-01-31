package com.example.android.dialysisbuddy.models;

/**
 * Created by alfredchang on 2018-01-29.
 */

public class Date {

    private int mDay;
    private int mMonth;
    private int mYear;

    public Date(int day, int month, int year) {
        mDay = day;
        mMonth = month;
        mYear = year;
    }

    public int getmDay() {
        return mDay;
    }

    public int getmMonth() {
        return mMonth;
    }

    public int getmYear() {
        return mYear;
    }
}
