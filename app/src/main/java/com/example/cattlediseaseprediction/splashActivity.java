package com.example.cattlediseaseprediction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;


import androidx.appcompat.app.AppCompatActivity;

public class splashActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 3000;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Initialize the ProgressBar
        progressBar = findViewById(R.id.loadingSpinner);

        progressBar.setIndeterminate(true);

        // Navigate to WelcomeActivity after a delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashActivity.this, welcomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DELAY);
    }
}
