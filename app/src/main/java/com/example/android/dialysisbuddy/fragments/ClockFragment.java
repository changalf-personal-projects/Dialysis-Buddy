package com.example.android.dialysisbuddy.fragments;

import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import android.text.format.DateFormat;

/**
 * Created by alfredchang on 2018-09-28.
 */

public class ClockFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    private final int HOUR = 12;
    private final int MINUTE = 0;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new TimePickerDialog(getActivity(), this, HOUR, MINUTE, DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {

    }
}
