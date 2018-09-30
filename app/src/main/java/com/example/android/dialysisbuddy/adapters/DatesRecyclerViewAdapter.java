package com.example.android.dialysisbuddy.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by alfredchang on 2018-09-29.
 */

public class DatesRecyclerViewAdapter extends RecyclerView.Adapter<DatesRecyclerViewAdapter.DatesViewHolder> {

    @Override
    public DatesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(DatesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DatesViewHolder extends RecyclerView.ViewHolder {

        public DatesViewHolder(View itemView) {
            super(itemView);
        }
    }
}
