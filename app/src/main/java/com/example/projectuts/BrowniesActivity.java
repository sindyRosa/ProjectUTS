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

public class BrowniesActivity extends AppCompatActivity {
    public static final String TRANSACTION_KEY = "TRANSACTION";
    public static final String INDEX_KEY = "INDEX";
    public static final int UPDATE_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brownies);

        RecyclerView teamsView = findViewById(R.id.rv_teams);

        List<TeamMenu> teams = new ArrayList<>();
        TeamMenu tm = new TeamMenu(R.drawable.chouxastry, "Brownis Activity", 18000);
        teams.add(tm);
        tm = new TeamMenu(R.drawable.croissant, "Chocolate Pappermint", 23000);
        teams.add(tm);
        tm = new TeamMenu(R.drawable.curriedbeef, "Fudgi Brownies", 25000);
        teams.add(tm);
        tm = new TeamMenu(R.drawable.danishpastry, "Fudgi Pecan", 20000);
        teams.add(tm);

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
        if (id == R.id.google_maps_key) {
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.action_logout) {
            session.logout();
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
            finish();
            return true;
        }

        return false;
    }
    public void onTransactionClicked(int index, Transaction item) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(TRANSACTION_KEY, item);
        intent.putExtra(INDEX_KEY, 0);
        startActivityForResult(intent, UPDATE_REQUEST);
    }
}
