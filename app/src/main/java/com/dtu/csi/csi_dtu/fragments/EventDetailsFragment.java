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
    TextView description, contact, link;
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
            link = (TextView) root.findViewById(R.id.link);
            link.setPaintFlags(contact.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            link.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.facebook.com/PhoneixCSIDTU/")));
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
        events.put("ideate", new Event("Ideate", "The software competition and exhibition aims to unravel the hidden innovative software\n" +
                "\n" +
                "developers within us. This is an on the spot competition to display UML diagrams for given case study.", ""));
        events.put("cogitate", new Event("Cogitate", "Brainstorm your mind to prepare a software project plan. Enumerate and examine factor\n" +
                "\n" +
                "affecting a software project like technologies, risk, cost, resources and personnel for given case study.", ""));
        events.put("three lines of code", new Event("Three Lines of Code", "Three lines of code is an exigent event that will be held to challenge your\n" +
                "\n" +
                "spontaneity and flare in debugging and problem solving. Problem solving can involve modifying the \n" +
                "\n" +
                "highlighted three lines of the code or arranging the given modules or segments of program under time \n" +
                "\n" +
                "pressure and make the program work.", ""));
        events.put("switch programming", new Event("Switch Programming", "Cook your own code and have a taste of what your teammate has made for\n" +
                "\n" +
                "you. Provided with a desired output, you and your teammate will code alternatively by switching on \n" +
                "\n" +
                "each intermittent sound of the buzzer.", ""));
        events.put("testing geeks", new Event("Testing Geeks", "Writing code may be sometime easier but analyzing it can be tough. This event\n" +
                "\n" +
                "challenge your software testing ability. So do you have acumen of writing test cases for given code?", ""));
        events.put("line seguidor", new Event("Line Seguidor", "The objective of this contest is for a robot to follow a black line on a white background,\n" +
                "\n" +
                "without losing the line, and navigating several 90 degree turns. The robot to complete the course in \n" +
                "\n" +
                "the shortest period of time while accurately tracking the course line from start to finish wins.", ""));
        events.put("machine learning mania", new Event("Machine Learning Mania", "This competition is about creating an artificial intelligence program that\n" +
                "\n" +
                "could read the data sets, analyse it, self - learn it and then produce the optimized results. A workshop \n" +
                "\n" +
                "will be conducted before the competition about the basics of machine learning.", ""));
        events.put("bug trail", new Event("Bugtrail", "The competitors will be provided with a certain programming codes, they have to find the\n" +
                "\n" +
                "bug and debug all the codes within the specified time.", ""));
        events.put("codewhiz", new Event("Codewhiz", "Codewhiz is an online competitive coding competition of two days that would be\n" +
                "\n" +
                "conducted on CodeChef. The competitors will be provided the problems which they have to solve in a \n" +
                "\n" +
                "specified time limit.", ""));
        events.put("dtu great marathon", new Event("DTU Great Marathon", "Marathon run for DTU students and other college students in which the\n" +
                "\n" +
                "participants have to run through the perimeter of DTU campus, marathon is for boys and girls both.", ""));
        events.put("shades of mystery", new Event("Shades of Mystery", "Shades of Mystery is a quizzing competition containing three types of quiz viz.,\n" +
                "\n" +
                "aptitude quiz, sitcom quiz and sports quiz.", ""));
        events.put("codefest", new Event("CodeFest", "The coding sprint for passionate programmers. Long running coding competition. Do you\n" +
                "\n" +
                "have the stamina to solve 10 problems in 5 hours of code?", ""));
        events.put("paper presentation", new Event("Paper Presentation", "The research paper presentation competition, prefect platform for all the\n" +
                "\n" +
                "researchers to get their work evaluated. If you have done any research work then this is the\n" +
                "\n" +
                "to present up your research paper in front of industrial and professional judge panel.", ""));
        events.put("conference", new Event("Conference", "Bridging the distance between students and industrial professionals, it aims at helping\n" +
                "\n" +
                "the students create a better and thorough perspective regarding the real world and the opportunities \n" +
                "\n" +
                "that it beholds. With talks by industrial experts from various fields, it sure is an enlightening and \n" +
                "\n" +
                "learning experience for everyone who attends.", ""));
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