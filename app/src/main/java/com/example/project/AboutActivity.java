package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;

public class AboutActivity extends AppCompatActivity {

    private WebView aboutView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        aboutView = findViewById(R.id.AboutView);
        aboutView.loadUrl("file:///android_asset/About.txt");
    }
}