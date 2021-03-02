package com.petrzimin.firebasetaxi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.petrzimin.firebasetaxi.utils.TaxiUtils;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        TaxiUtils.hideActionBar(this);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(SplashScreenActivity.this, ChooseModeActivity.class));
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        Log.d("MyMESSAGE", "splash screen paused and after that finished");
        super.onPause();
        finish();
    }
}