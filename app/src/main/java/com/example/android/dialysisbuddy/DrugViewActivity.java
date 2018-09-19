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

        Drug prednisone = new Drug("Prednisone", "1 pill");
        Drug fosamax = new Drug("Fosamax", "2 pills");
        Drug calcium = new Drug("Calcium", "3 pills");
        Drug cipralex = new Drug("Cipralex", "4 pills");
        Drug cellcept = new Drug("Cellcept", "5 pills");

        listOfDrugs.add(prednisone);
        listOfDrugs.add(fosamax);
        listOfDrugs.add(calcium);
        listOfDrugs.add(cipralex);
        listOfDrugs.add(cellcept);

        DrugsRecyclerViewAdapter recyclerViewAdapter = new DrugsRecyclerViewAdapter(listOfDrugs);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }

}
