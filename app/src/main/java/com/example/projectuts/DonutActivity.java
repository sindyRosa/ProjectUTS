package com.example.projectuts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectuts.adapters.menuAdapter;
import com.example.projectuts.models.TeamMenu;
import com.example.projectuts.models.Transaction;
import com.example.projectuts.models.session;

import java.util.ArrayList;
import java.util.List;

public class DonutActivity extends AppCompatActivity {
    public static final String TRANSACTION_KEY = "TRANSACTION";
    public static final String INDEX_KEY = "INDEX";
    public static final int UPDATE_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut);

        RecyclerView teamsView = findViewById(R.id.rv_teams);

        List<TeamMenu> teams = new ArrayList<>();
        teams.add(new TeamMenu("https://www.theflavorbender.com/wp-content/uploads/2014/09/Simpsons-Doughnuts-4140.jpg", "Donut Topping Strawberry"));
        teams.add(new TeamMenu("https://www.theflavorbender.com/wp-content/uploads/2018/01/Mini-Unicorn-Rainbow-Donuts-The-Flavor-Bender-2-11-700x1049.jpg", "Donut Rainbow"));
        teams.add(new TeamMenu("https://www.theflavorbender.com/wp-content/uploads/2015/05/Coffee-Doughnuts-with-Caramelized-White-Chocolate-Pastry-Cream-9373-662x1000.jpg", "Donut with Caramel Coffe"));
        teams.add(new TeamMenu("https://natashaskitchen.com/wp-content/uploads/2019/03/Baked-Donut-Recipe-3-600x900.jpg", "Donuts Filled with Jelly"));
        teams.add(new TeamMenu("https://www.theflavorbender.com/wp-content/uploads/2016/10/Cardamom-Blueberry-Glazed-Doughnuts-4374.jpg", "Blueberry Glazed Dounut"));
        teams.add(new TeamMenu("https://yogaofcooking.co/wp-content/uploads/2019/03/triple-chocolate-donuts-1-693x1024.jpg", "Donut Chocolate"));
        teams.add(new TeamMenu("https://cdn.loveandlemons.com/wp-content/uploads/2019/03/IMG_16654.jpg", "Donut Matcha"));
        teams.add(new TeamMenu("https://s23209.pcdn.co/wp-content/uploads/2017/12/Apple-Cider-DonutsIMG_0588.jpg", "Apple Cider Donut"));
        teams.add(new TeamMenu("https://girlheartfood.com/wp-content/uploads/2018/02/Vanilla-Glazed-Baked-Donuts-Tall.jpg", "Vanilla Glazed Donut"));
        teams.add(new TeamMenu("https://girlheartfood.com/wp-content/uploads/2018/12/Baked-Eggnog-Donuts-Tall-1.jpg", "Eggnog Donut"));

        menuAdapter adapter = new menuAdapter(this, teams);
        teamsView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        teamsView.setLayoutManager(layoutManager);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.cookies) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.cupcakes) {
            Intent intent = new Intent(this, CupcakesActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.brownies) {
            Intent intent = new Intent(this, BrowniesActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.donut) {
            Intent intent = new Intent(this, DonutActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.action_logout) {
            session.logout();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onTransactionClicked(int index, Transaction item) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra(TRANSACTION_KEY, item);
        intent.putExtra(INDEX_KEY, 0);
        startActivityForResult(intent, UPDATE_REQUEST);
    }
}
