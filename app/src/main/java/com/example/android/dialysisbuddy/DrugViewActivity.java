package com.example.android.dialysisbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

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

    public final static String NAME_RESULT = "name";
    public final static String DOSE_RESULT = "dose";
    public static final String TIME_RESULT = "time";

    private final int REQUEST = 1;
    private final String ERR_MSG = "Something went wrong!";


    @BindView(R.id.drugs_recycler_view) RecyclerView mRecyclerView;
    @BindView(R.id.fab) FloatingActionButton mFab;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug_view);
        ButterKnife.bind(this);

        setFabListener();

        List<Drug> listOfDrugs = new ArrayList<>();
        DrugsRecyclerViewAdapter recyclerViewAdapter = new DrugsRecyclerViewAdapter(listOfDrugs);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode != RESULT_OK) {
            Toast.makeText(this, ERR_MSG, Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUEST) {

        }
    }

    private void setFabListener() {
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addDrugIntent = new Intent(view.getContext(), DrugsDialogActivity.class);
                startActivityForResult(addDrugIntent, REQUEST);
            }
        });
    }
}
