package com.example.tvtime2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import maes.tech.intentanim.CustomIntent;

public class Profile extends AppCompatActivity {


    ArrayList<ProfileInfo> profileInfoArrayList = new ArrayList<ProfileInfo>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileInfoArrayList.add(new ProfileInfo("TV Time", "10 09 09", "months days hours"));
        profileInfoArrayList.add(new ProfileInfo("EPISODES WATCHED", "17.3K", "46 in the last month"));
        profileInfoArrayList.add(new ProfileInfo("MOVIE Time", "01 04 18", "months days hours"));
        profileInfoArrayList.add(new ProfileInfo("MOVIES WATCHED", "455", ""));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new HorizontalAdapter(profileInfoArrayList));
        //recyclerView.setAdapter(new HorizontalAdapter(new String[]{"android","cdsds","dsdsd"}));


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
