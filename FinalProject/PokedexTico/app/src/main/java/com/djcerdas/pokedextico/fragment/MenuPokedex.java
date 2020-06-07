package com.djcerdas.pokedextico.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.djcerdas.pokedextico.R;

public class MenuPokedex extends Fragment {
    private TextView print_var;
    private Button recycleButton;
    private Button nullDisplay;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_pokedex, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycleButton = view.findViewById(R.id.recycleViewButton);
        nullDisplay = view.findViewById(R.id.displayNullButton);
        print_var = view.findViewById(R.id.print_var);

        nullDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the Null Fragment
                NavDirections action = MenuPokedexDirections.menuPokedexToNullDisplayFragment();
                NavHostFragment.findNavController(MenuPokedex.this).navigate(action);
            }
        });
        recycleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Test the Recycle view was not broken
                NavDirections action = MenuPokedexDirections.menuPokedexToRecycleView();
                NavHostFragment.findNavController(MenuPokedex.this).navigate(action);
            }
        });
        // Make the calculation of the weight on the Moon
        String trainerName = MenuPokedexArgs.fromBundle(getArguments()).getTrainerName();
        print_var.setText(trainerName);
    }


}
