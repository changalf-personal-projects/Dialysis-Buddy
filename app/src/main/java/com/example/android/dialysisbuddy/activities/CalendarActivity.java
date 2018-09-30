package com.example.android.dialysisbuddy.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.dialysisbuddy.R;
import com.example.android.dialysisbuddy.fragments.CalendarFragment;

/**
 * Created by alfredchang on 2018-09-25.
 */

public class CalendarActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container,
                    new CalendarFragment()).commit();
        }
    }
}
