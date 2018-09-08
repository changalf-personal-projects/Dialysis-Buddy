package com.example.android.dialysisbuddy.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by alfredchang on 2018-09-08.
 */

public class GridViewAdapter extends BaseAdapter {

    private final int GRID_LIMIT = 6;

    @Override
    public int getCount() {
        return GRID_LIMIT;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
