package com.srishti.multitaskerapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WallpaperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);
        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        actionBar.setTitle("Set Wallpaper");
    }
    public void startWallpaper(View View){
                startService(new Intent(WallpaperActivity.this, MyWallpaper.class));
            }

    }
