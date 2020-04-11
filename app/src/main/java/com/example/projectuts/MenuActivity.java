package com.example.projectuts;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectuts.adapters.MainAdapter;
import com.example.projectuts.adapters.menuAdapter;
import com.example.projectuts.models.MainTeam;
import com.example.projectuts.models.TeamMenu;
import com.example.projectuts.models.Transaction;
import com.example.projectuts.models.session;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    public static final String TRANSACTION_KEY = "TRANSACTION";
    public static final String INDEX_KEY = "INDEX";
    public static final int UPDATE_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        RecyclerView teamsView = findViewById(R.id.rv_teams);

        List<MainTeam> teams = new ArrayList<>();
        MainTeam tm = new MainTeam("https://lh6.googleusercontent.com/-PnEsoCwsqko/T54VEVjqGZI/AAAAAAABuZk/judhBkwC3CU/s800/oreo-funfetti-cupcakes-6.jpg", "CUPCAKES");
        teams.add(tm);
        tm = new MainTeam("https://www.theflavorbender.com/wp-content/uploads/2018/10/Fudgy-Pecan-Pie-Bars-1128.jpg", "BROWNIES");
        teams.add(tm);
        tm = new MainTeam("https://lh3.googleusercontent.com/-NiRn83pp3Sg/VwS84FZw8rI/AAAAAAAFS5E/V1LT2SZv4_kW4k52ySDgzN6NtArQcbhowCCo/s800-Ic42/donut-mug-cake-23-2.jpg", "DONUT");
        teams.add(tm);
        MainAdapter adapter = new MainAdapter(this, teams);
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
        if (id == R.id.Cart) {
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.action_logout) {
            session.logout();
            Intent intent = new Intent(this, MainActivity.class);
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
