package com.example.tvtime2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class Notification extends AppCompatActivity {

    ArrayList<NotificationInfo> notificationInfoArrayList = new ArrayList<>();
    NotificationInfoAdapter notificationInfoAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        listView = findViewById(R.id.listView);
        listView.setElevation(3);

        notificationInfoArrayList.add(new NotificationInfo(R.drawable.vagabond,"You have just unlocked the Vagabond (2019) Quick Watcher badge!","1d"));
        notificationInfoArrayList.add(new NotificationInfo(R.drawable.yaiba,"You have just unlocked the Vikings (2019) Quick Watcher badge!","1d"));
        notificationInfoArrayList.add(new NotificationInfo(R.drawable.ballers,"You have just unlocked the Die (2019) Quick Watcher badge!","1d"));
        notificationInfoArrayList.add(new NotificationInfo(R.drawable.dr_stone,"You have just unlocked the Alone (2019) Quick Watcher badge!","2d"));
        notificationInfoArrayList.add(new NotificationInfo(R.drawable.vagabond,"You have just unlocked the Psycho Pass (2019) Quick Watcher badge!","2d"));
        notificationInfoArrayList.add(new NotificationInfo(R.drawable.dr_stone,"You have just unlocked the Dr. Stone (2019) Quick Watcher badge!","5d"));
        notificationInfoArrayList.add(new NotificationInfo(R.drawable.vagabond,"You have just unlocked the Blacklist (2019) Quick Watcher badge!","6d"));
        notificationInfoArrayList.add(new NotificationInfo(R.drawable.ballers,"You have just unlocked the Game of Thrones (2019) Quick Watcher badge!","6d"));
        notificationInfoArrayList.add(new NotificationInfo(R.drawable.vagabond,"You have just unlocked the Narcos (2019) Quick Watcher badge!","8d"));
        notificationInfoArrayList.add(new NotificationInfo(R.drawable.yaiba,"You have just unlocked the You (2019) Quick Watcher badge!","8d"));
        notificationInfoArrayList.add(new NotificationInfo(R.drawable.yaiba,"You have just unlocked the Joker (2019) Quick Watcher badge!","8d"));
        notificationInfoArrayList.add(new NotificationInfo(R.drawable.ballers,"You have just unlocked the Godzilla (2019) Quick Watcher badge!","8d"));
        notificationInfoArrayList.add(new NotificationInfo(R.drawable.dr_stone,"You have just unlocked the Friends (1994) Quick Watcher badge!","20d"));

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        //Add headerview for listview
        View headeView = inflater.inflate(R.layout.notification_button_view, null, false);
        listView.addHeaderView(headeView);

        notificationInfoAdapter = new NotificationInfoAdapter(this, R.layout.notification_info_view, notificationInfoArrayList);
        listView.setNestedScrollingEnabled(false);
        listView.setAdapter(notificationInfoAdapter);
    }

    public void goToProfile(View view){
        startActivity(new Intent(Notification.this, Profile.class));
    }
}
