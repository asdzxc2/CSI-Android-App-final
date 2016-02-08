package com.dtu.csi.csi_dtu.fragments;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dtu.csi.csi_dtu.CommonRecycleAdapter;
import com.dtu.csi.csi_dtu.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EventDetailsFragment extends Fragment {
    static HashMap<String, Event> events = new HashMap<>();
    String eventName;
    TextView description, contact;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.event_description, null);
        setUpView(root);
        try {
            eventName = getArguments().getString("name");
            description = (TextView) root.findViewById(R.id.event_detail);
            contact = (TextView) root.findViewById(R.id.event_contact);
            Event event = events.get(eventName);
            description.setText(event.description);
            if(event.contact.length() == 0)
                contact.setText(getString(R.string.contact_1));
            else
                contact.setText(event.contact);
            contact.setPaintFlags(contact.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            contact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Intent.ACTION_DIAL).setData(
                            Uri.parse(
                                    "tel:" +
                                            contact.getText().toString()
                                                    .substring(contact.getText().toString().indexOf(":")).trim())));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return root;
    }
    static void generateEvents() {
        events.put("code golf", new Event("Code Golf", "The lesser the better! A solution to the problem is great, but a shorter solution is even better, so\n" +
                "write less to win more! Write a code in minimum characters for a problem on SPOJ and the less\n" +
                "you write the more you score…\n", "Shubham : +919818729998"));
        events.put("cryptex", new Event("Cryptex", "A tad bit of common sense coupled with good observation is what all needed for Cryptex, the\n" +
                "online code breaking event…Kind of treasure hunt, dedicated to testing not only your general\n" +
                "knowledge, but also lateral thinking skills…Ready to challenge the Sherlock hidden inside\n" +
                "you…\n", ""));
        events.put("neuvo gengo", new Event("Neuvo Gengo", "Coding, REDEFINED… No C/ C++/ Java…New problem and a new programming language.\n" +
                "Same logic but code it in new syntax ,are you up for this challenge?\n", ""));
        events.put("cranium", new Event("Cranium", "The battle for all the CODERS on the biggest coding battleground the CODECHEF/SPOJ ...An\n" +
                "online programming contest which gives you an opportunity to flaunt your coding skills…", ""));
        events.put("znapz", new Event("Znapz", "Have you got the skill to capture a moment in a frame? Yes? Then it’s time to use your fancy\n" +
                "camera and photography skills to win...ZNAPZ is an online photography competition in which a\n" +
                "theme will be provided on which the contestants have to click pictures and let your pictures do\n" +
                "the talking…", ""));
        events.put("pancratium", new Event("Pancratium", "Is virtual reality your reality? Pancratium,the LAN gaming event, with games like FIFA, counter\n" +
                "strike, NFS etc.Fierce competition and gaming at a new level…\n", "Shashank : +918130017294"));
        events.put("troll-it", new Event("Troll - It !", "Trolls, the best way to showcase humor…That natural humor and a little bit of artistic skills is all\n" +
                "that is required to ace at this competition…Get set to exhibit your witty one-liners here!\n", ""));
        events.put("mathrix", new Event("Mathrix", "A math quiz and a brain game for those who love numbers!\n" +
                "Logical thinking, speed, accuracy and love for mathematics is all that is required to be the\n" +
                "champion of Mathrix…", ""));
        events.put("sudo code", new Event("Sudo Code", "An exhilarating combination of SUDOKU and CODING…Nine output based questions in\n" +
                "C/C++ , a partially filled Sudoku...Brush up your programming knowledge to get the output and\n" +
                "tickle the grey matter to complete the puzzle…\n", ""));
        events.put("mind mumble", new Event("Mind Mumble", "A general knowledge quiz for folks who are well versed with the world around them. Mind\n" +
                "mumble holds thrilling twists and turns for those who know it all!\n", ""));
        events.put("smash dub", new Event("Smash Dub", "An exciting online competition for our dubsmash fans and freaks to post their exciting\n" +
                "videos and win exciting prizes..", ""));
    }
    void setUpView(ViewGroup root){
        ButterKnife.bind(this, root);
    }
    public static class Event {
        String name, description, contact;
        public Event(String name, String description, String contact) {
            this.name = name;
            this.description = description;
            this.contact = contact;
        }
    }
}
