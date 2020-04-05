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
        teams.add(new TeamMenu("https://www.theflavorbender.com/wp-content/uploads/2018/02/Fudgy-Brownies-The-Flavor-Bender-9-700x1048.jpg", "Fudgi Brownies"));
        teams.add(new TeamMenu("https://www.theflavorbender.com/wp-content/uploads/2018/10/Fudgy-Pecan-Pie-Bars-1128.jpg", "Fudgi Pecan Brownies"));
        teams.add(new TeamMenu("https://www.theflavorbender.com/wp-content/uploads/2016/12/Chocolate-peppermint-Rice-Krispie-treats-9638.jpg", "Chocolate Pappermint Brownies"));
        teams.add(new TeamMenu("https://www.theflavorbender.com/wp-content/uploads/2015/08/Peanut-butter-Swirled-Fudgy-Chocolate-Brownie-Ice-Cream-Sandwiches-18108.jpg", "Fudgi Chocolate Brownies"));
        teams.add(new TeamMenu("https://i2.wp.com/resepkoki.id/wp-content/uploads/2017/04/Resep-Brownies-Kukus.jpg?fit=1300%2C1300&ssl=1", "Brownies kukus chocolate"));
        teams.add(new TeamMenu("https://www.rbshop.id/wp-content/uploads/2018/12/Brownis-RBSHOP-Rbshop.jpg", "Brownies chocolate Almond"));
        teams.add(new TeamMenu("https://www.handletheheat.com/wp-content/uploads/2014/08/Cosmic-Brownies-3.jpg", "Cosmic Brownies"));
        teams.add(new TeamMenu("https://www.handletheheat.com/wp-content/uploads/2014/06/Ultimate-Gooey-Brownies-04.jpg", "Ultimate Gooey Brownies"));
        teams.add(new TeamMenu("https://www.handletheheat.com/wp-content/uploads/2013/01/Espresso-Brownie-Bites.jpg", "Expresso Brownies"));
        teams.add(new TeamMenu("https://www.handletheheat.com/wp-content/uploads/2015/07/Cookie-Butter-Brownie-Ice-Cream-Sandwiches-03-FS-550x550.jpg", "Brownies Ice Cream Sandwich"));


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
