package com.example.projectuts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projectuts.adapters.menuAdapter;
import com.example.projectuts.models.TeamMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        RecyclerView teamsView = findViewById(R.id.rv_teams);

        List<TeamMenu> teams = new ArrayList<>();
        teams.add(new TeamMenu("https://savoryspin.com/wp-content/uploads/2018/01/Easy-Oatmeal-Pancakes.jpg", "Vegetarian"));
        teams.add(new TeamMenu("https://www.tasteofhome.com/wp-content/uploads/2018/01/Puff-Pastry-Danishes_EXPS_SDON17_139153_B06_28_5b-696x696.jpg", "Dessert"));
        teams.add(new TeamMenu("https://savoryspin.com/wp-content/uploads/2017/12/Easy-Spiced-Potato-Puff-Pastry-Baskets.jpg", "Appetizers"));
        teams.add(new TeamMenu("https://savoryspin.com/wp-content/uploads/2017/11/Salmon-Spinach-Burgers-Gluten-Free.jpg", "Snack"));

        menuAdapter adapter = new menuAdapter(this, teams);
        teamsView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        teamsView.setLayoutManager(layoutManager);
    }

}
