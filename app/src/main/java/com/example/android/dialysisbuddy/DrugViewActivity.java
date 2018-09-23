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

    public static final String NAME_RESULT = "name";
    public static final String DOSE_RESULT = "dose";
    public static final String SELECTED = "day";

    private final int REQUEST = 1;
    private final String ERR_MSG = "Something went wrong!";
    private List<Drug> mListOfDrugs = new ArrayList<>();
    private DrugsRecyclerViewAdapter mAdapter = null;

    @BindView(R.id.drugs_recycler_view) RecyclerView mRecyclerView;
    @BindView(R.id.fab) FloatingActionButton mFab;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug_view);
        ButterKnife.bind(this);

        setFabListener();

        mAdapter = new DrugsRecyclerViewAdapter(mListOfDrugs);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Drug drug = null;

        if (resultCode != RESULT_OK) {
            Toast.makeText(this, ERR_MSG, Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUEST) {
            String name = intent.getStringExtra(NAME_RESULT);
            String dose = intent.getStringExtra(DOSE_RESULT);
            int time = intent.getIntExtra(SELECTED, 0);
            drug = new Drug(name, dose, time);

//            if (time == 0) {
//                drug = new Drug(name, dose, 0);
//            } else {
//                drug = new Drug(name, dose, 1);
//            }
        }

        mListOfDrugs.add(drug);
        mAdapter.notifyDataSetChanged();
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
