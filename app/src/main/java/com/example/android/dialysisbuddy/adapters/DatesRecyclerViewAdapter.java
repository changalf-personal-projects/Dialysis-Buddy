package com.example.android.dialysisbuddy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.dialysisbuddy.R;
import com.example.android.dialysisbuddy.models.Appointment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alfredchang on 2018-09-29.
 */

public class DatesRecyclerViewAdapter extends RecyclerView.Adapter<DatesRecyclerViewAdapter.DatesViewHolder> {

    private List<Appointment> mListOfAppointments;

    public DatesRecyclerViewAdapter(List<Appointment> listOfAppointments) {
        mListOfAppointments = listOfAppointments;
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
        Appointment appointment = mListOfAppointments.get(position);

        bindTask(appointment.getTask());
        bindTime(appointment.getTime());
        bindDate(appointment.getDate());
    }

    private void bindTask(String task) {

    }

    private void bindTime(String time) {

    }

    private void bindDate(String date) {

    }

    @Override
    public int getItemCount() {
        return mListOfAppointments.size();
    }

    public class DatesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.task) TextView task;
        @BindView(R.id.time) TextView time;
        @BindView(R.id.calendar_icon) ImageView calendarIcon;
        @BindView(R.id.date) TextView date;

        public DatesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
