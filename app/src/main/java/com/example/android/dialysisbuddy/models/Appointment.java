package com.example.android.dialysisbuddy.models;

/**
 * Created by alfredchang on 2018-10-01.
 */

public class Appointment {

    private final String LOG_TAG = Appointment.class.getSimpleName();

    private String mTask;
    private String mTime;
    private String mDate;

    public Appointment(String task, String time, String date) {
        mTask = task;
        mTime = time;
        mDate = date;
    }

    public String getTask() {
        return mTask;
    }

    public String getTime() {
        return mTime;
    }

    public String getDate() {
        return mDate;
    }

}
