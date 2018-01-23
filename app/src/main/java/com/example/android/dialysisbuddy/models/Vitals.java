package com.example.android.dialysisbuddy.models;

/**
 * Created by alfredchang on 2018-01-20.
 */

public class Vitals {

    private double mWeight;
    private String mBloodPressure;
    private int mPulse;

    public Vitals(double weight, String bloodPressure, int pulse) {
        mWeight = weight;
        mBloodPressure = bloodPressure;
        mPulse = pulse;
    }

    public double getWeight() {
        return mWeight;
    }

    public String getBloodPressure() {
        return mBloodPressure;
    }

    public int getPulse() {
        return mPulse;
    }

}
