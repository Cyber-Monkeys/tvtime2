package com.example.tvtime2;

import androidx.appcompat.app.AppCompatActivity;
import maes.tech.intentanim.CustomIntent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity_shows_watch_list_unselected_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shows_watch_list_unselected_page);
    }

    public void goToMovies(View view){
        startActivity(new Intent(this, Movies.class));
        CustomIntent.customType(this, "fadein-to-fadeout");
    }

    public void goToDiscover(View view){
        startActivity(new Intent(this, Discover.class));
        CustomIntent.customType(this, "fadein-to-fadeout");
    }

    public void goToProfile(View view){
        startActivity(new Intent(this, Profile.class));
        CustomIntent.customType(this, "fadein-to-fadeout");
    }
    public void menuPageSelect(View V) {
        startActivity(new Intent(this, ShowsWatchListDefaultPage.class));
    }
    public void goToUpcomingTab(View V) {
        startActivity(new Intent(this, UpcomingHomePage.class));
    }
}
