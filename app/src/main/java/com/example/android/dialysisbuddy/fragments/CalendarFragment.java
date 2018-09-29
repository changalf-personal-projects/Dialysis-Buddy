package com.example.android.dialysisbuddy.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.dialysisbuddy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alfredchang on 2018-09-25.
 */

public class CalendarFragment extends Fragment {

    private static final String CLOCK_ID = "clock";

    @BindView(R.id.task) EditText mTask;
    @BindView(R.id.time) TextView mTime;
    @BindView(R.id.save_button) Button mSaveButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_calendar_main, container, false);

        ButterKnife.bind(this, rootView);
        setupTimeClickListener();
        setupSaveClickListener();

        return rootView;
    }

    private void setupTimeClickListener() {
        mTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogFragment = new ClockFragment();
                dialogFragment.show(getActivity().getSupportFragmentManager(), CLOCK_ID);
            }
        });
    }

    private void setupSaveClickListener() {
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(AppointmentsFragment.TIME, mTime.getText().toString());
                resultIntent.putExtra(AppointmentsFragment.TASK, mTask.getText().toString());
                getActivity().setResult(Activity.RESULT_OK, resultIntent);
                getActivity().finish();
            }
        });
    }

}
