package com.example.android.dialysisbuddy.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.android.dialysisbuddy.R;
import com.example.android.dialysisbuddy.activities.CalendarActivity;
import com.example.android.dialysisbuddy.adapters.DatesRecyclerViewAdapter;
import com.example.android.dialysisbuddy.models.Appointment;

import java.util.ArrayList;
import java.util.List;

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

    private final String LOG_TAG = AppointmentsFragment.class.getSimpleName();
    private final String ERR_MSG = "Something went wrong!";
    private final int REQUEST = 1;

    private String mDate;
    private DatesRecyclerViewAdapter mDatesRecyclerViewAdapter;
    private List<Appointment> mListOfAppointments;

    @BindView(R.id.calendar) CalendarView mCalendar;
    @BindView(R.id.appointments_recyclerview) RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        super.onCreateView(inflater, parent, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_appointments_main, parent, false);
        mListOfAppointments = new ArrayList<>();

        ButterKnife.bind(this, rootView);
        setCalendarClickListener();
        setupAdapter();
        setupAnimator();

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
            addAppointmentToList(task, time);
        }
    }

    private void setupAdapter() {
        mDatesRecyclerViewAdapter = new DatesRecyclerViewAdapter(mListOfAppointments);
        mRecyclerView.setAdapter(mDatesRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,
                false));
    }

    private void setupAnimator() {
        DefaultItemAnimator animator = new DefaultItemAnimator() {
            @Override
            public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder) {
                return true;
            }
        };
        mRecyclerView.setItemAnimator(animator);
    }

    private void addAppointmentToList(String task, String time) {
        Appointment appointment = new Appointment(task, time, mDate);
        Log.v(LOG_TAG, "Debugging appointment: " + task + ": " + time + ": " + mDate);
        mListOfAppointments.add(appointment);
        Log.v(LOG_TAG, "The appointment: " + mListOfAppointments.get(0));
        mDatesRecyclerViewAdapter.notifyDataSetChanged();
    }

    private void setCalendarClickListener() {
        mCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                mDate = String.valueOf(year) + "/" + String.valueOf(month) + "/" + String.valueOf(dayOfMonth);
                Intent calendarIntent = new Intent(getActivity(), CalendarActivity.class);
                calendarIntent.putExtra(YEAR, year);
                calendarIntent.putExtra(MONTH, month);
                calendarIntent.putExtra(DAY, dayOfMonth);
                startActivityForResult(calendarIntent, REQUEST);
            }
        });
    }
}
