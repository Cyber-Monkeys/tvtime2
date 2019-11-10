package com.example.tvtime2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import maes.tech.intentanim.CustomIntent;

public class ShowsWatchListDefaultPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shows_watch_list_default_page);
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
}
