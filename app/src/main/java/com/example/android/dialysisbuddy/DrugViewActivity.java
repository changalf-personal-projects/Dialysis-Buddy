package com.example.android.dialysisbuddy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.dialysisbuddy.models.Drug;
import com.example.android.dialysisbuddy.ui.DrugsRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alfredchang on 2018-09-15.
 */

public class DrugViewActivity extends AppCompatActivity {

    private final String LOG_TAG = DrugViewActivity.class.getSimpleName();

    @BindView(R.id.drugs_recycler_view) RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug_view);
        ButterKnife.bind(this);

        // Test data for recycler adapter.
        List<Drug> listOfDrugs = new ArrayList<>();
        listOfDrugs.add(new Drug("Prednisone", "2 pills"));
        listOfDrugs.add(new Drug("Cellcept", "3 capsules"));
        listOfDrugs.add(new Drug("Fosamax", "1 pill"));
        listOfDrugs.add(new Drug("Sensipar", "1 tablet"));
        listOfDrugs.add(new Drug("Calcium carbonate", "2 pills"));

        DrugsRecyclerViewAdapter recyclerViewAdapter = new DrugsRecyclerViewAdapter(listOfDrugs);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }

}
