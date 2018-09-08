package com.example.android.dialysisbuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import com.example.android.dialysisbuddy.fragments.VitalsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alfredchang on 2018-01-31.
 */

public class VitalsDialogActivity extends AppCompatActivity {

    private final int MIN_WEIGHT = 0;
    private final int MAX_WEIGHT = 200;
    private final int MIN_BP = 60;
    private final int MAX_BP = 260;
    private final int MIN_PULSE = 20;
    private final int MAX_PULSE = 300;

    @BindView(R.id.weight_picker) NumberPicker mWeightPicker;
    @BindView(R.id.bp_picker) NumberPicker mBpPicker;
    @BindView(R.id.pulse_picker) NumberPicker mPulsePicker;
    @BindView(R.id.ok_button) Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vitals_dialog_main);
        ButterKnife.bind(this);

        setupWeightPicker();
        setupBpPicker();
        setupPulsePicker();
        onClickNumPicker();
        listenOkButton();
    }

    private void listenOkButton() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(VitalsFragment.WEIGHT_RESULT, mWeightPicker.getValue());
                resultIntent.putExtra(VitalsFragment.BP_RESULT, mBpPicker.getValue());
                resultIntent.putExtra(VitalsFragment.PULSE_RESULT, mPulsePicker.getValue());
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    private void setupWeightPicker() {
        mWeightPicker.setMinValue(MIN_WEIGHT);
        mWeightPicker.setMaxValue(MAX_WEIGHT);
        mWeightPicker.setWrapSelectorWheel(true);
    }

    private void setupBpPicker() {
        mBpPicker.setMinValue(MIN_BP);
        mBpPicker.setMaxValue(MAX_BP);
        mBpPicker.setWrapSelectorWheel(true);
    }

    private void setupPulsePicker() {
        mPulsePicker.setMinValue(MIN_PULSE);
        mPulsePicker.setMaxValue(MAX_PULSE);
        mPulsePicker.setWrapSelectorWheel(true);
    }

    private void onClickNumPicker() {
        mWeightPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                numberPicker.setValue(i1);
            }
        });
        mBpPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                numberPicker.setValue(i1);
            }
        });
        mPulsePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                numberPicker.setValue(i1);
            }
        });
    }
}
