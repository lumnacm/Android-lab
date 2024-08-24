package com.example.formvalidation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare UI components
    private EditText etFirstName, etLastName, etPassword;
    private RadioGroup genderGroup;
    private Switch switchNewMember;
    private CheckBox checkBoxTerms;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        etFirstName = findViewById(R.id.firstName);
        etLastName = findViewById(R.id.lastName);
        etPassword = findViewById(R.id.password);
        genderGroup = findViewById(R.id.genderGroup);
        switchNewMember = findViewById(R.id.switchNewMember);
        checkBoxTerms = findViewById(R.id.checkBoxTerms);
        submitButton = findViewById(R.id.submitButton);

        // Set up the submit button click listener
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSubmit();
            }
        });
    }

    private void handleSubmit() {
        // Validate the form fields
        String firstName = etFirstName.getText().toString().trim();
        String lastName = etLastName.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // Check if all fields are filled
        if (firstName.isEmpty()) {
            etFirstName.setError("First Name is required");
            return;
        }

        if (lastName.isEmpty()) {
            etLastName.setError("Last Name is required");
            return;
        }

        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            return;
        } else if (password.length() < 8) {
            etPassword.setError("Password must be at least 8 characters long");
            return;
        }

        // Check if gender is selected
        int selectedGenderId = genderGroup.getCheckedRadioButtonId();
        if (selectedGenderId == -1) {
            Toast.makeText(this, "Please select a gender", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selectedGenderButton = findViewById(selectedGenderId);
        String gender = selectedGenderButton.getText().toString();

        // Check if terms and conditions are accepted
        if (!checkBoxTerms.isChecked()) {
            Toast.makeText(this, "You must agree to the terms and conditions", Toast.LENGTH_SHORT).show();
            return;
        }

        // Display form data
        String newMemberStatus = switchNewMember.isChecked() ? "Yes" : "No";
        String message = String.format("First Name: %s\nLast Name: %s\nGender: %s\nPassword: %s\nNew Member: %s",
                firstName, lastName, gender, password, newMemberStatus);

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        // Clear form fields after submission
        etFirstName.setText("");
        etLastName.setText("");
        etPassword.setText("");
        genderGroup.clearCheck();
        switchNewMember.setChecked(false);
        checkBoxTerms.setChecked(false);
    }
}