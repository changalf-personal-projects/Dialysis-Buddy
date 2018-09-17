package com.example.android.dialysisbuddy.models;

import android.widget.ImageView;

/**
 * Created by alfredchang on 2018-09-16.
 */

public class Drug {

    private ImageView mIcon;
    private String mName;
    private String mDosage;
    private ImageView mFrequency;            // May not need this here...

    public Drug(ImageView icon, String name, String dosage, ImageView frequency) {
        mIcon = icon;
        mName = name;
        mDosage = dosage;
        mFrequency = frequency;
    }

    public ImageView getIcon() {
        return mIcon;
    }

    public String getName() {
        return mName;
    }

    public String getDosage() {
        return mDosage;
    }

    public ImageView getFrequency() {
        return mFrequency;
    }
}
