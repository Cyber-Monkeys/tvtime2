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

public class activity_shows_watch_list_unselected_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shows_watch_list_unselected_page);

        BottomNavigationView bottomNavigationMenu = findViewById(R.id.bottom_navigation);
        bottomNavigationMenu.clearAnimation();

        Menu menu = bottomNavigationMenu.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_shows:
                        Toast.makeText(activity_shows_watch_list_unselected_page.this, "Shows is clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_movies:
                        startActivity(new Intent(activity_shows_watch_list_unselected_page.this, MoviesWatchList.class));
                        CustomIntent.customType(activity_shows_watch_list_unselected_page.this, "fadein-to-fadeout");
                        break;
                    case R.id.action_discover:
                        startActivity(new Intent(activity_shows_watch_list_unselected_page.this, Discover.class));
                        CustomIntent.customType(activity_shows_watch_list_unselected_page.this, "fadein-to-fadeout");
                        break;
                    case R.id.action_profile:
                        startActivity(new Intent(activity_shows_watch_list_unselected_page.this, Profile.class));
                        CustomIntent.customType(activity_shows_watch_list_unselected_page.this, "fadein-to-fadeout");
                        break;
                }
                return true;
            }
        });
    }

    public void goToMovies(View view){
        startActivity(new Intent(this, MoviesWatchList.class));
        CustomIntent.customType(this, "fadein-to-fadeout");
    }

    public void goToShowsEpisodePage(View view){
        startActivity(new Intent(this, tvShowEpisodes.class));
        CustomIntent.customType(this, "fadein-to-fadeout");
    }

    public void goToDiscover(View view){
        startActivity(new Intent(this, Discover.class));
        CustomIntent.customType(this, "fadein-to-fadeout");
    }

    public void goToProfile(View view){
        startActivity(new Intent(this, Profile.class));
        CustomIntent.customType(this, "fadein-to-fadeout");
        CustomIntent.customType(activity_shows_watch_list_unselected_page.this, "fadein-to-fadeout");
    }
    public void menuPageSelect(View V) {
        startActivity(new Intent(this, ShowsWatchListDefaultPage.class));
        CustomIntent.customType(activity_shows_watch_list_unselected_page.this, "fadein-to-fadeout");
    }
    public void goToUpcomingTab(View V) {
        startActivity(new Intent(this, UpcomingHomePage.class));
        CustomIntent.customType(activity_shows_watch_list_unselected_page.this, "fadein-to-fadeout");
    }
}
