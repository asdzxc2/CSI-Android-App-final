package com.dtu.csi.csi_dtu.fragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.dtu.csi.csi_dtu.MySingleton;
import com.dtu.csi.csi_dtu.R;
import com.victor.loading.newton.NewtonCradleLoading;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Date;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

public class NewsFragment extends BaseFragment{
    RecyclerView news;
    String[] newsLines = new String[10];
    int[] newsPhotos = new int[10];
    NewtonCradleLoading newton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflateAndBind(inflater, container, R.layout.fragment_news);
        if(!isNetworkAvailable()) {
            ImageView disconnected = (ImageView) rootView.findViewById(R.id.disconnected);
            disconnected.setVisibility(View.VISIBLE);
            return rootView;
        }
        ImageView disconnected = (ImageView) rootView.findViewById(R.id.disconnected);
        disconnected.setVisibility(View.INVISIBLE);
        news = (RecyclerView) rootView.findViewById(R.id.news_list);
        newton = (NewtonCradleLoading) rootView.findViewById(R.id.newton);
        newton.setVisibility(View.GONE);
        Arrays.fill(newsPhotos, R.drawable.bg);
        news.setHasFixedSize(true);
        news.setLayoutManager(new LinearLayoutManager(getContext()));
        requestFeed();
        return rootView;
    }
    public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{
        int[] photos;
        String[] headlines;
        public CustomAdapter (int[] photos, String[] headlines) {
            this.photos = photos;
            this.headlines =  headlines;
        }
        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.news_item, null);
            return new CustomViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position) {
            holder.newsPhoto.setImageResource(photos[position]);
            holder.newsLine.setText(headlines[position]);
            String date = new Date().toString();
            holder.date.setText(date.substring(0, date.indexOf("GMT")).trim());
        }

        @Override
        public int getItemCount() {
            return headlines.length;
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {
            ImageView newsPhoto;
            TextView newsLine, date;
            public CustomViewHolder(View itemView) {
                super(itemView);
                newsPhoto = (ImageView) itemView.findViewById(R.id.news_photo);
                newsLine = (TextView) itemView.findViewById(R.id.news_line);
                date = (TextView) itemView.findViewById(R.id.date);
            }
        }
    }
    public void requestFeed() {
        newton.setVisibility(View.VISIBLE);
        newton.start();
        String url = "http://csidtu.site88.net/";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array = response.getJSONArray("events");
                    for(int i = 0 ; i < array.length() ; i++) {
                        JSONObject object = array.getJSONObject(i);
                        newsLines[i] = object.getString("event");
                        CustomAdapter adapter = new CustomAdapter(newsPhotos, newsLines);
                        ScaleInAnimationAdapter animationAdapter = new ScaleInAnimationAdapter(adapter);
                        animationAdapter.setDuration(1000);
                        news.setAdapter(animationAdapter);
                        newton.stop();
                        newton.setVisibility(View.GONE);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        MySingleton.getInstance(getContext()).addToRequestQueue(request);
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
