package com.example.registrationform;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private TextView tvWelcome, tvDetails;
    private Button btnViewDetails;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize UI components
        tvWelcome = findViewById(R.id.tv_welcome);
        tvDetails = findViewById(R.id.tv_details);
        btnViewDetails = findViewById(R.id.btn_view_details);

        // Get stored user details from SharedPreferences
        sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);
        String username = sharedPreferences.getString("Username", "User");

        // Set welcome message
        tvWelcome.setText("Welcome, " + username + "!");

        // Set button click listener to show user details
        btnViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showUserDetails();
            }
        });
    }

    private void showUserDetails() {
        // Get the user details from SharedPreferences
        String username = sharedPreferences.getString("Username", "N/A");
        String email = sharedPreferences.getString("Email", "N/A");
        String password = sharedPreferences.getString("Password", "N/A");

        // Display the user details in tvDetails
        String details = "Username: " + username + "\nEmail: " + email + "\nPassword: " + password;
        tvDetails.setText(details);
        tvDetails.setVisibility(View.VISIBLE);
    }
}