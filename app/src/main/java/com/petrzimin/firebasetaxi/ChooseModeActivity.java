package com.petrzimin.firebasetaxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.petrzimin.firebasetaxi.utils.TaxiUtils;

public class ChooseModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode);
        TaxiUtils.hideActionBar(this);
    }

    public void goToDriverSignIn(View view) {
        startActivity(new Intent(ChooseModeActivity.this, DriverSignInActivity.class));
    }

    public void goToPassengerSignIn(View view) {
        startActivity(new Intent(ChooseModeActivity.this, PassengerSignInActivity.class));
    }
}