package com.example.android.dialysisbuddy.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.dialysisbuddy.R;
import com.example.android.dialysisbuddy.models.Drug;

import java.util.List;

/**
 * Created by alfredchang on 2018-09-16.
 */

public class DrugsRecyclerViewAdapter extends RecyclerView.Adapter<DrugsRecyclerViewAdapter.DrugsViewHolder> {

    private final String LOG_TAG = DrugsRecyclerViewAdapter.class.getSimpleName();

    private Context mContext;
    private List<Drug> mListOfDrugs;

    public DrugsRecyclerViewAdapter(Context context, List<Drug> listOfDrugs) {
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
        onBindDrugIcon(holder, drug);
    }

    private void onBindDrugIcon(DrugsViewHolder holder, Drug drug) {

    }

    @Override
    public int getItemCount() {
        return mListOfDrugs.size();
    }

    public class DrugsViewHolder extends RecyclerView.ViewHolder {

        public DrugsViewHolder(View itemView) {
            super(itemView);
        }
    }
}
