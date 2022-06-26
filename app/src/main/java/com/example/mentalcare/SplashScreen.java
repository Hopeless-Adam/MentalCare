package com.example.mentalcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class SplashScreen extends AppCompatActivity {
    private  static int Splash_Time = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent DataActivity = new Intent(SplashScreen.this, DataActivity.class);
                startActivity(DataActivity);
                finish();
            }
        }, Splash_Time);



    }
}