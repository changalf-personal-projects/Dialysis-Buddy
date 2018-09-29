package com.example.android.dialysisbuddy.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.android.dialysisbuddy.CalendarActivity;
import com.example.android.dialysisbuddy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alfredchang on 2018-01-22.
 */

public class AppointmentsFragment extends Fragment {

    public static final String YEAR = "year";
    public static final String MONTH = "month";
    public static final String DAY = "day";
    public static final String TIME = "hour";
    public static final String TASK = "task";

    private final String ERR_MSG = "Something went wrong!";
    private final int REQUEST = 1;

    @BindView(R.id.calendar) CalendarView mCalendar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        super.onCreateView(inflater, parent, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_appointments_main, parent, false);

        ButterKnife.bind(this, rootView);
        setCalendarClickListener();

        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (resultCode != Activity.RESULT_OK) {
            Toast.makeText(getActivity(), ERR_MSG, Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUEST) {
            String task = intent.getStringExtra(TASK);
            String time = intent.getStringExtra(TIME);
        }
    }

    private void setCalendarClickListener() {
        mCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                Intent calendarIntent = new Intent(getActivity(), CalendarActivity.class);
                calendarIntent.putExtra(YEAR, year);
                calendarIntent.putExtra(MONTH, month);
                calendarIntent.putExtra(DAY, dayOfMonth);
                startActivityForResult(calendarIntent, REQUEST);
            }
        });
    }
}
