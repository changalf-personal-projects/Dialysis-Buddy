package com.example.android.dialysisbuddy.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.dialysisbuddy.R;
import com.example.android.dialysisbuddy.Utilities;
import com.example.android.dialysisbuddy.models.Appointment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alfredchang on 2018-09-29.
 */

public class DatesRecyclerViewAdapter extends RecyclerView.Adapter<DatesRecyclerViewAdapter.DatesViewHolder> {

    private final String LOG_TAG = DatesRecyclerViewAdapter.class.getSimpleName();

    private List<Appointment> mListOfAppointments;
    private String mDate;
    private String mHour;
    private String mMinute;

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

        bindTask(appointment.getTask(), holder);
        bindTime(appointment.getTime(), holder);
        bindDate(appointment.getDate(), holder);

        if (Utilities.isPastDate(mDate, mHour, mMinute)) {

        }
    }

    private void bindTask(String task, DatesViewHolder holder) {
        holder.task.setText(task);
    }

    private void bindTime(String time, DatesViewHolder holder) {
        String[] hourMinuteArray = time.split(":");

        mHour = hourMinuteArray[0];
        mMinute = hourMinuteArray[1];

        StringBuilder formattedTime = Utilities.formatTime(Integer.parseInt(hourMinuteArray[0]),
                Integer.parseInt(hourMinuteArray[1]));
        holder.time.setText(formattedTime.toString());
    }

    private void bindDate(String date, DatesViewHolder holder) {
        mDate = date;
        holder.date.setText(date);
    }

    @Override
    public int getItemCount() {
        return mListOfAppointments.size();
    }

    public class DatesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.task) TextView task;
        @BindView(R.id.time) TextView time;
        @BindView(R.id.date) TextView date;

        public DatesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
