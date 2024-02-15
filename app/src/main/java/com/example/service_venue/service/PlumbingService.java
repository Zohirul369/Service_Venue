package com.example.service_venue.service;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.service_venue.R;
import com.example.service_venue.ViewModel;
import com.example.service_venue.adapter.PlumberAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlumbingService extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlumberAdapter plumberAdapter;
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

        plumberAdapter = new PlumberAdapter(options);
        recyclerView.setAdapter(plumberAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        plumberAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        plumberAdapter.stopListening();
    }
}
