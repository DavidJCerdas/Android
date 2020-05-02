package com.djcerdas.myweightonthemoon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //private TextView infoX;
    private EditText userWeightEarthX;
    private Button buttonX;
    //private TextView answerX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userWeightEarthX = (EditText)findViewById(R.id.userWeightEarthX);
        buttonX=(Button)findViewById(R.id.buttonX);
    }

    @Override
    protected void onResume() {
        super.onResume();

           buttonX.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   // Log.d("LogX", userWeightEarthX.getText().toString());
                   Intent intentX = new Intent(MainActivity.this,WeightOnTheMoon.class);
                   intentX.putExtra("WEIGHT", userWeightEarthX.getText().toString() );
                   startActivity(intentX);
                   finish();
               }
           });
    }

}
