package com.djcerdas.pokedextico.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.djcerdas.pokedextico.R;
import com.djcerdas.pokedextico.model.PokemonInfo;
import com.squareup.picasso.Picasso;

public class ShowPokemonFragment extends Fragment {
    private ImageView showPokemon;
    private TextView pokemonName;
    private Integer pokemonID;


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
        pokemonID = ShowPokemonFragmentArgs.fromBundle(getArguments()).getPokemonID();
        String pID = pokemonID.toString();
        Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pID + ".png").into(showPokemon);
        String pokemonNameString = ShowPokemonFragmentArgs.fromBundle(getArguments()).getPokemonName();
       pokemonName.setText(pokemonNameString);


    }


    private void runOnUiThreat(Runnable runnable) {
    }

}
