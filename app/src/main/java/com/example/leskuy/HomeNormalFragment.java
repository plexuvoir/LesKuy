package com.example.leskuy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeNormalFragment extends Fragment implements MapelAdapter.ItemClickListener {
    MapelAdapter adapter;
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home_normal, container, false);
        // data to populate the RecyclerView with
        String[] data = {"Matematika", "IPA", "IPS", "PKN", "KWU", "MetPen", "Agama", "PUX", "PPP", "PAPB"};
        // set up the RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.home_normal_recycler_view);
        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), numberOfColumns));
        adapter = new MapelAdapter(getContext(), data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return rootView;
    }


    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(rootView.getContext(),OrderActivity.class);
        startActivity(intent);
    }

}

