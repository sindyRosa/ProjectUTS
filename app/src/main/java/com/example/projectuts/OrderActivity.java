package com.example.projectuts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectuts.adapters.menuAdapter;
import com.example.projectuts.models.TeamMenu;
import com.example.projectuts.models.session;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    private session session;
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
}
