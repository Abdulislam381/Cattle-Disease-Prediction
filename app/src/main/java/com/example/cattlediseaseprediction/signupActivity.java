package com.example.cattlediseaseprediction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signupActivity extends AppCompatActivity {

    private EditText nameInput, emailInput, phoneInput, passwordInput, confirmPasswordInput;
    private Button signUpButton;

    private UserDatabaseHelper userDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize Views
        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        phoneInput = findViewById(R.id.phoneInput);
        passwordInput = findViewById(R.id.passwordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        signUpButton = findViewById(R.id.signUpButton);

        // Initialize SQLite helper
        userDatabaseHelper = new UserDatabaseHelper(this);

        // Handle Sign Up Button Click
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString();
                String email = emailInput.getText().toString();
                String phone = phoneInput.getText().toString();
                String password = passwordInput.getText().toString();
                String confirmPassword = confirmPasswordInput.getText().toString();

                // Validation
                if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(signupActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(signupActivity.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
                } else if (!phone.matches("\\d{11}")) {  // Phone number validation (for 11 digits)
                    Toast.makeText(signupActivity.this, "Please enter a valid 11-digit phone number", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 8) {
                    Toast.makeText(signupActivity.this, "Password must be at least 8 characters long", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(signupActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    userDatabaseHelper.open();

                    // Check if email is already registered
                    if (userDatabaseHelper.isEmailRegistered(email)) {
                        Toast.makeText(signupActivity.this, "This email is already registered", Toast.LENGTH_SHORT).show();
                    } else {
                        // Insert user data into SQLite database
                        boolean isInserted = userDatabaseHelper.insertUser(email, password, phone);
                        if (isInserted) {
                            Toast.makeText(signupActivity.this, "Account Created Successfully!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(signupActivity.this, signinActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(signupActivity.this, "Error creating account", Toast.LENGTH_SHORT).show();
                        }
                    }

                    userDatabaseHelper.close();
                }
            }
        });
    }
}
