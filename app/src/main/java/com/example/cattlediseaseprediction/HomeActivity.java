package com.example.cattlediseaseprediction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    private Button predictDiseaseButton, pastPredictionsButton, treatmentGuideButton, contactUsButton;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        // Set up the ActionBarDrawerToggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Handle navigation item selection
        navigationView.setNavigationItemSelectedListener(item -> handleNavigation(item));


        predictDiseaseButton = findViewById(R.id.predictDiseaseButton);
        pastPredictionsButton = findViewById(R.id.pastPredictionsButton);
        treatmentGuideButton = findViewById(R.id.treatmentGuideButton);
        contactUsButton = findViewById(R.id.contactUsButton);

        predictDiseaseButton.setOnClickListener(v ->
                startActivity(new Intent(HomeActivity.this, PredictDiseaseActivity.class))
        );

        pastPredictionsButton.setOnClickListener(v ->
                startActivity(new Intent(HomeActivity.this, PastPredictionActivity.class))
        );

        treatmentGuideButton.setOnClickListener(v ->
                startActivity(new Intent(HomeActivity.this, TreatmentActivity.class))
        );

        contactUsButton.setOnClickListener(v ->
                startActivity(new Intent(HomeActivity.this, ContactUsActivity.class))
        );
    }


    private boolean handleNavigation(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.nav_home) {
            // Already in HomeActivity
            drawerLayout.closeDrawers();
            return true;
        }  else if (itemId == R.id.nav_logout) {
            // Perform logout logic
            startActivity(new Intent(HomeActivity.this, welcomeActivity.class));
            finish();
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(navigationView)) {
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }
}
