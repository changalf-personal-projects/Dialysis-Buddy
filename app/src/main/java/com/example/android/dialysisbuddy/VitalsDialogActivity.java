package com.example.android.dialysisbuddy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.NumberPicker;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alfredchang on 2018-01-31.
 */

public class VitalsDialogActivity extends AppCompatActivity {

    @BindView(R.id.main_weight_picker) NumberPicker mMainPicker;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vitals_dialog_main);
        ButterKnife.bind(this);
    }
}
