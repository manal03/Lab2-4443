package com.example.lab2_4443;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//The adapter connects data to actual UI elements
public class SimpleAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context; //Used to inflate our layout (onCreateViewHolder)
    ArrayList<ItemModel> itemModels;

    public  SimpleAdapter(Context context, ArrayList<ItemModel> itemModels){
        this.context = context;
        this.itemModels = itemModels;

    }

    /**
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_rows, parent, false);

        return new MyViewHolder(view);
    }

    /**
     * @param holder
     * @param position
     */

    //This displays the main content XML
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ItemModel item = itemModels.get(position);
        holder.titleView.setText(item.getTitle());
        holder.descView.setText(item.getDescription());
        holder.imageView.setImageResource(item.getImageResId());


        // Placeholder title
        String title = item.getTitle();
        if (title == null || title.trim().isEmpty()) {
            title = "Untitled";
        }

        // Placeholder description
        String desc = item.getDescription();
        if (desc == null || desc.trim().isEmpty()) {
            desc = "No description available.";
        }

        // Placeholder image by using System Icon
        int imgRes = item.getImageResId();
        if (imgRes == 0) {
            imgRes = android.R.drawable.ic_menu_report_image;
        }

        //Binds data to the "detailed activity"
        holder.itemView.setOnClickListener(v -> {
            android.content.Intent intent = new android.content.Intent(context, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_TITLE, item.getFullTitle());
            intent.putExtra(DetailActivity.EXTRA_DESC, item.getDetailedDescription());
            intent.putExtra(DetailActivity.EXTRA_IMAGE, item.getImageResId());
            context.startActivity(intent);
        });
    }

    //Recycler view wants to know how many items we want to display
    @Override
    public int getItemCount() {
        return itemModels.size();
    }
}
