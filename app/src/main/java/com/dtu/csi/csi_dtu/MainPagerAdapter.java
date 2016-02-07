package com.dtu.csi.csi_dtu;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dtu.csi.csi_dtu.fragments.EventDetailsFragment;

public class MainPagerAdapter extends FragmentStatePagerAdapter{
    CharSequence tabTitles[] = {"Event 1", "Event 2", "Event 3", "Event 4", "Event 5"};
    int numOfTabs;
    public MainPagerAdapter(FragmentManager fm, CharSequence titles[], int numOfTabs) {
        super(fm);
        this.tabTitles = titles;
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        return new EventDetailsFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
