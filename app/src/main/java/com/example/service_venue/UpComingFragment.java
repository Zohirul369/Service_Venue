package com.example.service_venue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;


public class UpComingFragment extends Fragment {


    RecyclerView recyclerView;
    AdapterRequestActivity adapterRequestActivity;

    FloatingActionButton floatingActionButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);



        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<ViewModel> options =
                new FirebaseRecyclerOptions.Builder<ViewModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("request"),ViewModel.class)
                        .build();

        adapterRequestActivity = new AdapterRequestActivity(options);
        recyclerView.setAdapter(adapterRequestActivity);


        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        adapterRequestActivity.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapterRequestActivity.stopListening();
    }
}