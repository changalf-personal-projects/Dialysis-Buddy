package com.example.android.dialysisbuddy.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.dialysisbuddy.R;

/**
 * Created by alfredchang on 2018-09-21.
 */

public class DrugViewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_drugs_view, container, false);
        return rootView;
    }
}
