package com.example.cattlediseaseprediction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ContactUsActivity extends AppCompatActivity {
private Button homeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
    homeButton=findViewById(R.id.homeButton);

    homeButton.setOnClickListener(v -> startActivity(new Intent(ContactUsActivity.this, HomeActivity.class)));

    }
}
