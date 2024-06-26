package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener{

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a22maxda";
    private final String JSON_FILE = "json-api.json";

    private Button aboutButton;
    private Button sortButton;

    Gson gson = new Gson();

    private ArrayList<JsonItems> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new JsonFile(this, this).execute(JSON_FILE);

        RecyclerView recView = findViewById(R.id.ItemList);
        RecyclerViewHolder adapter = new RecyclerViewHolder(this, items);
        recView.setLayoutManager(new LinearLayoutManager(this));

        recView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        aboutButton = findViewById(R.id.AboutButton);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        sortButton = findViewById(R.id.SortButton);
        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(MainActivity.this, sortButton);
                popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        return true;
                    }
                });
                popup.show();
            }
        });
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("onPostExecute", json);
        Type type = new TypeToken<List<JsonItems>>() {}.getType();
        items = gson.fromJson(json, type);
    }
}
