package com.dtu.csi.csi_dtu.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.dtu.csi.csi_dtu.MainPagerAdapter;
import com.dtu.csi.csi_dtu.R;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.Transition;

import java.util.ArrayList;
import java.util.List;

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
    int numberOfTabs ;
    List<String> listItems = new ArrayList<String>();
    MainPagerAdapter adapter;
    @Bind(R.id.header_activity)
    KenBurnsView header;
    int i = 0;
    int headers[] = {R.drawable.cover1, R.drawable.cover2, R.drawable.cover3, R.drawable.cover4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        numberOfTabs= getIntent().getIntExtra("number_of_events",0);
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
        header.setImageResource(headers[i]);
        header.setTransitionListener(new KenBurnsView.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }
            @Override
            public void onTransitionEnd(Transition transition) {
                i++;
                if(i > 3)
                    i = 0;
                header.setImageResource(headers[i]);
            }
        });
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
        switch (numberOfTabs) {
            case 11:
                listItems.add("CODE GOLF");
                listItems.add("CRYPTEX");
                listItems.add("NEUVO GENGO");
                listItems.add("CRANIUM");
                listItems.add("ZNAPZ");
                listItems.add("PANCRATIUM");
                listItems.add("TROLL-IT");
                listItems.add("MATHRIX");
                listItems.add("SUDO CODE");
                listItems.add("MIND MUMBLE");
                listItems.add("SMASH DUB");
                listItems.add("IDEATE");
                listItems.add("COGITATE");
                listItems.add("THREE LINES OF CODE");
                listItems.add("SWITCH PROGRAMMING");
                listItems.add("TESTING GEEKS");
                listItems.add("MACHINE LEARNING MANIA");
                listItems.add("BUG TRAIL");
                listItems.add("CODEWHIZ");
                listItems.add("DTU GREAT MARATHON");
                listItems.add("SHADES OF MYSTERY");
                listItems.add("CODEFEST");
                listItems.add("PAPER PRESENTATION");
                listItems.add("CONFERENCE");
                break;
        }
        CharSequence[] tabTitles = listItems.toArray(new CharSequence[listItems.size()]);
        adapter =  new MainPagerAdapter(this.getSupportFragmentManager(), tabTitles,listItems.size());
        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);
    }
}
