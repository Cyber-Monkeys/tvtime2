package com.example.tvtime2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import maes.tech.intentanim.CustomIntent;

public class Discover extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);

        BottomNavigationView bottomNavigationMenu = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationMenu.clearAnimation();

        Menu menu = bottomNavigationMenu.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_shows:
                        startActivity(new Intent(Discover.this, ShowsWatchListDefaultPage.class));
                        CustomIntent.customType(Discover.this, "fadein-to-fadeout");
                        break;
                    case R.id.action_movies:
                        startActivity(new Intent(Discover.this, Movies.class));
                        CustomIntent.customType(Discover.this, "fadein-to-fadeout");
                        break;
                    case R.id.action_discover:
                        Toast.makeText(Discover.this, "Discover is clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_profile:
                        startActivity(new Intent(Discover.this, Profile.class));
                        CustomIntent.customType(Discover.this, "fadein-to-fadeout");
                        break;
                }
                return true;
            }
        });
    }
}
