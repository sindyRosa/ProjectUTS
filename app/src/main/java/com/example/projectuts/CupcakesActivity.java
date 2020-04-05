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

public class CupcakesActivity extends AppCompatActivity {
    public static final String TRANSACTION_KEY = "TRANSACTION";
    public static final String INDEX_KEY = "INDEX";
    public static final int UPDATE_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cupcakes);

        RecyclerView teamsView = findViewById(R.id.rv_teams);

        List<TeamMenu> teams = new ArrayList<>();
        teams.add(new TeamMenu("https://www.theflavorbender.com/wp-content/uploads/2019/11/Halloween-Cupcakes-6444-780x1169.jpg", "Halloween Cupcakes"));
        teams.add(new TeamMenu("https://www.theflavorbender.com/wp-content/uploads/2020/01/Swiss-Meringue-Buttercream-8527-699x1047.jpg", "Buttercream Cupcakes"));
        teams.add(new TeamMenu("https://www.theflavorbender.com/wp-content/uploads/2016/12/Gingerbread-Cupcakes-with-Eggnog-Filling-0138.jpg", "Ginggerbread Cupcakes"));
        teams.add(new TeamMenu("https://www.theflavorbender.com/wp-content/uploads/2016/03/Spiced-Banana-Cupcakes-with-Apricot-Frosting-8396-Copy.jpg", "Spiced Banana Cupcakes"));
        teams.add(new TeamMenu("https://www.handletheheat.com/wp-content/uploads/2012/08/Chocolate-Mint-Cupcakes-SQUARE.jpg", "Mint Chocolates Cupcakes"));
        teams.add(new TeamMenu("https://www.handletheheat.com/wp-content/uploads/2019/03/lemon-cupcakes-SQUARE.jpg", "Lemon Cupcakes"));
        teams.add(new TeamMenu("https://www.handletheheat.com/wp-content/uploads/2020/03/Homemade-Chocolate-Coconut-Cupcakes-SQUARE-1536x1536.jpg", "Chocolate Coconut Cupcakes"));
        teams.add(new TeamMenu("https://www.handletheheat.com/wp-content/uploads/2015/06/Salted-Caramel-Toffee-Cupcakes-square.jpg", "Salted Caramel Cupcakes"));
        teams.add(new TeamMenu("https://www.handletheheat.com/wp-content/uploads/2015/06/banana-split-cupcakes-square.jpg", "Banana Split Cupcakes"));
        teams.add(new TeamMenu("https://www.handletheheat.com/wp-content/uploads/2015/10/Caramel-Apple-Cupcakes-31-550x550.jpg", "Apple Caramel Cupcakes"));

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
