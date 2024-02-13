package com.example.service_venue.service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.service_venue.R;
import com.example.service_venue.ViewModel;
import com.example.service_venue.adapter.PlumberAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class PlumbingService extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlumberAdapter plumberAdapterr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumbing_service);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ViewModel> options =
                new FirebaseRecyclerOptions.Builder<ViewModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("serviceVenue").child("service").child("plumber"), ViewModel.class)
                        .build();

        plumberAdapterr = new PlumberAdapter(options);
        recyclerView.setAdapter(plumberAdapterr);

    }

    @Override
    protected void onStart() {
        super.onStart();
        plumberAdapterr.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        plumberAdapterr.stopListening();
    }
}
