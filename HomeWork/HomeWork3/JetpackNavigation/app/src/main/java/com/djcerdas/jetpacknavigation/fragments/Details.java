package com.djcerdas.jetpacknavigation.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.djcerdas.jetpacknavigation.R;

public class Details extends Fragment {
    private TextView result;
    private EditText currentWeight;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail,container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        result = view.findViewById(R.id.result);

        // Make the calculation of the weight on the Moon
        float currentUserWeight = DetailsArgs.fromBundle(getArguments()).getCurrentWeight();
        float moonWeight = (float) ((currentUserWeight/9.81)* 1.622);
        String finalResult = String.format("%.2f", moonWeight);

        result.setText("Answer: "+ finalResult);

    }
}
