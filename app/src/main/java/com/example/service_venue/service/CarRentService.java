package com.example.service_venue.service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.service_venue.R;
import com.example.service_venue.ViewModel;
import com.example.service_venue.adapter.CarRentAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class CarRentService extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CarRentAdapter carRentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_rent_service);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ViewModel> options =
                new FirebaseRecyclerOptions.Builder<ViewModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("service").child("carRent"), ViewModel.class)
                        .build();

        carRentAdapter = new CarRentAdapter(options);
        recyclerView.setAdapter(carRentAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        carRentAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        carRentAdapter.stopListening();
    }
}