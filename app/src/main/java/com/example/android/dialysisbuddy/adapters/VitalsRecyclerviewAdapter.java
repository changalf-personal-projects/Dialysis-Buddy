package com.example.android.dialysisbuddy.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.dialysisbuddy.R;
import com.example.android.dialysisbuddy.models.Vitals;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alfredchang on 2018-01-20.
 */

public class VitalsRecyclerviewAdapter extends RecyclerView.Adapter<VitalsRecyclerviewAdapter.VitalsViewHolder> {

    private final String LOG_TAG = VitalsRecyclerviewAdapter.class.getSimpleName();

    Map<String, Vitals> mListOfVitals;

    public VitalsRecyclerviewAdapter(Map<String, Vitals> listOfVitals) {
        mListOfVitals = listOfVitals;
    }

    @Override
    public VitalsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int vitalsLayoutId = R.layout.vitals_row;
        View view = LayoutInflater.from(parent.getContext()).inflate(vitalsLayoutId, parent, false);
        VitalsViewHolder viewHolder = new VitalsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VitalsViewHolder holder, int position) {
        Set<String> dates = new LinkedHashSet<>();
        List<String> listOfDates = new ArrayList<>();

        dates.addAll(mListOfVitals.keySet());
        listOfDates.addAll(dates);
        String date = listOfDates.get(position);
        String[] mdy = date.split(" ");
        Vitals vitals = mListOfVitals.get(date);
        bind(holder, mdy, vitals);
    }

    private void bind(VitalsViewHolder holder, String[] mdy, Vitals vitals) {
        holder.mVitalsDateBox.setImageResource(R.drawable.date);
        holder.mMonth.setText(mdy[0]);
        holder.mDay.setText(mdy[1]);
        holder.mYear.setText(mdy[2]);
        holder.mWeight.setText(vitals.getWeight());
        holder.mBloodPressure.setText(vitals.getBloodPressure());
        holder.mPulse.setText(vitals.getPulse());
    }

    @Override
    public int getItemCount() {
        return mListOfVitals.size();
    }

    public class VitalsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.vitals_date_box) ImageView mVitalsDateBox;
        @BindView(R.id.weight) TextView mWeight;
        @BindView(R.id.blood_pressure) TextView mBloodPressure;
        @BindView(R.id.pulse) TextView mPulse;
        @BindView(R.id.month) TextView mMonth;
        @BindView(R.id.day) TextView mDay;
        @BindView(R.id.year) TextView mYear;

        public VitalsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
