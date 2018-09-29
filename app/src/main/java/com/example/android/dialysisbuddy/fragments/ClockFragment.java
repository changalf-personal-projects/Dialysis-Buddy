package com.example.android.dialysisbuddy.fragments;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.android.dialysisbuddy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alfredchang on 2018-09-28.
 */

public class ClockFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    private final int HOUR = 12;
    private final int MINUTE = 0;

    @BindView(R.id.time) TextView mTime;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        ButterKnife.bind(this, getActivity());
        return new TimePickerDialog(getActivity(), this, HOUR, MINUTE, DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        mTime.setText(hour + ":" + minute);
    }
}
