package com.example.spinner;



import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner mySpinner;
    private TextView selectedItemText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySpinner = findViewById(R.id.myspinner);
        selectedItemText = findViewById(R.id.selectedItemText);

        // Define the dropdown items directly in the code, including a "Select" option
        List<String> items = Arrays.asList("Select", "Item 1", "Item 2", "Item 3");

        // Create an ArrayAdapter using the list
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);

        // Set the default selection to the first item (index 0)
        mySpinner.setSelection(0); // Set "Select" as default

        // Set item selected listener
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                // Only update the TextView if a valid item is selected
                if (!selectedItem.equals("Select")) {
                    selectedItemText.setText("Selected Item: " + selectedItem);
                } else {
                    selectedItemText.setText("Selected Item: None");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedItemText.setText("Selected Item: None");
            }
        });
    }
}