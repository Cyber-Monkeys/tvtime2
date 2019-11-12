package com.example.tvtime2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import maes.tech.intentanim.CustomIntent;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MoviesUpcoming extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_upcoming);
        BottomNavigationView bottomNavigationMenu = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationMenu.clearAnimation();

        Menu menu = bottomNavigationMenu.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_shows:
                        startActivity(new Intent(MoviesUpcoming.this, ShowsWatchListDefaultPage.class));
                        CustomIntent.customType(MoviesUpcoming.this, "fadein-to-fadeout");
                        break;
                    case R.id.action_movies:
                        Toast.makeText(MoviesUpcoming.this, "Movies  is clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_discover:
                        startActivity(new Intent(MoviesUpcoming.this, Discover.class));
                        CustomIntent.customType(MoviesUpcoming.this, "fadein-to-fadeout");
                        break;
                    case R.id.action_profile:
                        startActivity(new Intent(MoviesUpcoming.this, Profile.class));
                        break;
                }
                return true;
            }
        });
    }
    public void goToMoviesWatchListTab(View V) {
        startActivity(new Intent(this, MoviesWatchList.class));
        CustomIntent.customType(this, "fadein-to-fadeout");
    }
}
