package com.djcerdas.pokedextico.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.djcerdas.pokedextico.Listener.OnPokemonClicked;
import com.djcerdas.pokedextico.R;
import com.djcerdas.pokedextico.model.PokemonInfo;

import java.util.ArrayList;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewholder> {
    private List<PokemonInfo> pokemonInfoList = new ArrayList<>();
    private  OnPokemonClicked pokemonListener;


    public PokemonAdapter(OnPokemonClicked pokemonListener) {
        this.pokemonListener = pokemonListener;
    }

    public PokemonAdapter(List<PokemonInfo> pokemonInfoList) {
        this.pokemonInfoList = pokemonInfoList;
    }

    public void setPokemonInfoList(List<PokemonInfo> pokemonInfoList) {
        this.pokemonInfoList = pokemonInfoList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PokemonViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_pokemon_item,parent,false);
        return new PokemonViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewholder holder, int position) {
         holder.bind(pokemonInfoList.get(position),pokemonListener);
    }

    @Override
    public int getItemCount() {
        return pokemonInfoList.size();
    }

    public static class PokemonViewholder extends RecyclerView.ViewHolder{
        private TextView pokemonName;
        private View isFavorite;

        public PokemonViewholder(@NonNull View itemView) {
            super(itemView);
            pokemonName = itemView.findViewById(R.id.pokemon_name);
            isFavorite = itemView.findViewById(R.id.is_favorite);
        }

        public void bind(PokemonInfo pokemonInfo, OnPokemonClicked listener){
            pokemonName.setText(pokemonInfo.getName());
            isFavorite.setActivated(pokemonInfo.getFavorite());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                listener.onClicked(pokemonInfo);
                }
            });
        }
    }

}
