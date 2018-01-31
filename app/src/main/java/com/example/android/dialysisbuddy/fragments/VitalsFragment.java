package com.example.android.dialysisbuddy.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.dialysisbuddy.R;
import com.example.android.dialysisbuddy.Utilities;
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

public class VitalsFragment extends Fragment {

    private final String LOG_TAG = VitalsFragment.class.getSimpleName();
    private final String SPACE = " ";

    private Map<String, Vitals> mListOfVitals = new LinkedHashMap<>();
    private VitalsRecyclerviewAdapter mAdapter;

    @BindView(R.id.vitals_recyclerview) RecyclerView mVitalsRecyclerView;
    @BindView(R.id.fab) FloatingActionButton mFab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.vitals_fragment_main, container, false);
        ButterKnife.bind(this, rootView);
        setupVitalsRecyclerView();
        listenForFabClick();
        return rootView;
    }

    private void listenForFabClick() {
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH) + 1;
                int year = calendar.get(Calendar.YEAR);

                String date = Utilities.formatMonth(month) + SPACE + day + SPACE + year;
                Vitals vitals = new Vitals(60.2, "188/150", 100);
                mListOfVitals.put(date, vitals);

                mAdapter.notifyDataSetChanged();
            }
        });
    }

    private void setupVitalsRecyclerView() {
        mAdapter = new VitalsRecyclerviewAdapter(mListOfVitals);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mVitalsRecyclerView.setLayoutManager(layoutManager);
        mVitalsRecyclerView.setAdapter(mAdapter);
    }
}
