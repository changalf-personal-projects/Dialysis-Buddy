package com.example.android.dialysisbuddy.models;

/**
 * Created by alfredchang on 2018-01-20.
 */

public class Vitals {

    private String mWeight;
    private String mBloodPressure;
    private String mPulse;

    public Vitals(String weight, String bloodPressure, String pulse) {
        mWeight = weight;
        mBloodPressure = bloodPressure;
        mPulse = pulse;
    }

    public String getWeight() {
        return mWeight;
    }

    public String getBloodPressure() {
        return mBloodPressure;
    }

    public String getPulse() {
        return mPulse;
    }

}
