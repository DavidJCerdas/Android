package com.djcerdas.pokedextico.fragment;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.djcerdas.pokedextico.R;
import com.squareup.picasso.Picasso;

public class ShowPokemonFragment extends Fragment {
    private ImageView showPokemon;
    private TextView pokemonName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show_pokemon, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showPokemon = view.findViewById(R.id.pokemonShowImage);
        pokemonName = view.findViewById(R.id.pokemon_name);

        String pokemonNameString = ShowPokemonFragmentArgs.fromBundle(getArguments()).getPokemonName();
        pokemonName.setText(pokemonNameString.substring(0, 1).toUpperCase() + pokemonNameString.substring(1));

        runOnUiThreat(new Runnable() {
            @Override
            public void run() {
                Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png").into(showPokemon);
            }
        });

    }


    private void runOnUiThreat(Runnable runnable) {
    }

}
