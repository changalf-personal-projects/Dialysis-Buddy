package com.example.android.dialysisbuddy.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.dialysisbuddy.Dispensers;
import com.example.android.dialysisbuddy.DrugViewActivity;
import com.example.android.dialysisbuddy.R;
import com.example.android.dialysisbuddy.ui.GridViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alfredchang on 2018-01-22.
 */

public class DrugsFragment extends Fragment {

    private final String LOG_TAG = DrugsFragment.class.getSimpleName();

    @BindView(R.id.meds_gridview) GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_drugs_main, container, false);

        ButterKnife.bind(this, rootView);

        gridView.setAdapter(new GridViewAdapter(Dispensers.getDispensers(), getActivity()));
        onClickGridView();

        return rootView;
    }

    private void onClickGridView() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v(LOG_TAG, "Position: " + i);
                Intent drugViewIntent = new Intent(getActivity(), DrugViewActivity.class);
                startActivity(drugViewIntent);
            }
        });
    }

}
