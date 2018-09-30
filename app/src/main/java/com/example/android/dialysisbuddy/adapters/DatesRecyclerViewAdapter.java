package com.example.android.dialysisbuddy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.dialysisbuddy.R;
import com.example.android.dialysisbuddy.models.Date;

import java.util.List;

/**
 * Created by alfredchang on 2018-09-29.
 */

public class DatesRecyclerViewAdapter extends RecyclerView.Adapter<DatesRecyclerViewAdapter.DatesViewHolder> {

    private List<Date> mListOfDates;

    public DatesRecyclerViewAdapter(List<Date> listOfDates) {
        mListOfDates = listOfDates;
    }

    @Override
    public DatesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.appointment_row, parent, false);

        return new DatesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DatesViewHolder holder, int position) {
        Date date = mListOfDates.get(position);

        bindTask(date);
        bindTime(date);
        bindDate(date);
    }

    private void bindTask(Date date) {

    }

    private void bindTime(Date date) {

    }

    private void bindDate(Date date) {

    }

    @Override
    public int getItemCount() {
        return mListOfDates.size();
    }

    public class DatesViewHolder extends RecyclerView.ViewHolder {

        public DatesViewHolder(View itemView) {
            super(itemView);
        }
    }
}
