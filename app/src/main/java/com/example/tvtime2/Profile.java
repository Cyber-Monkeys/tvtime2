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

        int[] shows ={
                R.drawable.house_of_cards_2, R.drawable.altered_carbon,R.drawable.game_of_thrones,R.drawable.vikings,
                R.drawable.sherlock
        };

        int[] favoriteShows ={
                R.drawable.vikings, R.drawable.sherlock,R.drawable.house_of_cards_2,
                R.drawable.game_of_thrones, R.drawable.altered_carbon, R.drawable.add_to_list
        };

        int[] movies ={
                R.drawable.joker, R.drawable.avengers_end_game,R.drawable.sleepless_in_seattle,
                R.drawable.perks_of_being_a_wallflower, R.drawable.your_name
        };

        int[] favoriteMovies ={
                R.drawable.perks_of_being_a_wallflower, R.drawable.your_name,R.drawable.sleepless_in_seattle,
                R.drawable.joker, R.drawable.avengers_end_game, R.drawable.add_to_list
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
        recyclerView2.setAdapter(new HorizontalAdapterImage(shows));

        RecyclerView recyclerView3 = (RecyclerView) findViewById(R.id.recyclerView3);
        recyclerView3.setNestedScrollingEnabled(false);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView3.setAdapter(new HorizontalAdapterImage(favoriteShows));

        RecyclerView recyclerView4 = (RecyclerView) findViewById(R.id.recyclerView4);
        recyclerView4.setNestedScrollingEnabled(false);
        recyclerView4.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView4.setAdapter(new HorizontalAdapterImage(movies));

        RecyclerView recyclerView5 = (RecyclerView) findViewById(R.id.recyclerView5);
        recyclerView5.setNestedScrollingEnabled(false);
        recyclerView5.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView5.setAdapter(new HorizontalAdapterImage(favoriteMovies));

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

    public void goToEditProfile(View view){
        startActivity(new Intent(Profile.this, EditProfile.class));
    }

    public void goToSettings(View view){
        startActivity(new Intent(Profile.this, Settings.class));
    }

    public void goToNotifications(View view){
        startActivity(new Intent(Profile.this, Notification.class));
    }

    public void goToShowsDefault(View view){
        startActivity(new Intent(Profile.this, ShowsWatchListDefaultPage.class));
    }

    public void goToMoviesWatchList(View view){
        startActivity(new Intent(Profile.this, MoviesWatchList.class));
    }

    public void goToCustomLists(View view){
        startActivity(new Intent(Profile.this, CustomerLists.class));
    }

    public void goToFollowers(View view){
        startActivity(new Intent(Profile.this, Followers.class));
    }

    public void goToFollowing(View view){
        startActivity(new Intent(Profile.this, Following.class));
    }

    public void goToComments(View view){
        startActivity(new Intent(Profile.this, Comments.class));
    }

    public void goToCStats(View view){
        startActivity(new Intent(Profile.this, Stats.class));
    }
}
