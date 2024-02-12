package com.example.service_venue.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.service_venue.R;
import com.example.service_venue.VendorProfile;
import com.example.service_venue.ViewModel;
import com.example.service_venue.confirmOrder.ConfirmOrderActivity;
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

public class CarRentAdapter extends FirebaseRecyclerAdapter<ViewModel, CarRentAdapter.myViewHolder> {

    public CarRentAdapter(@NonNull FirebaseRecyclerOptions<ViewModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CarRentAdapter.myViewHolder holder, @SuppressLint("RecyclerView") final int position, @NonNull ViewModel model) {
        holder.vname.setText(model.getvName());
        holder.rate.setText(model.getvRate());
        holder.rating.setText(model.getvRating());
        holder.distance.setText(model.getvDistance());




        Glide.with(holder.img.getContext())
                .load(model.getvImage())
                .placeholder(R.drawable.logo)
                .circleCrop()
                .error(R.drawable.logo)
                .into(holder.img);

        holder.btn_view_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.activity_vendor_profile))
                        .setExpanded(true, 1400)
                        .create();

                View view = dialogPlus.getHolderView();

                TextView vname = view.findViewById(R.id.vname);
                TextView rating = view.findViewById(R.id.rating);
                TextView distance = view.findViewById(R.id.distance);
                TextView rate = view.findViewById(R.id.rate);
                TextView worktitle = view.findViewById(R.id.worktitle);
                TextView vfname = view.findViewById(R.id.vfname);


                CircleImageView vimage = view.findViewById(R.id.v_imageview); // assuming the ImageView ID is 'image_in_dialog'

                vname.setText(model.getvName());
                rate.setText(model.getvRate());
                distance.setText(model.getvDistance());
                rating.setText(model.getvRating());
                worktitle.setText(model.getServiceName());
                vfname.setText(model.getvName());


                Button btn_book_now = view.findViewById(R.id.btn_book_now);

                Glide.with(view.getContext())
                        .load(model.getvImage())
                        .placeholder(R.drawable.logo) // Placeholder image for Glide
                        .error(R.drawable.logo) // Error image for Glide
                        .circleCrop()
                        .into(vimage); // Load the image into the ImageView in the dialog


                dialogPlus.show();


            }
        });




    }

    @NonNull
    @Override
    public CarRentAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_item, parent, false);
        return new CarRentAdapter.myViewHolder(view);
    }

    static class myViewHolder extends RecyclerView.ViewHolder {
        CircleImageView img;
        TextView vname, rating, distance, rate, worktitle, vfname;
        Button btn_view_profile,btn_book_now;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.v_imageview);
            vname = itemView.findViewById(R.id.vname);
            rating = itemView.findViewById(R.id.rating);
            distance = itemView.findViewById(R.id.distance);
            rate = itemView.findViewById(R.id.rate);
            worktitle = itemView.findViewById(R.id.worktitle);
            vfname = itemView.findViewById(R.id.vfname);
            vfname = itemView.findViewById(R.id.vfname);
            vfname = itemView.findViewById(R.id.vfname);

            btn_view_profile = (Button) itemView.findViewById(R.id.btn_view_profile);
            btn_book_now = (Button) itemView.findViewById(R.id.btn_book_now);
        }
    }
}
