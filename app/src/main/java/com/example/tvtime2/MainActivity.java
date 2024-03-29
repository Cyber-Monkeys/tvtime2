package com.example.tvtime2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set background transparency to 230/255
        View backgroundimage = findViewById(R.id.background);
        Drawable background = backgroundimage.getBackground();
        background.setAlpha(230);
    }


    //Go to signup activity
    public void goToSignUp(View view){
        startActivity(new Intent(MainActivity.this, Signup.class));
    }

    //go to login activity
    public void goToLogIn(View view){
        startActivity(new Intent(MainActivity.this, Login.class));
    }
}
