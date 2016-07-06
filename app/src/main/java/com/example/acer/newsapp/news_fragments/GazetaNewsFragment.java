package com.example.acer.newsapp.news_fragments;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.acer.newsapp.News;
import com.example.acer.newsapp.NewsDataBase;
import com.example.acer.newsapp.R;
import com.example.acer.newsapp.image_loader.LazyImageLoadNewsAdapter;

import java.util.ArrayList;

/**
 * Created by dimsob on 24.06.16.
 */

public class GazetaNewsFragment extends ListFragment {
    LazyImageLoadNewsAdapter adapter;
    ListView list;

    public GazetaNewsFragment() {
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
