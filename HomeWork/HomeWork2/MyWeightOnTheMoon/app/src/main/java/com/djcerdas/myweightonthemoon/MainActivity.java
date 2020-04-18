package com.djcerdas.myweightonthemoon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView infoX;
    private EditText userWeightEarthX;
    private Button buttonX;
    private TextView answerX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Associated variables
        infoX = (TextView)findViewById(R.id.infoX);
        userWeightEarthX = (EditText)findViewById(R.id.userWeightEarthX);
        buttonX=(Button)findViewById(R.id.buttonX);
        answerX = (TextView)findViewById(R.id.answerX);

        buttonX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float currentUserWeight = Float.parseFloat(userWeightEarthX.getText().toString());
                float moonWeight = (float) ((currentUserWeight/9.81)* 1.622);
                answerX.setText("Answer: "+ String.valueOf(moonWeight));
            }
        });
    }

}
