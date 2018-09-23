package com.example.android.dialysisbuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alfredchang on 2018-09-20.
 */

public class DrugsDialogActivity extends AppCompatActivity {

    private final String LOG_TAG = DrugsDialogActivity.class.getSimpleName();
    private final String DAY = "0";
    private final String NIGHT = "1";

    @BindView(R.id.name) EditText mDrugName;
    @BindView(R.id.dose) EditText mDrugDose;
    @BindView(R.id.day_icon) ImageButton mDayButton;
    @BindView(R.id.night_icon) ImageButton mNightButton;
    @BindView(R.id.confirm) Button mConfirm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drugs_dialog);
        ButterKnife.bind(this);

        listenOkButton();
    }

    private void listenOkButton() {
        mConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent resultIntent = new Intent();
                resultIntent.putExtra(DrugViewActivity.NAME_RESULT, mDrugName.getText().toString());
                resultIntent.putExtra(DrugViewActivity.DOSE_RESULT, mDrugDose.getText().toString());

                mDayButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resultIntent.putExtra(DrugViewActivity.SELECTED, DAY);
                    }
                });

                mNightButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resultIntent.putExtra(DrugViewActivity.SELECTED, NIGHT);
                    }
                });

                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
