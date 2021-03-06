package com.example.projectuts.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import com.example.projectuts.adapters.ItemAdapter;
import com.example.projectuts.R;
import com.example.projectuts.models.TeamMenu;
//menu adapter ini milik order
public class menuAdapter extends RecyclerView.Adapter<menuAdapter.ViewHolder> {

    private static final String ORDER_KEY = "order";
    private Context context;
    private List<TeamMenu> items;
    ArraySaveOrder order;
    ItemAdapter itemAdapter;

    public menuAdapter(Context context, List<TeamMenu> items) {
        this.context = context;
        this.items = items;
        this.order = new ArraySaveOrder(this.items.size());
        itemAdapter = new ItemAdapter();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.order_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Bundle bundle = new Bundle();
        bundle.getParcelable(ORDER_KEY);

        final TeamMenu item = items.get(position);
        holder.imageView.setImageResource(item.getLogo());
        holder.judulkue.setText(item.getName());
        holder.hargakue.setText(String.valueOf(item.getHarga()));
        holder.textOrder.setText(String.valueOf(order.orderSave[position]));

        holder.increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order.orderSave[position] += 1;
                holder.textOrder.setText(String.valueOf(order.orderSave[position]));
            }
        });
        holder.decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order.orderSave[position] -= 1;
                if (order.orderSave[position] < 0) {
                    order.orderSave[position] = 0;
                }
                holder.textOrder.setText(String.valueOf(order.orderSave[position]));
            }
        });
        holder.order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (order.orderSave[position] != 0) {
                    Toast.makeText(context, "Pembelian Sukses", Toast.LENGTH_SHORT).show();

                } else{
                    Toast.makeText(context, "Order minimal 1 item", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    @Override
    public int getItemCount() {
        return (items != null) ? items.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView judulkue, hargakue, textOrder;
        public Button increment, decrement, order;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
           imageView = itemView.findViewById(R.id.image_logo);
            judulkue = itemView.findViewById(R.id.text_name);
            hargakue = itemView.findViewById(R.id.text_harga);
            textOrder = itemView.findViewById(R.id.text_detail);
            increment = itemView.findViewById(R.id.increment);
            decrement = itemView.findViewById(R.id.decrement);
            order = itemView.findViewById(R.id.order);
        }
    }
}
