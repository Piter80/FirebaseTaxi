package com.petrzimin.firebasetaxi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.petrzimin.firebasetaxi.utils.TaxiUtils;

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
                if (TaxiUtils.validateEmail(textInputEmail) && TaxiUtils.validateName(textInputName) && TaxiUtils.validatePassword(textInputPassword, textInputConfirmPassword)) {
                    Toast.makeText(v.getContext(),
                            "Name: " + textInputName.getEditText().getText().toString() +
                                    "\n Email: " + textInputEmail.getEditText().getText().toString() +
                                    "\n and password is OK",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}