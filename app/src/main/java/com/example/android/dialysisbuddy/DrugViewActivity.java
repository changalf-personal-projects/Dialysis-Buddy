package com.example.android.dialysisbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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
    public static final int REQUEST = 1;

    @BindView(R.id.drugs_recycler_view) RecyclerView mRecyclerView;
    @BindView(R.id.fab) FloatingActionButton mFab;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug_view);
        ButterKnife.bind(this);

        setOnClickListener();

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

    private void setOnClickListener() {
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialogIntent = new Intent(view.getContext(), DrugsDialogActivity.class);
                startActivityForResult(dialogIntent, REQUEST);
            }
        });
    }

}
