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

public class MenuActivity extends AppCompatActivity {
    public static final String TRANSACTION_KEY = "TRANSACTION";
    public static final String INDEX_KEY = "INDEX";
    public static final int UPDATE_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        RecyclerView teamsView = findViewById(R.id.rv_teams);

        List<TeamMenu> teams = new ArrayList<>();
        teams.add(new TeamMenu("https://savoryspin.com/wp-content/uploads/2018/01/Easy-Oatmeal-Pancakes.jpg", "Pancakes"));
        teams.add(new TeamMenu("https://savoryspin.com/wp-content/uploads/2018/03/Easy-Gluten-Free-Mocha-Oatmeal-Pancakes.jpg", "Chocolate Pancakes"));
        teams.add(new TeamMenu("https://savoryspin.com/wp-content/uploads/2017/11/Goat-Cheese-Puff-Pastry-Stacks.jpg", "Cheese Puffs Pastry"));
        teams.add(new TeamMenu("https://savoryspin.com/wp-content/uploads/2017/12/Easy-Spiced-Potato-Puff-Pastry-Baskets.jpg", "Potato Puffs Pastry"));
        teams.add(new TeamMenu("https://cdn.shortpixel.ai/client/to_webp,q_lossy,ret_img,w_1771/https://savoryspin.com/wp-content/uploads/2019/08/Lemon-Blueberry-Muffin-Tops-Gluten-Free.jpg", "Lemon Murfin Blueberry"));
        teams.add(new TeamMenu("https://cdn.shortpixel.ai/client/to_webp,q_lossy,ret_img,w_700/https://savoryspin.com/wp-content/uploads/2018/09/Japanese-Pumpkin-Bars.jpg", "Chocolate Chip Kabocha Bars"));
        teams.add(new TeamMenu("https://cdn.shortpixel.ai/client/q_lossy,ret_img,w_1576/https://savoryspin.com/wp-content/uploads/2019/12/Enjoying-Plant-Based-Apple-Pecan-Bread-With-Silk-1576x2048.jpg", "Apple Pecan Bread"));
        teams.add(new TeamMenu("https://savoryspin.com/wp-content/uploads/2017/12/Easy-Spiced-Potato-Puff-Pastry-Baskets.jpg", "Spiced Potato"));
        teams.add(new TeamMenu("https://cdn.shortpixel.ai/client/to_webp,q_lossy,ret_img,w_556/https://savoryspin.com/wp-content/uploads/2018/12/Gluten-Free-Ginger-Sweet-Potato-Cupcakes-With-Ginger-Frosting-556x690.jpg", "Gluten Sweet Cupcakes"));
        teams.add(new TeamMenu("https://savoryspin.com/wp-content/uploads/2017/08/Pumpkin-Pecan-Muffins.jpg", "Pumpkin Pecan Muffins"));
        teams.add(new TeamMenu("https://cdn.shortpixel.ai/client/to_webp,q_lossy,ret_img,w_850/https://savoryspin.com/wp-content/uploads/2019/04/AirFryer-Cinnamon-Cardamom-Cheesecake.jpg", "AirFryey Cheesecake"));
        teams.add(new TeamMenu("https://cdn.shortpixel.ai/client/to_webp,q_lossy,ret_img,w_850/https://savoryspin.com/wp-content/uploads/2019/05/Gluten-Free-Chocolate-Orange-Airfryer-Cupcakes.jpg", "Chocolate Airfryey Cupcakes"));
        teams.add(new TeamMenu("https://savoryspin.com/wp-content/uploads/2016/10/Date-Banana-Muffins.jpg", "Banana Muffins"));
        teams.add(new TeamMenu("https://savoryspin.com/wp-content/uploads/2016/07/Blueberry-jicama-muffins-ggnoads.jpg", "Blueberry jicama Cupcakes"));
        teams.add(new TeamMenu("https://savoryspin.com/wp-content/uploads/2017/03/Fruit-Filled-waffle-cups-with-cardamom-vanilla-coconut-cream.jpg", "Fruite vanilla Waffle"));

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
