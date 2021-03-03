package com.petrzimin.firebasetaxi.utils;

import android.app.Activity;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.petrzimin.firebasetaxi.R;

import java.util.Objects;

public class TaxiUtils {
    public static void hideActionBar(AppCompatActivity activity) {
        if (activity.getSupportActionBar() != null) {
            activity.getSupportActionBar().hide();
        }
        if (activity.getActionBar() != null) {
            activity.getActionBar().hide();
        }
    }

    public static boolean validatePassword(TextInputLayout textInputPassword, TextInputLayout textInputConfirmPassword) {
        String passwordInput = "";
        String passwordConfirmInput = "";
        try {
            passwordInput = Objects.requireNonNull(textInputPassword.getEditText()).getText().toString().trim();
            passwordConfirmInput = Objects.requireNonNull(textInputConfirmPassword.getEditText()).getText().toString().trim();
        } catch (NullPointerException e) {

        }

        if (passwordInput.isEmpty() ||
                passwordInput.length() > 7 ||
                passwordConfirmInput.isEmpty() ||
                passwordConfirmInput.length() > 7 ||
                !passwordInput.equals(passwordConfirmInput)) {
            textInputPassword.setError(textInputPassword.getContext().getString(R.string.wrong_pass_error));
            return false;
        } else {
            textInputPassword.setError("");
            return true;
        }
    }

    public static boolean validateEmail(TextInputLayout textInputEmail) {
        String emailInput = "";
        try {
            emailInput = Objects.requireNonNull(textInputEmail.getEditText()).getText().toString().trim();
        } catch (NullPointerException e) {

        }
        if (emailInput.isEmpty()) {
            textInputEmail.setError(textInputEmail.getContext().getString(R.string.input_email_error));
            return false;
        } else {
            textInputEmail.setError("");
            return true;
        }
    }

    public static boolean validateName(TextInputLayout textInputName) {
        String nameInput = "";
        try {
            nameInput = Objects.requireNonNull(textInputName.getEditText()).getText().toString().trim();
        } catch (NullPointerException e) {

        }


        if (nameInput.isEmpty() || nameInput.length() > 15) {
            textInputName.setError(textInputName.getContext().getString(R.string.input_name_error));
            return false;
        } else {
            textInputName.setError("");
            return true;
        }
    }
}
