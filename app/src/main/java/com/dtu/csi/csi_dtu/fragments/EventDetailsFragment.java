package com.dtu.csi.csi_dtu.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dtu.csi.csi_dtu.CommonRecycleAdapter;
import com.dtu.csi.csi_dtu.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EventDetailsFragment extends Fragment {

    public static Fragment newInstance() {
        return new EventDetailsFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.event_description, null);
        setUpView(root);
        return root;
    }

    void setUpView(ViewGroup root){
        ButterKnife.bind(this, root);
        //setUPList();
    }

    /*void setUPList(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CommonRecycleAdapter adapter = new CommonRecycleAdapter(createItemList());
        recyclerView.setAdapter(adapter);
    }*/

    /*private List<String> createItemList() {
        List<String> itemList = new ArrayList<>();
        for(int i=0;i<30;i++) {
            itemList.add("Item "+i);
        }
        return itemList;
    }*/
}
