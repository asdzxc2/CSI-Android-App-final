package com.dtu.csi.csi_dtu.activities;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.dtu.csi.csi_dtu.MainPagerAdapter;
import com.dtu.csi.csi_dtu.R;

import andy.ayaseruri.lib.CircularRevealActivity;
import butterknife.Bind;
import butterknife.ButterKnife;

public class EventActivity extends CircularRevealActivity{
    int position;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.pager)
    ViewPager pager;

    CharSequence tabTitles[] = {"Event 1", "Event 2", "Event 3", "Event 4", "Event 5"};
    MainPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        position = getIntent().getIntExtra("Position", 0);
        ButterKnife.bind(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        setSupportActionBar(toolbar);
        CoordinatorLayout layout;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setUpTabs();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void setUpTabs(){
        adapter =  new MainPagerAdapter(this.getSupportFragmentManager(), tabTitles,tabTitles.length);
        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);
        //setupTabIcons();
    }
}
