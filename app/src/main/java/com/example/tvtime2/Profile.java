package com.example.tvtime2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import maes.tech.intentanim.CustomIntent;

public class Profile extends AppCompatActivity {

    //variables
    TextView question_mark;
    TextView bell;
    TextView share;
    TextView greater_than, greater_than2, greater_than3, greater_than4, greater_than5;
    ArrayList<ProfileInfo> profileInfoArrayList = new ArrayList<ProfileInfo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        int[] images ={
                R.drawable.joker_background, R.drawable.sherlock_holmes,R.drawable.sherlock_holmes,R.drawable.sherlock_holmes,
                R.drawable.sherlock_holmes,R.drawable.sherlock_holmes,R.drawable.sherlock_holmes,R.drawable.sherlock_holmes
        };

        question_mark = (TextView) findViewById(R.id.question_mark_text);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/fa-solid-900.ttf"); //question_mark
        question_mark.setTypeface(font);
        question_mark.setText("\uf128");

        bell = (TextView) findViewById(R.id.bell_text);
        Typeface font2 = Typeface.createFromAsset(getAssets(), "fonts/fa-regular-400.ttf"); //bell
        bell.setTypeface(font2);
        bell.setText("\uf0f3");

        share = (TextView) findViewById(R.id.share_text);
        Typeface font3 = Typeface.createFromAsset(getAssets(), "fonts/fa-solid-900.ttf"); //share
        share.setTypeface(font3);
        share.setText("\uf14d");

        greater_than = (TextView) findViewById(R.id.greater_than);
        greater_than2 = (TextView) findViewById(R.id.greater_than2);
        greater_than3 = (TextView) findViewById(R.id.greater_than3);
        greater_than4 = (TextView) findViewById(R.id.greater_than4);
        greater_than5 = (TextView) findViewById(R.id.greater_than5);
        Typeface font4 = Typeface.createFromAsset(getAssets(), "fonts/fa-solid-900.ttf"); //greater than
        greater_than.setTypeface(font4);
        greater_than.setText("\uf531");
        greater_than2.setTypeface(font4);
        greater_than2.setText("\uf531");
        greater_than3.setTypeface(font4);
        greater_than3.setText("\uf531");
        greater_than4.setTypeface(font4);
        greater_than4.setText("\uf531");
        greater_than5.setTypeface(font4);
        greater_than5.setText("\uf531");

        profileInfoArrayList.add(new ProfileInfo("TV Time", "10      09      09", "months            days               hours  "));
        profileInfoArrayList.add(new ProfileInfo("EPISODES WATCHED", "17.3K", "46 in the last month"));
        profileInfoArrayList.add(new ProfileInfo("MOVIE Time", "01      04      18", "months            days               hours  "));
        profileInfoArrayList.add(new ProfileInfo("MOVIES WATCHED", "455", ""));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new HorizontalAdapter(profileInfoArrayList));

        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        recyclerView2.setNestedScrollingEnabled(false);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView2.setAdapter(new HorizontalAdapterImage(images));

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

    public void goToHelpPage(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://tvtime.zendesk.com/hc/en-us")));
    }

    public void goToShare(View view){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        i.setType("text/plain");
        startActivity(Intent.createChooser(i, "Share with..."));
    }
}
