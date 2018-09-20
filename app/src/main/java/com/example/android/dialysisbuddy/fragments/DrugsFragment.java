package com.example.android.dialysisbuddy.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.android.dialysisbuddy.Dispensers;
import com.example.android.dialysisbuddy.DrugViewActivity;
import com.example.android.dialysisbuddy.R;
import com.example.android.dialysisbuddy.Week;
import com.example.android.dialysisbuddy.ui.GridViewAdapter;
import com.example.android.dialysisbuddy.ui.TextDrawable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alfredchang on 2018-01-22.
 */

public class DrugsFragment extends Fragment {

    private final String LOG_TAG = DrugsFragment.class.getSimpleName();

    @BindView(R.id.meds_gridview) GridView gridView;
    @BindView(R.id.day_of_week) ImageView dayOfWeek;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_drugs_main, container, false);

        ButterKnife.bind(this, rootView);

        for (Week day: Week.values()) {
            dayOfWeek.setImageDrawable(new TextDrawable(day.toString()));
        }

        gridView.setAdapter(new GridViewAdapter(Dispensers.getDispensers(), getActivity()));
        onClickGridView();

        return rootView;
    }

    private void onClickGridView() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent drugViewIntent = new Intent(getActivity(), DrugViewActivity.class);
                startActivity(drugViewIntent);
            }
        });
    }

}
