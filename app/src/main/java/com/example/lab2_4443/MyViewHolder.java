package com.example.lab2_4443;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
//Needed to display on RecyclerView because it caches views to avoid inflating the screen
//Not required in detailed activity as we only display one screen
public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView titleView, descView;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.image);
        titleView = itemView.findViewById(R.id.title);
        descView = itemView.findViewById(R.id.descShort);

    }
}
