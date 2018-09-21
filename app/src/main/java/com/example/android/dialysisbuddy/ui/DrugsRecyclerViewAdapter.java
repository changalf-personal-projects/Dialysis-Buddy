package com.example.android.dialysisbuddy.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.dialysisbuddy.R;
import com.example.android.dialysisbuddy.models.Drug;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alfredchang on 2018-09-16.
 */

public class DrugsRecyclerViewAdapter extends RecyclerView.Adapter<DrugsRecyclerViewAdapter.DrugsViewHolder> {

    private final String LOG_TAG = DrugsRecyclerViewAdapter.class.getSimpleName();

    private Context mContext;
    private List<Drug> mListOfDrugs;
    private int counter = 0;

    public DrugsRecyclerViewAdapter(List<Drug> listOfDrugs) {
        mListOfDrugs = listOfDrugs;
    }

    @Override
    public DrugsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.drug_row, parent, false);
        DrugsViewHolder viewHolder = new DrugsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DrugsViewHolder holder, int position) {
        Drug drug = mListOfDrugs.get(position);
        onBindDrugIcon(holder);
        onBindDrugName(holder, drug);
        onBindDrugDose(holder, drug);
        onBindDrugFrequency(holder);
    }

    private void onBindDrugIcon(DrugsViewHolder holder) {
        if (counter >= 3) {
            counter = 0;
        }

        if (counter == 0) {
            holder.mIcon.setImageResource(R.mipmap.round_pill);
            counter++;
        } else if (counter == 1) {
            holder.mIcon.setImageResource(R.mipmap.bullseye_pill);
            counter++;
        } else {
            holder.mIcon.setImageResource(R.mipmap.double_pill);
            counter++;
        }
    }

    private void onBindDrugName(DrugsViewHolder holder, Drug drug) {
        holder.mName.setText(drug.getName());
    }

    private void onBindDrugDose(DrugsViewHolder holder, Drug drug) {
        holder.mDose.setText(drug.getDosage());
    }

    private void onBindDrugFrequency(DrugsViewHolder holder) {
        holder.mDayIcon.setImageResource(R.mipmap.day_off);
        holder.mNightIcon.setImageResource(R.mipmap.night_off);
    }

    @Override
    public int getItemCount() {
        return mListOfDrugs.size();
    }

    public class DrugsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.drug_icon) ImageView mIcon;
        @BindView(R.id.name) TextView mName;
        @BindView(R.id.dosage) TextView mDose;
        @BindView(R.id.day_icon) ImageView mDayIcon;
        @BindView(R.id.night_icon) ImageView mNightIcon;

        public DrugsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
