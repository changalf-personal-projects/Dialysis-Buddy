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

    public int getDay() {
        return mDay;
    }

    public int getMonth() {
        return mMonth;
    }

    public int getYear() {
        return mYear;
    }
}
