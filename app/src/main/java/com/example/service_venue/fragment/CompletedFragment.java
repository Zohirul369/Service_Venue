package com.example.service_venue.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.service_venue.R;
import com.example.service_venue.ViewModel;
import com.example.service_venue.adapter.RequestAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.FirebaseDatabase;


public class CompletedFragment extends Fragment {

    private RecyclerView recyclerView;
    private RequestAdapter requestAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_completed, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<ViewModel> options =
                new FirebaseRecyclerOptions.Builder<ViewModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("serviceVenue").child("request"), ViewModel.class)
                        .build();

        requestAdapter = new RequestAdapter(options);
        recyclerView.setAdapter(requestAdapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        requestAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        requestAdapter.stopListening();
    }
}

