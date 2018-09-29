package com.example.android.dialysisbuddy;

import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.dialysisbuddy.fragments.ClockFragment;

/**
 * Created by alfredchang on 2018-09-28.
 */

public class ClockActivity extends AppCompatActivity {

    private static final String CLOCK_ID = "clock";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

        startClockFragment();
    }

    private void startClockFragment() {
        DialogFragment dialogFragment = new ClockFragment();
        dialogFragment.show(getSupportFragmentManager(), CLOCK_ID);
    }

}
