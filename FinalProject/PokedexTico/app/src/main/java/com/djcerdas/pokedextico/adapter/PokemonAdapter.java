package com.djcerdas.pokedextico.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.djcerdas.pokedextico.R;
import com.djcerdas.pokedextico.model.Pokemon;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewholder> {
    @NonNull
    @Override
    public PokemonViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewholder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class PokemonViewholder extends RecyclerView.ViewHolder{
        private TextView pokemonName;
        private View isFavorite;

        public PokemonViewholder(@NonNull View itemView) {
            super(itemView);
            pokemonName = itemView.findViewById(R.id.pokemon_name);
            isFavorite = itemView.findViewById(R.id.is_favorite);
        }

        public void bind(Pokemon pokemon){
            pokemonName.setText(pokemon.getName());
            isFavorite.setActivated(pokemon.getFavorite());
        }
    }

}
