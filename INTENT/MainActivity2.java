package com.example.multiple;
import static com.example.multiple.R.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {
    TextView a1,a2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        a1 = findViewById(R.id.n1);
        a2 = findViewById(R.id.n2);

        Bundle extra = getIntent().getExtras();
        String text = extra.getString("name");
        String text1 = extra.getString("name1");
        a1.setText(text);
        a2.setText(text1);


    }
}