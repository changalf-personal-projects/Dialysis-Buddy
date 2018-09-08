package com.example.android.dialysisbuddy.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alfredchang on 2018-09-08.
 */

public class GridViewAdapter extends BaseAdapter {

    private final int GRID_LIMIT = 6;

    private List<Integer> mListOfMeds = new ArrayList<Integer>();
    private Context mContext;

    public GridViewAdapter(List<Integer> listOfMeds, Context context) {
        mListOfMeds = listOfMeds;
        mContext = context;
    }

    @Override
    public int getCount() {
        return GRID_LIMIT;
    }

    @Override
    public Object getItem(int position) {
        return mListOfMeds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 120));
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) view;
        }

        imageView.setImageResource(mListOfMeds.get(position));
        return imageView;
    }
}
