package com.example.registrationform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etEmail, etPassword;
    private Button btnRegister;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        etUsername = findViewById(R.id.et_username);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnRegister = findViewById(R.id.btn_register);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);

        // Set button click listener
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        // Get the input values from EditText fields
        String username = etUsername.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        // Validate input fields
        if (!username.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
            // Save user data in SharedPreferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Username", username);
            editor.putString("Email", email);
            editor.putString("Password", password);
            editor.apply();

            // Show success message
            Toast.makeText(MainActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();

            // Start MainActivity2 after registration
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
            finish();
        } else {
            // Show error if fields are empty
            Toast.makeText(MainActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
        }
    }
}