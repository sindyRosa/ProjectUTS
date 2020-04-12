package com.example.projectuts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.projectuts.models.TeamMain;
import com.example.projectuts.models.Transaction;
import com.example.projectuts.models.session;

import java.nio.channels.AcceptPendingException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TRANSACTION_KEY = "TRANSACTION";
    public static final String INDEX_KEY = "INDEX";
    public static final int UPDATE_REQUEST = 2;
    private Object session;
    private Button buttonMari;
    private Button maps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMari = findViewById(R.id.buttonMari);

        buttonMari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(i);
            }
        });
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

        return super.onOptionsItemSelected(item);
    }
    public void onTransactionClicked(int index, Transaction item) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(TRANSACTION_KEY, item);
        intent.putExtra(INDEX_KEY, 0);
        startActivityForResult(intent, UPDATE_REQUEST);
    }

    public void maps(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
