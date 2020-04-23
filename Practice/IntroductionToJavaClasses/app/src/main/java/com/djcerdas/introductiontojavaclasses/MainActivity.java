package com.djcerdas.introductiontojavaclasses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Testing Log Class
        Log.d(TAG, "Testing log message to confirm the Pet Class has an ID:"+Pet.getId());
        Pet bold = new Pet("Bold",11,12.4f,true);
        Log.d(TAG, "Testing log message to confirm the pet: "+bold.getName()+" was created with ID:"+bold.getId());
        Pet toast = new Pet("Toast",5,5.2f,true);
        Log.d(TAG, "Testing log message to confirm the pet: "+toast.getName()+" was created with ID:"+toast.getId());
    }
}

