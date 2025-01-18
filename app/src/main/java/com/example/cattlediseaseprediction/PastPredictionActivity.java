package com.example.cattlediseaseprediction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PastPredictionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_prediction);

        // Find the button
        Button predictAnotherDiseaseButton = findViewById(R.id.predictAnotherDiseaseButton);

        // Set click listener
        predictAnotherDiseaseButton.setOnClickListener(v -> startActivity(new Intent(PastPredictionActivity.this, PredictDiseaseActivity.class)));
    }
}
