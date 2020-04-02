package com.example.projectuts;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectuts.adapters.menuAdapter;
import com.example.projectuts.models.TeamMenu;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        RecyclerView teamsView = findViewById(R.id.rv_teams);

        List<TeamMenu> teams = new ArrayList<>();
        teams.add(new TeamMenu("https://savoryspin.com/wp-content/uploads/2018/01/Easy-Oatmeal-Pancakes.jpg", "Pancakes"));
        teams.add(new TeamMenu("https://www.tasteofhome.com/wp-content/uploads/2018/01/Puff-Pastry-Danishes_EXPS_SDON17_139153_B06_28_5b-696x696.jpg", "Puff Pastry"));
        teams.add(new TeamMenu("https://savoryspin.com/wp-content/uploads/2017/12/Easy-Spiced-Potato-Puff-Pastry-Baskets.jpg", "Spiced Potato"));

        menuAdapter adapter = new menuAdapter(this, teams);
        teamsView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        teamsView.setLayoutManager(layoutManager);
    }
}
