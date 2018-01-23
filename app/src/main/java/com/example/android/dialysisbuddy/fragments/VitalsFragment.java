package com.example.android.dialysisbuddy.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.dialysisbuddy.R;
import com.example.android.dialysisbuddy.models.Vitals;
import com.example.android.dialysisbuddy.ui.VitalsRecyclerviewAdapter;

import java.util.ArrayList;
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

    @BindView(R.id.vitals_recyclerview)
    RecyclerView mVitalsRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.vitals_fragment_main, container, false);
        ButterKnife.bind(this, rootView);
        setupVitalsRecyclerView();
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

        Vitals vitals4 = new Vitals(54.8, "125/66", 55);
        mListOfVitals.add(vitals4);

        mAdapter.notifyDataSetChanged();
    }
}
