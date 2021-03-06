package com.example.projectuts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectuts.adapters.menuAdapter;
import com.example.projectuts.models.TeamMenu;
import com.example.projectuts.models.session;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    private session session;
    int quantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        session = new session(this);
        //logika untuk mengatur apabila telah ada session maka tidak diperlukan untuk melakukan login
        if (!session.isLoggedIn()) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        RecyclerView recyclerView = findViewById(R.id.rv_teams);
        List<TeamMenu> order = new ArrayList<>();
        TeamMenu tm = new TeamMenu(R.drawable.chocolatemintupcakes, "cocolate", 8000);
        order.add(tm);
        tm = new TeamMenu(R.drawable.chouxastry, "choux pastry", 7000);
        order.add(tm);
        tm = new TeamMenu(R.drawable.croissant, "croisant pastry", 10000);
        order.add(tm);

        menuAdapter adapter = new menuAdapter(this, order);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
    public void increment(View view){//perintah tombol tambah
        if(quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1 ;
        display(quantity);
    }
    public void decrement(View view){//perintah tombol tambah
        if (quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);
    }
    private int calculateprice(boolean addwhipedcream,boolean addchocolate){//jumlah pesanan * harga
        int harga=5000;

        if(addwhipedcream){
            harga=harga+1000;//harga tambahan toping
        }

        if (addchocolate){
            harga=harga+2000;
        }

        return quantity * harga;
    }
    private String createOrderSummary(int price, String name, boolean addChocolate, boolean addWhippedCream) {//hasil pemesanan
        String pricemessage=" Nama ="+name;
        pricemessage+="\n add Whipped Cream?"+addWhippedCream;
        pricemessage+="\n add Chocolate?"+addChocolate;
        pricemessage+="\n quantity"+quantity;
        pricemessage+="\n Total Rp"+price;
        pricemessage+="\n Thankyou";
        return  pricemessage;
    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(message);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}
