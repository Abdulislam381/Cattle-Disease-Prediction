package com.example.cattlediseaseprediction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class welcomeActivity extends AppCompatActivity {

    private Button signInButton, signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Initialize buttons
        signInButton = findViewById(R.id.signInButton);
        signUpButton = findViewById(R.id.signUpButton);

        // Open SignInActivity
        signInButton.setOnClickListener(v -> startActivity(new Intent(welcomeActivity.this, signinActivity.class)));

        signUpButton.setOnClickListener(v -> startActivity(new Intent(welcomeActivity.this, signupActivity.class)));
    }
}
