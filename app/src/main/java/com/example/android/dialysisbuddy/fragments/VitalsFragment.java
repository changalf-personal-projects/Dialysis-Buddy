package com.example.android.dialysisbuddy.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.android.dialysisbuddy.R;
import com.example.android.dialysisbuddy.Utilities;
import com.example.android.dialysisbuddy.VitalsDialogActivity;
import com.example.android.dialysisbuddy.models.Vitals;
import com.example.android.dialysisbuddy.ui.VitalsRecyclerviewAdapter;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alfredchang on 2018-01-20.
 */

public class VitalsFragment extends Fragment implements NumberPicker.OnValueChangeListener {

    public static final int REQUEST = 1;
    public static final String WEIGHT_RESULT = "weight";
    public static final String BP_RESULT = "blood pressure";
    public static final String PULSE_RESULT = "pulse";

    private final String ACTIVITY_CANCELLED_MESSAGE = "Enter a weight.";
    private final String LOG_TAG = VitalsFragment.class.getSimpleName();
    private final String SPACE = " ";

    private Map<String, Vitals> mListOfVitals = new LinkedHashMap<>();
    private VitalsRecyclerviewAdapter mAdapter;

    @BindView(R.id.vitals_recyclerview) RecyclerView mVitalsRecyclerView;
    @BindView(R.id.fab) FloatingActionButton mFab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_vitals_main, container, false);
        ButterKnife.bind(this, rootView);
        setupVitalsRecyclerView();
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialogIntent = new Intent(getActivity(), VitalsDialogActivity.class);
                startActivityForResult(dialogIntent, REQUEST);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(getContext(), ACTIVITY_CANCELLED_MESSAGE, Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUEST) {
            Calendar calendar = Calendar.getInstance();
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH) + 1;
            int year = calendar.get(Calendar.YEAR);

            int weight = intent.getIntExtra(WEIGHT_RESULT, 0);
            int systolic = intent.getIntExtra(BP_RESULT, 0);
            int pulse = intent.getIntExtra(PULSE_RESULT, 0);

            String date = Utilities.formatMonth(month) + SPACE + day + SPACE + year;
            Vitals vitals = new Vitals("Weight: " + Integer.toString(weight) + " kg",
                    "Heart rate: " + Integer.toString(systolic), "Pulse: " + Integer.toString(pulse) + " beats/min");
            mListOfVitals.put(date, vitals);

            mAdapter.notifyDataSetChanged();

        }
    }

    private void setupVitalsRecyclerView() {
        mAdapter = new VitalsRecyclerviewAdapter(mListOfVitals);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mVitalsRecyclerView.setLayoutManager(layoutManager);
        mVitalsRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {

    }
}
