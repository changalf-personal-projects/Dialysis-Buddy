package com.example.android.dialysisbuddy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.dialysisbuddy.models.Date;

import java.util.List;

/**
 * Created by alfredchang on 2018-09-29.
 */

public class DatesRecyclerViewAdapter extends RecyclerView.Adapter<DatesRecyclerViewAdapter.DatesViewHolder> {

    private List<Date> mListOfDates;
    private Context mContext;

    public DatesRecyclerViewAdapter(List<Date> listOfDates, Context context) {
        mListOfDates = listOfDates;
        mContext = context;
    }

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
