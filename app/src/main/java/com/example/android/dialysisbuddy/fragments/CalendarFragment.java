package com.example.android.dialysisbuddy.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.dialysisbuddy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alfredchang on 2018-09-25.
 */

public class CalendarFragment extends Fragment {

    @BindView(R.id.task) EditText mTask;
    @BindView(R.id.time) TextView mTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_calendar_main, container, false);

        ButterKnife.bind(this, rootView);
        setupTimeClickListener();

        return rootView;
    }

    private void setupTimeClickListener() {
        mTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
