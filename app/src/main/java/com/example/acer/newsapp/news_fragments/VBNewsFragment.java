package com.example.acer.newsapp.news_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.newsapp.R;



public class VBNewsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentxml, parent, false);//xml файл
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
    }
}

