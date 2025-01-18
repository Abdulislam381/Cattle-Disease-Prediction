package com.example.cattlediseaseprediction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PredictionResultsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction_results);

        // Find the Treatment Guide link TextView
        TextView treatmentGuideLink = findViewById(R.id.treatmentGuideLink);

        // Set a click listener to navigate to TreatmentActivity
        treatmentGuideLink.setOnClickListener(view -> {
            Intent intent = new Intent(PredictionResultsActivity.this, TreatmentActivity.class);
            startActivity(intent);
        });
    }
}
