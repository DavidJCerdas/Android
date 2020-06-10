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

public class OldMenuPokedex extends Fragment {
    private TextView print_var;
    private Button recycleButton;
    private Button nullDisplay;
    private Button trainerInfo;
    private Button newMenuPokedex;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.old_menu_pokedex, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycleButton = view.findViewById(R.id.recycleViewButton);
        nullDisplay = view.findViewById(R.id.displayNullButton);
        trainerInfo = view.findViewById(R.id.trainerInfoButton);
        print_var = view.findViewById(R.id.print_var);
        newMenuPokedex = view.findViewById(R.id.newMenuPokedexX);

        nullDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the Null Fragment
                NavDirections action = OldMenuPokedexDirections.oldMenuPokedexToNullDisplayFragment();
                NavHostFragment.findNavController(OldMenuPokedex.this).navigate(action);
            }
        });
        recycleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Test the Recycle view was not broken
                NavDirections action = OldMenuPokedexDirections.oldMenuPokedexToRecycleView();
                NavHostFragment.findNavController(OldMenuPokedex.this).navigate(action);
            }
        });
        trainerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = OldMenuPokedexDirections.oldMenuPokedexToPokemonTrainerInfo(OldMenuPokedexArgs.fromBundle(getArguments()).getTrainerName());
                NavHostFragment.findNavController(OldMenuPokedex.this).navigate(action);
            }
        });
        String trainerName = OldMenuPokedexArgs.fromBundle(getArguments()).getTrainerName();
        print_var.setText(trainerName);


        newMenuPokedex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = OldMenuPokedexDirections.oldMenuPokedexToNewMenuPokedex();
                NavHostFragment.findNavController(OldMenuPokedex.this).navigate(action);
            }
        });

    }
}


