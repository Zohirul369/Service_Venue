package com.example.service_venue.adapter;

import android.annotation.SuppressLint;
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
public class RequestAdapter extends FirebaseRecyclerAdapter<ViewModel, RequestAdapter.myViewHolder> {

    public RequestAdapter(@NonNull FirebaseRecyclerOptions<ViewModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") final int position, @NonNull ViewModel model) {
        holder.cName.setText(model.getcName());
        holder.cWorkTitle.setText(model.getcWorkTitle());
        holder.cDate.setText(model.getcDate());




        Glide.with(holder.img.getContext())
                .load(model.getcImage())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);


        holder.view_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.activity_order_first_page))
                        .setExpanded(true,1000)
                        .create();



            }
        });

    }

    @NonNull
    @Override
    public RequestAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myViewHolder(view);
    }
    class myViewHolder extends RecyclerView.ViewHolder{
        CircleImageView img;
        TextView cName, cWorkTitle, cDate;

        Button view_order;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (CircleImageView)itemView.findViewById(R.id.c_imageview);
            cName = (TextView)itemView.findViewById(R.id.cname);
            cWorkTitle = (TextView)itemView.findViewById(R.id.worktitle);
            cDate = (TextView)itemView.findViewById(R.id.cdate);

            view_order = (Button) itemView.findViewById(R.id.btn_view_order);


        }
    }
}
