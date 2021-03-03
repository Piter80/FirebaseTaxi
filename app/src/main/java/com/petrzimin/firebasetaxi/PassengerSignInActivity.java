package com.petrzimin.firebasetaxi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.petrzimin.firebasetaxi.utils.TaxiUtils;

public class PassengerSignInActivity extends AppCompatActivity {

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputName;
    private TextInputLayout textInputPassword;
    private TextInputLayout textInputConfirmPassword;
    private Button loginSignUpButton;
    private TextView toggleLoginSignUpTextView;
    private boolean isLoginModeActive;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_sign_in);
        fieldsBinding();
        mAuth = FirebaseAuth.getInstance();

    }

    private void fieldsBinding() {
        textInputEmail = findViewById(R.id.textInputEmail);
        textInputName = findViewById(R.id.textInputName);
        textInputPassword = findViewById(R.id.textInputPassword);
        textInputConfirmPassword = findViewById(R.id.textInputConfirmPassword);
        loginSignUpButton = findViewById(R.id.passengerLoginSignUp);
        toggleLoginSignUpTextView = findViewById(R.id.toggleLoginSignUpTextView);
        toggleLoginSignUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                errorsReset();
                if (isLoginModeActive) {
                    isLoginModeActive = false;
                    loginSignUpButton.setText(R.string.sign_up);
                    toggleLoginSignUpTextView.setText(R.string.tap_to_login);
                    textInputConfirmPassword.setVisibility(View.VISIBLE);
                    textInputName.setVisibility(View.VISIBLE);
                } else {
                    isLoginModeActive = true;
                    loginSignUpButton.setText(R.string.login);
                    toggleLoginSignUpTextView.setText(R.string.tap_to_sign_up);
                    textInputConfirmPassword.setVisibility(View.INVISIBLE);
                    textInputName.setVisibility(View.INVISIBLE);
                }
            }
        });

        loginSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLoginModeActive && TaxiUtils.validateEmail(textInputEmail) && TaxiUtils.validateName(textInputName) && TaxiUtils.validatePassword(textInputPassword, textInputConfirmPassword)) {
                    signUp();
                } else if (isLoginModeActive) {
                    login();
                }
            }
        });

    }

    private void login() {
        mAuth.signInWithEmailAndPassword(textInputEmail.getEditText().getText().toString().trim(), textInputPassword.getEditText().getText().toString().trim())
                .addOnCompleteListener(PassengerSignInActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TaxiUtils.TAXI_APP_DEBUG_TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TaxiUtils.TAXI_APP_DEBUG_TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(PassengerSignInActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });
    }

    private void signUp() {
        mAuth.createUserWithEmailAndPassword(textInputEmail.getEditText().getText().toString().trim(), textInputPassword.getEditText().getText().toString().trim())
                .addOnCompleteListener(PassengerSignInActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TaxiUtils.TAXI_APP_DEBUG_TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TaxiUtils.TAXI_APP_DEBUG_TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(PassengerSignInActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });
    }

    private void errorsReset() {
        textInputPassword.setError("");
        textInputName.setError("");
        textInputEmail.setError("");
    }

}