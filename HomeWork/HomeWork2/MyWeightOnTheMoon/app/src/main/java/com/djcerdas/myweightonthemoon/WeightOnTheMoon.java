package com.djcerdas.myweightonthemoon;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WeightOnTheMoon extends AppCompatActivity {
    // Associated variables
    TextView answerX;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

         answerX = (TextView) findViewById(R.id.answerX);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Make the calculation of the weight on the Moon
        float currentUserWeight = Float.parseFloat(getIntent().getStringExtra("WEIGHT"));
        float moonWeight = (float) ((currentUserWeight/9.81)* 1.622);
        String finalResult = String.format("%.2f", moonWeight);

        // Display the result
        answerX.setText("Answer: "+ finalResult+"Kg");
    }
}
