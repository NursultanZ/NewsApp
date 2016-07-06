package com.example.acer.newsapp.news_fragments;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;


import java.util.ArrayList;

import com.example.acer.newsapp.News;
import com.example.acer.newsapp.NewsDataBase;
import com.example.acer.newsapp.R;
import com.example.acer.newsapp.image_loader.LazyImageLoadNewsAdapter;

import android.support.v4.app.ListFragment;

public class News24Fragment extends ListFragment {
    LazyImageLoadNewsAdapter adapter;
    ListView list;

    public News24Fragment() {
    }

    final String LOG_TAG = "NewsLog";
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list = (ListView) getActivity().findViewById(R.id.lv);
        adapter = new LazyImageLoadNewsAdapter(getActivity(), getData(),
                getActivity().getApplicationContext());// mStrings
        setListAdapter(adapter);
    }

//    @Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//        String item = (String) list.getAdapter().getItem(position);
//        Intent i = new Intent(getActivity(), ShowPageActivity.class);
//        i.putExtra("mPosition", position);
//        startActivity(i);
//    }

    private ArrayList<News> getData() {
        NewsDataBase db = new NewsDataBase(getActivity()
                .getApplicationContext());
        final ArrayList<News> stringItems = new ArrayList<News>();
        ArrayList<News> pr = (ArrayList<News>) db.getAllNews();
        for (News p : pr) {
            stringItems.add(p);
        }
        return stringItems;
    }
}