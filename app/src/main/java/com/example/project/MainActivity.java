package com.example.project;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

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

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private final String JSON_FILE = "json-api.json";

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
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("onPostExecute", json);
        Type type = new TypeToken<List<JsonItems>>() {}.getType();
        items = gson.fromJson(json, type);
    }
}
