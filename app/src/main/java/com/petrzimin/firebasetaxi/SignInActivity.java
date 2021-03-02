package com.petrzimin.firebasetaxi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.petrzimin.firebasetaxi.utils.TaxiUtils;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        TaxiUtils.hideActionBar(this);
    }
}