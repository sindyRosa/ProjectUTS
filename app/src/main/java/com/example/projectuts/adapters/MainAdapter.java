package com.example.projectuts.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectuts.R;
import com.example.projectuts.models.ItemMain;
import com.example.projectuts.models.MainTeam;
import com.example.projectuts.models.TeamMenu;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context context;
    private List<MainTeam> items;

    public MainAdapter(Context context, List<MainTeam> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.menu_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainTeam item = items.get(position);
        //ATUR IMAGE DIBARIS INI, DAPAT MENGGUNAKAN PICASSO ATAU GLIDE
        Picasso.get().load(item.getLogo()).into(holder.logoImage);
        holder.nameText.setText(item.getName());

    }

    @Override
    public int getItemCount() {
        return (items != null) ? items.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView logoImage;
        TextView nameText;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            logoImage = itemView.findViewById(R.id.menu_image);
            nameText = itemView.findViewById(R.id.menu_name);
        }
    }
}
