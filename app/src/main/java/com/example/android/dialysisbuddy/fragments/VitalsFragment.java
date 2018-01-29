package com.example.android.dialysisbuddy.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.dialysisbuddy.R;
import com.example.android.dialysisbuddy.models.Vitals;
import com.example.android.dialysisbuddy.ui.VitalsRecyclerviewAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alfredchang on 2018-01-20.
 */

public class VitalsFragment extends Fragment {

    private final String LOG_TAG = VitalsFragment.class.getSimpleName();

    private List<Vitals> mListOfVitals = new ArrayList<>();
    private VitalsRecyclerviewAdapter mAdapter;

    @BindView(R.id.vitals_recyclerview) RecyclerView mVitalsRecyclerView;
    @BindView(R.id.fab) FloatingActionButton mFab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.vitals_fragment_main, container, false);
        ButterKnife.bind(this, rootView);
        setupVitalsRecyclerView();

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("MMM d yyyy");
                int date = cal.get(Calendar.YEAR) + cal.get(Calendar.MONTH) + cal.get(Calendar.DAY_OF_MONTH);
                String formatDate = sdf.format(date);
                Toast.makeText(getActivity(), formatDate, Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    private void setupVitalsRecyclerView() {
        mAdapter = new VitalsRecyclerviewAdapter(mListOfVitals);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mVitalsRecyclerView.setLayoutManager(layoutManager);
        mVitalsRecyclerView.setAdapter(mAdapter);

        // TEST
        initTest();
    }

    // TEST
    private void initTest() {
        Vitals vitals1 = new Vitals(54.8, "125/66", 55);
        mListOfVitals.add(vitals1);

        Vitals vitals2 = new Vitals(54.8, "125/66", 55);
        mListOfVitals.add(vitals2);

        Vitals vitals3 = new Vitals(54.8, "125/66", 55);
        mListOfVitals.add(vitals3);

        mAdapter.notifyDataSetChanged();
    }
}
