package com.example.android.dialysisbuddy.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.dialysisbuddy.DrugViewActivity;
import com.example.android.dialysisbuddy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alfredchang on 2018-01-22.
 */

public class DrugsFragment extends Fragment {

    private final String LOG_TAG = DrugsFragment.class.getSimpleName();

    @BindView(R.id.sunday) ImageView mSundayDispenser;
    @BindView(R.id.monday) ImageView mMondayDispenser;
    @BindView(R.id.tuesday) ImageView mTuesdayDispenser;
    @BindView(R.id.wednesday) ImageView mWednesdayDispenser;
    @BindView(R.id.thursday) ImageView mThursdayDispenser;
    @BindView(R.id.friday) ImageView mFridayDispenser;
    @BindView(R.id.saturday) ImageView mSaturdayDispenser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_drugs_main, container, false);

        ButterKnife.bind(this, rootView);
        setOnClickListener();

        return rootView;
    }

    private void setOnClickListener() {
        mSundayDispenser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activateIntent(view);
            }
        });

        mMondayDispenser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activateIntent(view);
            }
        });

        mTuesdayDispenser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activateIntent(view);
            }
        });

        mWednesdayDispenser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activateIntent(view);
            }
        });

        mThursdayDispenser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activateIntent(view);
            }
        });

        mFridayDispenser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activateIntent(view);
            }
        });

        mSaturdayDispenser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activateIntent(view);
            }
        });
    }

    private void activateIntent(View view) {
        Intent drugsIntent = new Intent(getActivity(), DrugViewActivity.class);
        startActivity(drugsIntent);
    }

}
