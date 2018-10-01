package com.example.android.dialysisbuddy.models;

/**
 * Created by alfredchang on 2018-10-01.
 */

public class Appointment {

    private Task mTask;
    private Time mTime;
    private Date mDate;

    public Appointment(Task task, Time time, Date date) {
        mTask = task;
        mTime = time;
        mDate = date;
    }

    public Task getmTask() {
        return mTask;
    }

    public Time getmTime() {
        return mTime;
    }

    public Date getmDate() {
        return mDate;
    }
}
