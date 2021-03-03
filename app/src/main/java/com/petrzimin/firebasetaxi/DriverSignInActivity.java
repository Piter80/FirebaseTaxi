package com.petrzimin.firebasetaxi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.Optional;

public class DriverSignInActivity extends AppCompatActivity {

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputName;
    private TextInputLayout textInputPassword;
    private TextInputLayout textInputConfirmPassword;
    private Button driverLoginSignUp;
    private TextView toggleLoginSignUpTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_sign_in);
        fieldsBinding();

    }

    private void fieldsBinding() {
        textInputEmail = findViewById(R.id.textInputEmail);
        textInputName = findViewById(R.id.textInputName);
        textInputPassword = findViewById(R.id.textInputPassword);
        textInputConfirmPassword = findViewById(R.id.textInputConfirmPassword);
        driverLoginSignUp = findViewById(R.id.driverLoginSignUp);
        toggleLoginSignUpTextView = findViewById(R.id.toggleLoginSignUpTextView);
        driverLoginSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateEmail() && validateName() && validatePassword()) {
                    Toast.makeText(v.getContext(), "All is OK", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private boolean validateEmail() {
        String emailInput = "";
        try {
            emailInput = Objects.requireNonNull(textInputEmail.getEditText()).getText().toString().trim();
        } catch (NullPointerException e) {

        }
        if (emailInput.isEmpty()) {
            textInputEmail.setError(getString(R.string.input_email_error));
            return false;
        } else {
            textInputEmail.setError("");
            return true;
        }
    }

    private boolean validateName() {
        String nameInput = "";
        try {
            nameInput = Objects.requireNonNull(textInputName.getEditText()).getText().toString().trim();
        } catch (NullPointerException e) {

        }


        if (nameInput.isEmpty() || nameInput.length() > 15) {
            textInputEmail.setError(getString(R.string.input_name_error));
            return false;
        } else {
            textInputEmail.setError("");
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = "";
        String passwordConfirmInput = "";
        try {
            passwordInput = Objects.requireNonNull(textInputPassword.getEditText()).getText().toString().trim();
            passwordConfirmInput = Objects.requireNonNull(textInputConfirmPassword.getEditText()).getText().toString().trim();
        } catch (NullPointerException e) {

        };

        if (passwordInput.isEmpty() ||
                passwordInput.length() > 7 ||
                passwordConfirmInput.isEmpty() ||
                passwordConfirmInput.length() > 7 ||
        !passwordInput.equals(passwordConfirmInput)) {
            textInputPassword.setError(getString(R.string.wrong_pass_error));
            return false;
        } else {
            textInputEmail.setError("");
            return true;
        }
    }
}