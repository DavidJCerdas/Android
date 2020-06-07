package com.djcerdas.pokedextico.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.djcerdas.pokedextico.R;
import com.djcerdas.pokedextico.model.PokemonList;
import com.djcerdas.pokedextico.viewmodel.PokemonViewModel;

public class MenuPokedex extends Fragment {
    private TextView print_var;
    private Button recycleButton;
    private Button nullDisplay;
    private PokemonViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_pokedex, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PokemonViewModel.class);
        viewModel.getPokemonList();
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

        viewModel.getPokemonListLiveData().observe(getViewLifecycleOwner(), new Observer<PokemonList>() {
            @Override
            public void onChanged(PokemonList pokemonList) {
                Log.d("POKERROR", pokemonList.getPokemonInfoList().get(0).getName());
            }
        });
    }


}
