package com.petrzimin.firebasetaxi.utils;

import android.app.Activity;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

public class TaxiUtils {
    public static void hideActionBar(AppCompatActivity activity) {
        if (activity.getSupportActionBar() != null) {
            activity.getSupportActionBar().hide();
        }
        if (activity.getActionBar() != null) {
            activity.getActionBar().hide();
        }
    }
}
