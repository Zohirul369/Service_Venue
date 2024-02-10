package com.example.service_venue.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.service_venue.R;
import com.example.service_venue.ViewModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlumberAdapter extends FirebaseRecyclerAdapter<ViewModel, PlumberAdapter.MyViewHolder> {

    private Context context;

    // Constructor
    public PlumberAdapter(@NonNull FirebaseRecyclerOptions<ViewModel> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull PlumberAdapter.MyViewHolder holder, final int position, @NonNull ViewModel model) {
        holder.vname.setText(model.getVname());
        holder.rate.setText(model.getRate());
        holder.rating.setText(model.getRating());
        holder.distance.setText(model.getDistance());

        // Load image using Glide
        Glide.with(holder.img.getContext())
                .load(model.getVimage())
                .placeholder(com.google.firebase.storage.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark)
                .into(holder.img);


        holder.view_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true, 1400)
                        .create();

                View view = dialogPlus.getHolderView();

                dialogPlus.show();

            }
        });

    }

    @NonNull
    @Override
    public PlumberAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item in the RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_item, parent, false);
        return new MyViewHolder(view);
    }

    // ViewHolder class
    static class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView img;
        TextView vname, rating, distance, rate;
        Button view_order;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize views
            img = itemView.findViewById(R.id.v_imageview);
            vname = itemView.findViewById(R.id.vname);
            rating = itemView.findViewById(R.id.rating);
            distance = itemView.findViewById(R.id.distance);
            rate = itemView.findViewById(R.id.rate);

            view_order = itemView.findViewById(R.id.view_order);
        }
    }
}
