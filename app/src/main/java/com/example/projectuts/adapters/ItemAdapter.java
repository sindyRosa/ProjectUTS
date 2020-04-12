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
import com.example.projectuts.models.TeamMenu;
import com.example.projectuts.models.session;

import java.util.ArrayList;
import java.util.List;
//item adapter ini milik Cart
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    public static List<TeamMenu> data;
    LayoutInflater layoutInflater;
    Context c;
    static session session;

    public ItemAdapter(){};

    public ItemAdapter(Context c, List<TeamMenu> data) {
        this.data = data;
        this.c = c;
        this.layoutInflater = LayoutInflater.from(this.c);
    }

    public static void addCart(TeamMenu cart, Context context){
        checkSesion(context);
        if (data == null){
            data = new ArrayList<>();
        }
        if (session.getCart().size() >0 ){
            data = session.getCart();
        }
        data.add(cart);
        session.addCart(data);
    }

    private static void checkSesion(Context context){
        if (session == null){
            session = new session(context);
        }
    }

    public void removeSession(Context context){
        checkSesion(context);
        if (data != null) {
            session.addCart(data);
        }
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.cart_item,parent,false);
        return new ItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {
        TeamMenu teamMenus = data.get(position);
        final int sum = 0;

        holder.namaKue.setText(teamMenus.getName());
        holder.image.setImageResource(teamMenus.getLogo());
        holder.hargaKue.setText(String.valueOf(teamMenus.getHarga()));
        holder.totalHarga.setText(String.valueOf(teamMenus.getJumlahPesan()));
        holder.detailTotal.setText(String.valueOf(teamMenus.getHarga() * teamMenus.getJumlahPesan() ));
    }

    @Override
    public int getItemCount() {
        return (data != null) ? data.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView namaKue, hargaKue ,totalHarga, detailPembelian, detailTotal;
        public ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            namaKue = itemView.findViewById(R.id.text_name);
            image = itemView.findViewById(R.id.image_logo);
            hargaKue = itemView.findViewById(R.id.text_harga);
            detailPembelian = itemView.findViewById(R.id.detail);
            totalHarga = itemView.findViewById(R.id.harga);
            detailTotal = itemView.findViewById(R.id.total_pembelian1);
        }
    }
}
