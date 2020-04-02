package com.example.projectuts.models;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import com.squareup.picasso.Picasso;

import java.util.List;

import com.example.projectuts.R;

public class TeamItem extends AbstractItem<TeamItem, TeamItem.ViewHolder> {
    private String logo;
    private String name;

    public TeamItem(String logo, String name) {
        this.logo = logo;
        this.name = name;
    }

    @NonNull
    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.rv_teams;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.menu_item;
    }

    public class ViewHolder extends FastAdapter.ViewHolder<TeamItem> {
        ImageView logoImage;
        TextView nameText;
        public ViewHolder(View itemView) {
            super(itemView);
            logoImage = itemView.findViewById(R.id.menu_image);
            nameText = itemView.findViewById(R.id.menu_name);
        }

        @Override
        public void bindView(TeamItem item, List<Object> payloads) {
            Picasso.get().load(item.logo).into(logoImage);
            nameText.setText(item.name);
        }

        @Override
        public void unbindView(TeamItem item) {
            logoImage.setImageBitmap(null);
            nameText.setText(null);
        }
    }
}
