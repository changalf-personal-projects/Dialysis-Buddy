package com.example.android.dialysisbuddy.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.dialysisbuddy.Dispensers;
import com.example.android.dialysisbuddy.R;
import com.example.android.dialysisbuddy.ui.GridViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alfredchang on 2018-01-22.
 */

public class DrugsFragment extends Fragment {

    @BindView(R.id.meds_gridview) GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.drugs_fragment_main, container, false);

        ButterKnife.bind(this, rootView);

        gridView.setAdapter(new GridViewAdapter(Dispensers.getDispensers(), getActivity()));        // NPE -- gridView.

        return rootView;
    }

}
