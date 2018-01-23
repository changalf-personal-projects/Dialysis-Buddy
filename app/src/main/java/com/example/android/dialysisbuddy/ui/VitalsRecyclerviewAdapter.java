package com.example.android.dialysisbuddy.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.dialysisbuddy.R;
import com.example.android.dialysisbuddy.models.Vitals;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alfredchang on 2018-01-20.
 */

public class VitalsRecyclerviewAdapter extends RecyclerView.Adapter<VitalsRecyclerviewAdapter.VitalsViewHolder> {

    private final String LOG_TAG = VitalsRecyclerviewAdapter.class.getSimpleName();

    List<Vitals> mListOfVitals;

    public VitalsRecyclerviewAdapter(List<Vitals> listOfVitals) {
        mListOfVitals = listOfVitals;
    }

    @Override
    public VitalsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int vitalsLayoutId = R.layout.vitals_item;
        View view = LayoutInflater.from(parent.getContext()).inflate(vitalsLayoutId, parent, false);
        VitalsViewHolder viewHolder = new VitalsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VitalsViewHolder holder, int position) {
        Vitals vitals = mListOfVitals.get(position);
        holder.mVitalsDateBox.setImageResource(R.drawable.date);
        holder.mWeight.setText(String.valueOf(vitals.getWeight()));
    }

    @Override
    public int getItemCount() {
        return mListOfVitals.size();
    }

    public class VitalsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.vitals_date_box)
        ImageView mVitalsDateBox;

        @BindView(R.id.weight)
        TextView mWeight;

        public VitalsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
