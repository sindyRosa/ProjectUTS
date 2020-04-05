package com.example.projectuts;

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

public class SettingsActivity extends AppCompatActivity {
    public static final String TRANSACTION_KEY = "TRANSACTION";
    public static final String INDEX_KEY = "INDEX";
    public static final int UPDATE_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        RecyclerView teamsView = findViewById(R.id.rv_teams);

        List<TeamMenu> teams = new ArrayList<>();
        teams.add(new TeamMenu("https://www.handletheheat.com/wp-content/uploads/2020/01/red-velvet-crinkles-cookies-SQUARE-1536x1536.jpg", "RedVelvet Cookies"));
        teams.add(new TeamMenu("https://www.handletheheat.com/wp-content/uploads/2019/12/Crispy-Gingersnap-Cookies-SQUARE-1536x1536.jpg", "Gingerbread Cookies"));
        teams.add(new TeamMenu("https://www.handletheheat.com/wp-content/uploads/2019/11/Silpat-vs-Parchment-Paper-03.jpg", "Silpat Cookies"));
        teams.add(new TeamMenu("https://www.handletheheat.com/wp-content/uploads/2015/12/Chocolate-Coconut-Cookies-Square.jpg", "Chocolate Coconut Cookies"));
        teams.add(new TeamMenu("https://www.handletheheat.com/wp-content/uploads/2014/10/Peanut-Butter-Chocolate-Chip-Cookies-SQUARE.jpg", "Peanut Chocolate Cookies"));
        teams.add(new TeamMenu("https://www.handletheheat.com/wp-content/uploads/2013/12/turtle-thumbprint-cookies-SQUARE.jpg", "Turtle Thumbprint Cookies"));
        teams.add(new TeamMenu("https://www.handletheheat.com/wp-content/uploads/2018/12/mocha-cookies-SQUARE.jpg", "Mocha Cookies"));
        teams.add(new TeamMenu("https://www.handletheheat.com/wp-content/uploads/2013/07/Oatmeal-Chocolate-Chip-Cookies-01.jpg", "Chocolate Chip Cookies"));
        teams.add(new TeamMenu("https://www.handletheheat.com/wp-content/uploads/2017/11/Hot-Cocoa-Cookies-Square.jpg", "Cocoa Cookies"));
        teams.add(new TeamMenu("https://www.handletheheat.com/wp-content/uploads/2016/02/Peanut-Butter-Snickerdoodles-Square.jpg", "Peanut Butter Cookies"));

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
