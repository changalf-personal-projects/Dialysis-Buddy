package com.example.android.dialysisbuddy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.android.dialysisbuddy.fragments.AppointmentsFragment;
import com.example.android.dialysisbuddy.fragments.DrugsFragment;
import com.example.android.dialysisbuddy.fragments.VitalsFragment;
import com.example.android.dialysisbuddy.ui.VitalsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alfredchang on 2018-01-22.
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.fab) FloatingActionButton mFab;
    @BindView(R.id.tab_layout) TabLayout mTabLayout;
    @BindView(R.id.view_pager) ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(mToolbar);
        ButterKnife.bind(this);

        setupViewPager();
        mTabLayout.setupWithViewPager(mViewPager);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager() {
        VitalsAdapter adapter = new VitalsAdapter(getSupportFragmentManager());
        addFragments(adapter);
        addFragmentTitles(adapter);
        mViewPager.setAdapter(adapter);
    }

    private void addFragments(VitalsAdapter adapter) {
        adapter.addFragment(new VitalsFragment());
        adapter.addFragment(new DrugsFragment());
        adapter.addFragment(new AppointmentsFragment());
    }

    private void addFragmentTitles(VitalsAdapter adapter) {
        adapter.addTitle("Vitals");
        adapter.addTitle("Drugs");
        adapter.addTitle("Dates");
    }
}
