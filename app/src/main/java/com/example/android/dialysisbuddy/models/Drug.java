package com.example.android.dialysisbuddy.models;

/**
 * Created by alfredchang on 2018-09-16.
 */

public class Drug {

    private String mName;
    private String mDosage;
    private int mIcon;

    public Drug(String name, String dosage, int icon) {
        mName = name;
        mDosage = dosage;
        mIcon = icon;
    }

    public String getName() {
        return mName;
    }

    public String getDosage() {
        return mDosage;
    }

    public int getIcon() {
        return mIcon;
    }

}
