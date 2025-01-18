package com.example.cattlediseaseprediction;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signinActivity extends AppCompatActivity {

    private EditText emailInput, passwordInput;
    private Button signInButton;
    private TextView signUpText;
    private CheckBox showPasswordCheckBox;

    private UserDatabaseHelper userDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        signInButton = findViewById(R.id.loginButton);
        signUpText = findViewById(R.id.signUpText);
        showPasswordCheckBox = findViewById(R.id.showPasswordCheckBox);


        userDatabaseHelper = new UserDatabaseHelper(this);


        showPasswordCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Show password
                passwordInput.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                // Hide password
                passwordInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            // Move cursor to the end of the text
            passwordInput.setSelection(passwordInput.getText().length());
        });


        signUpText.setOnClickListener(v -> startActivity(new Intent(signinActivity.this, signupActivity.class)));


        signInButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(signinActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validate user credentials from SQLite database
            userDatabaseHelper.open();
            boolean isValidUser = userDatabaseHelper.validateUser(email, password);
            userDatabaseHelper.close();

            if (isValidUser) {
                Toast.makeText(signinActivity.this, "Sign-In Successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(signinActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(signinActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
