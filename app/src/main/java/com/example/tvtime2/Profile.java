package com.example.tvtime2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.reflect.Field;

import maes.tech.intentanim.CustomIntent;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BottomNavigationView bottomNavigationMenu = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationMenu.clearAnimation();

        Menu menu = bottomNavigationMenu.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        bottomNavigationMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_shows:
                        startActivity(new Intent(Profile.this, ShowsWatchListDefaultPage.class));
                        CustomIntent.customType(Profile.this, "fadein-to-fadeout");
                        break;
                    case R.id.action_movies:
                        startActivity(new Intent(Profile.this, Movies.class));
                        CustomIntent.customType(Profile.this, "fadein-to-fadeout");
                        break;
                    case R.id.action_discover:
                        startActivity(new Intent(Profile.this, Discover.class));
                        CustomIntent.customType(Profile.this, "fadein-to-fadeout");
                        break;
                    case R.id.action_profile:
                        Toast.makeText(Profile.this, "Profile is clicked", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
}
